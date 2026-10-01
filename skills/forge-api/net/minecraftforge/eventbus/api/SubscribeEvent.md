# SubscribeEvent

> `net.minecraftforge.eventbus.api.SubscribeEvent` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/eventbus/api/SubscribeEvent.java` · `eventbus-6.2.33`（eventbus-6.2.33-sources.jar）

**本项目用法**：事件回调注解（注意：回调里抛异常会崩游戏）

**职责**（源码 javadoc）：Annotation to subscribe a method to an Event This annotation can only be applied to single parameter methods, where the single parameter is a subclass of Event. Use IEventBus#register(Object) to submit either an Object instance or a Class to the event bus for scanning to generate callback IEventListener wrappers. The Event Bus system generates an ASM wrapper that dispatches to the marked method.

## 坑

- **回调里抛异常 = 整局崩**：Forge 事件总线不吞异常，会一路抛到 `Minecraft.tick`。实测踩过：`PlaySoundEvent` 里读一个还没解析出 `Sound` 的实例 → NPE → 客户端崩。所以每个回调**整个函数体**都要 try/catch。

## 公开成员（2 个）

```java
EventPriority priority() default EventPriority.NORMAL
```
源码 :27 —（无 javadoc）

```java
boolean receiveCanceled() default false
```
源码 :28 —（无 javadoc）

