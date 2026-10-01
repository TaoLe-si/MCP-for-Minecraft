# LoginWrapper

> `net.minecraftforge.network.LoginWrapper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/network/LoginWrapper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**——网络包自定义：进程外的发送端拿不到 Netty 通道（见 protocol.md 第 7 节）

**职责**（源码 javadoc）：Wrapper for custom login packets. Transforms unnamed login channel messages into channels dispatched the same as regular custom packets.

## 公开成员（1 个）

```java
public static final ResourceLocation WRAPPER = new ResourceLocation("fml:loginwrapper")
```
源码 :26 —（无 javadoc）

