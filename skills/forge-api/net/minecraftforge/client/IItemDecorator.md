# IItemDecorator

> `net.minecraftforge.client.IItemDecorator` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/IItemDecorator.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An ItemDecorator that is used to render something on specific items, when the DurabilityBar and StackCount is rendered. Add it to an item using RegisterItemDecorationsEvent#register(ItemLike, IItemDecorator).

## 公开成员（1 个）

```java
boolean render(GuiGraphics guiGraphics, Font font, ItemStack stack, int xOffset, int yOffset)
```
源码 :27 — Is called after GuiGraphics#renderItemDecorations(Font, ItemStack, int, int, String) is done rendering. The StackCount is rendered at blitOffset+200 so use the blitOffset with caution. The RenderState during this call will be: enableTexture, enableDepthTest, enableBlend and defaultBlendFunc @return…

