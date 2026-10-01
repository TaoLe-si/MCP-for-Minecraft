package com.taolesi.mcpforminecraft;

import com.taolesi.mcpforminecraft.client.ClientHooks;
import com.taolesi.mcpforminecraft.control.ControlServer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 模组入口：把"动态服务"（本地控制端口）拉起来。
 *
 * <p>端口从系统属性 {@code -Dmcpforminecraft.port} 读，默认 25585。
 * 协议见仓库里的 docs/protocol.md。
 */
@Mod(McpForMinecraft.MODID)
public final class McpForMinecraft {
    public static final String MODID = "mcpforminecraft";
    public static final Logger LOG = LoggerFactory.getLogger("MCP for Minecraft");

    public static final int DEFAULT_PORT = 25585;

    private final ControlServer server;

    public McpForMinecraft(FMLJavaModLoadingContext context) {
        // 客户端才有的东西（游戏线程、按键、截图）单独挂，专服上不加载这些类
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::init);

        int port = Integer.getInteger("mcpforminecraft.port", DEFAULT_PORT);
        this.server = new ControlServer(port);
        this.server.start();
    }
}
