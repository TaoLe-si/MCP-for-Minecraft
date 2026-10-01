# MinecraftForge

> `net.minecraftforge.common.MinecraftForge` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/MinecraftForge.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目用法**：`EVENT_BUS`：挂 TickEvent / 聊天 / 声音 / 首领条回调

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 坑

- `EVENT_BUS` 是**游戏总线**，`IModBusEvent` 那类（注册、配置、FML 生命周期）要挂 modBus，别挂错。

## 公开成员（4 个）

```java
public static final IEventBus EVENT_BUS = BusBuilder.builder().startShutdown().useModLa…
```
源码 :35 — The EventBus for all the Forge Events. Events marked with net.minecraftforge.fml.event.IModBusEvent belong on the ModBus and not this bus

```java
public static void initialize()
```
源码 :44 — Method invoked by FML before any other mods are loaded.

```java
public static void registerConfigScreen(Function<Screen, Screen> screenFunction)
```
源码 :63 — Register a config screen for the active mod container. @param screenFunction A function that takes the mods screen as an argument and returns your config screen to show when the player clicks the config button for your mod on the mods screen. You should call Minecraft#setScreen(Screen) with the prov…

```java
public static void registerConfigScreen(BiFunction<Minecraft, Screen, Screen> screenFunction)
```
源码 :77 — Register a config screen for the active mod container. @param screenFunction A function that takes the Minecraft client instance and the mods screen as arguments and returns your config screen to show when the player clicks the config button for your mod on the mods screen. You should call Minecraft…

