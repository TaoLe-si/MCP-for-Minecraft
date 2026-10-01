# ScreenshotEvent

> `net.minecraftforge.client.event.ScreenshotEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ScreenshotEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when a screenshot is taken, but before it is written to disk. This event is Cancelable cancellable, and does not HasResult have a result. If this event is cancelled, then the screenshot is not written to disk, and the message in the event will be posted to the player's chat. This event is fired on the MinecraftForge#EVENT_BUS main Forge event bus, only on the LogicalSide#CLIENT logical clien…

## 公开成员（8 个）

```java
public static final Component DEFAULT_CANCEL_REASON = Component.literal("Screenshot canceled")
```
源码 :35 —（无 javadoc）

```java
public ScreenshotEvent(NativeImage image, File screenshotFile)
```
源码 :43 —（无 javadoc）

```java
public NativeImage getImage()
```
源码 :58 — the in-memory image of the screenshot

```java
public File getScreenshotFile()
```
源码 :66 — @return the file where the screenshot will be saved to

```java
public void setScreenshotFile(File screenshotFile)
```
源码 :76 — Sets the new file where the screenshot will be saved to. @param screenshotFile the new filepath

```java
public Component getResultMessage()
```
源码 :84 — the custom cancellation message, or `null` if no custom message is set

```java
public void setResultMessage(Component resultMessage)
```
源码 :95 — Sets the new custom cancellation message used to inform the player. It may be `null`, in which case the #DEFAULT_CANCEL_REASON default cancel reason will be used. @param resultMessage the new result message

```java
public Component getCancelMessage()
```
源码 :108 — Returns the cancellation message to be used in informing the player. If there is no custom message given (#getResultMessage() returns `null`), then the message will be the #DEFAULT_CANCEL_REASON default cancel reason message. @return the cancel message for the player

