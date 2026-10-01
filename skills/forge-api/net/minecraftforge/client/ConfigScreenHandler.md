# ConfigScreenHandler

> `net.minecraftforge.client.ConfigScreenHandler` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ConfigScreenHandler.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（2 个）

```java
public record ConfigScreenFactory(BiFunction<Minecraft, Screen, Screen> screenFunction) implements IExtensionPoint<ConfigScreenFactory>
```
源码 :27 — @param screenFunction A function that takes the Minecraft client instance and the mods screen as arguments and returns your config screen to show when the player clicks the config button for your mod on the mods screen. You should call Minecraft#setScreen(Screen) with the provided client instance an…

```java
public static Optional<BiFunction<Minecraft, Screen, Screen>> getScreenFactoryFor(IModInfo selectedMod)
```
源码 :40 — @param screenFunction A function that takes the mods screen as an argument and returns your config screen to show when the player clicks the config button for your mod on the mods screen. You should call Minecraft#setScreen(Screen) with the provided mods screen for the action of your close button, u…

