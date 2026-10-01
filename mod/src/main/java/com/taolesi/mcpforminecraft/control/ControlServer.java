package com.taolesi.mcpforminecraft.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

import com.taolesi.mcpforminecraft.McpForMinecraft;

/**
 * 动态服务的接收端：一个只绑回环地址的 TCP 服务，说换行分隔的 JSON。
 *
 * <p>只绑回环是**故意的**：这东西能让游戏里的玩家动起来，不该开给局域网。
 * 要远程用就自己套隧道（ssh -L），别有"顺手改成 0.0.0.0"的念头。
 */
public final class ControlServer {
    private final int port;
    private final AtomicInteger connections = new AtomicInteger();
    private volatile ServerSocket socket;

    public ControlServer(int port) {
        this.port = port;
    }

    public void start() {
        Thread thread = new Thread(this::acceptLoop, "mcpforminecraft-control");
        thread.setDaemon(true);
        thread.start();
    }

    private void acceptLoop() {
        try {
            ServerSocket s = new ServerSocket();
            s.setReuseAddress(true);
            // 必须点名 127.0.0.1：InetAddress#getLoopbackAddress() 在双栈机器上给的是
            // IPv6 的 ::1，绑上去之后 127.0.0.1 是连不进来的（协议里写的就是那个地址）。
            s.bind(new InetSocketAddress(InetAddress.getByName("127.0.0.1"), port));
            this.socket = s;
        } catch (IOException e) {
            McpForMinecraft.LOG.error("动态服务端口 {} 绑不上，控制通道不可用：{}", port, e.toString());
            return;
        }
        McpForMinecraft.LOG.info("动态服务在 127.0.0.1:{} 上等包（协议见 docs/protocol.md）", port);

        while (!socket.isClosed()) {
            try {
                Socket client = socket.accept();
                Thread worker = new Thread(() -> serve(client),
                        "mcpforminecraft-conn-" + connections.incrementAndGet());
                worker.setDaemon(true);
                worker.start();
            } catch (IOException e) {
                if (!socket.isClosed()) {
                    McpForMinecraft.LOG.warn("accept 失败：{}", e.toString());
                }
            }
        }
    }

    private void serve(Socket client) {
        try (Socket s = client;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(s.getInputStream(), StandardCharsets.UTF_8));
             BufferedWriter out = new BufferedWriter(
                     new OutputStreamWriter(s.getOutputStream(), StandardCharsets.UTF_8))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                // 一个包一个回包；Dispatcher 里可能会等若干个 tick
                out.write(Dispatcher.handle(line));
                out.write('\n');
                out.flush();
            }
        } catch (IOException e) {
            // 对端断了，正常现象，不值得刷日志
        }
    }
}
