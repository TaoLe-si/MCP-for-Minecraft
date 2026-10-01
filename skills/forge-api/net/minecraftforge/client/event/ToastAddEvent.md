# ToastAddEvent

> `net.minecraftforge.client.event.ToastAddEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/event/ToastAddEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Fired when the client queues a Toast message to be shown onscreen. Toasts are small popups that appear on the top right of the screen, for certain actions such as unlocking Advancements and Recipes. This event is Cancelable cancellable, and does not HasResult have a result. Cancelling the event stops the toast from being queued, which means it never renders. This event is fired on the MinecraftFor…

## 公开成员（2 个）

```java
public ToastAddEvent(Toast toast)
```
源码 :29 —（无 javadoc）

```java
public Toast getToast()
```
源码 :34 —（无 javadoc）

