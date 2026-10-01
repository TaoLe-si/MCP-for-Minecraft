# IClientMobEffectExtensions

> `net.minecraftforge.client.extensions.common.IClientMobEffectExtensions` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/extensions/common/IClientMobEffectExtensions.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：LogicalSide#CLIENT Client-only extensions to MobEffect. @see MobEffect#initializeClient(Consumer)

## 公开成员（7 个）

```java
static IClientMobEffectExtensions of(MobEffectInstance instance)
```
源码 :26 —（无 javadoc）

```java
static IClientMobEffectExtensions of(MobEffect effect)
```
源码 :31 —（无 javadoc）

```java
default boolean isVisibleInInventory(MobEffectInstance instance)
```
源码 :41 — Queries whether the given effect should be shown in the player's inventory. By default, this returns `true`.

```java
default boolean isVisibleInGui(MobEffectInstance instance)
```
源码 :51 — Queries whether the given effect should be shown in the HUD. By default, this returns `true`.

```java
default boolean renderInventoryIcon(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset)
```
源码 :68 — Renders the icon of the specified effect in the player's inventory. This can be used to render icons from your own texture sheet. @param instance The effect instance @param screen The effect-rendering screen @param guiGraphics The gui graphics @param x The x coordinate @param y The y coordinate @par…

```java
default boolean renderInventoryText(MobEffectInstance instance, EffectRenderingInventoryScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset)
```
源码 :84 — Renders the text of the specified effect in the player's inventory. @param instance The effect instance @param screen The effect-rendering screen @param guiGraphics The gui graphics @param x The x coordinate @param y The y coordinate @param blitOffset The blit offset @return true to prevent default…

```java
default boolean renderGuiIcon(MobEffectInstance instance, Gui gui, GuiGraphics guiGraphics, int x, int y, float z, float alpha)
```
源码 :102 — Renders the icon of the specified effect on the player's HUD. This can be used to render icons from your own texture sheet. @param instance The effect instance @param gui The gui @param guiGraphics The gui graphics @param x The x coordinate @param y The y coordinate @param z The z depth @param alpha…

