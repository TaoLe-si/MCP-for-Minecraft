# InterModComms

> `net.minecraftforge.fml.InterModComms` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/InterModComms.java` · `fmlcore-1.20.1-47.4.10`（fmlcore-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（5 个）

```java
public record IMCMessage(String senderModId, String modId, String method, Supplier<?> messageSupplier)
```
源码 :22 —（无 javadoc）

```java
public static boolean sendTo(final String modId, final String method, final Supplier<?> thing)
```
源码 :74 — Send IMC to remote. Sender will default to the active modcontainer, or minecraft if not. @param modId the mod id to send to @param method the method name to send @param thing the thing associated with the method name @return true if the message was enqueued for sending (the target modid is loaded)

```java
public static boolean sendTo(final String senderModId, final String modId, final String method, final Supplier<?> thing)
```
源码 :89 — Send IMC to remote. @param senderModId the mod id you are sending from @param modId the mod id to send to @param method the method name to send @param thing the thing associated with the method name @return true if the message was enqueued for sending (the target modid is loaded)

```java
public static Stream<IMCMessage> getMessages(final String modId, final Predicate<String> methodMatcher)
```
源码 :102 — Retrieve pending messages for your modid. Use the predicate to filter the method name. @param modId the modid you are querying for @param methodMatcher a predicate for the method you are interested in @return All messages passing the supplied method predicate

```java
public static Stream<IMCMessage> getMessages(final String modId)
```
源码 :114 — Retrieve all message for your modid. @param modId the modid you are querying for @return All messages

