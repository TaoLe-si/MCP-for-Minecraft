# Bindings

> `net.minecraftforge.fml.Bindings` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/Bindings.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Used to allow access to certain things from the game layer

## 公开成员（3 个）

```java
public static Supplier<IEventBus> getForgeBus()
```
源码 :32 — @return A supplier of net.minecraftforge.common.MinecraftForge#EVENT_BUS

```java
public static Supplier<I18NParser> getMessageParser()
```
源码 :36 —（无 javadoc）

```java
public static Supplier<IConfigEvent.ConfigConfig> getConfigConfiguration()
```
源码 :40 —（无 javadoc）

