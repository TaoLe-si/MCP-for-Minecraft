# ExtendedButton

> `net.minecraftforge.client.gui.widget.ExtendedButton` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/widget/ExtendedButton.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This class provides a button that fixes several bugs present in the vanilla GuiButton drawing code. The gist of it is that it allows buttons of any size without gaps in the graphics and with the borders drawn properly. It also prevents button text from extending out of the sides of the button by trimming the end of the string and adding an ellipsis. The code that handles drawing the button is in G…

## 公开成员（4 个）

```java
public ExtendedButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler)
```
源码 :30 —（无 javadoc）

```java
public ExtendedButton(int xPos, int yPos, int width, int height, Component displayString, OnPress handler, CreateNarration createNarration)
```
源码 :35 —（无 javadoc）

```java
public ExtendedButton(Button.Builder builder)
```
源码 :40 —（无 javadoc）

```java
public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
```
源码 :49 —（无 javadoc）

