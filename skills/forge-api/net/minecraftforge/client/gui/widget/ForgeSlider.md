# ForgeSlider

> `net.minecraftforge.client.gui.widget.ForgeSlider` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/gui/widget/ForgeSlider.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Slider widget implementation which allows inputting values in a certain range with optional step size.

## 公开成员（18 个）

```java
protected Component prefix
```
源码 :22 —（无 javadoc）

```java
protected Component suffix
```
源码 :23 —（无 javadoc）

```java
protected double minValue
```
源码 :25 —（无 javadoc）

```java
protected double maxValue
```
源码 :26 —（无 javadoc）

```java
protected double stepSize
```
源码 :29 — Allows input of discontinuous values with a certain step

```java
protected boolean drawString
```
源码 :31 —（无 javadoc）

```java
public ForgeSlider(int x, int y, int width, int height, Component prefix, Component suffix, double minValue, double maxValue, double currentValue, double stepSize, int precision, boolean drawString)
```
源码 :49 — @param x x position of upper left corner @param y y position of upper left corner @param width Width of the widget @param height Height of the widget @param prefix Component displayed before the value string @param suffix Component displayed after the value string @param minValue Minimum (left) valu…

```java
public ForgeSlider(int x, int y, int width, int height, Component prefix, Component suffix, double minValue, double maxValue, double currentValue, boolean drawString)
```
源码 :89 — Overload with `stepSize` set to 1, useful for sliders with whole number values.

```java
public double getValue()
```
源码 :97 — @return Current slider value as a double

```java
public long getValueLong()
```
源码 :105 — @return Current slider value as an long

```java
public int getValueInt()
```
源码 :113 — @return Current slider value as an int

```java
public void setValue(double value)
```
源码 :121 — @param value The new slider value

```java
public String getValueString()
```
源码 :127 —（无 javadoc）

```java
public void onClick(double mouseX, double mouseY)
```
源码 :133 —（无 javadoc）

```java
protected void onDrag(double mouseX, double mouseY, double dragX, double dragY)
```
源码 :139 —（无 javadoc）

```java
public boolean keyPressed(int keyCode, int scanCode, int modifiers)
```
源码 :146 —（无 javadoc）

```java
protected void updateMessage()
```
源码 :207 —（无 javadoc）

```java
protected void applyValue() {} @Override public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick)
```
源码 :220 —（无 javadoc）

