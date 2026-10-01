# OnlyIn

> `net.minecraftforge.api.distmarker.OnlyIn` · @interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/api/distmarker/OnlyIn.java` · `forgespi-3.0.0`（forgespi-3.0.0-sources.jar）

**本项目用法**：标注只在某一侧存在的类（原版大量使用）

**职责**（源码 javadoc）：Marks the associated element as being only available on a certain Dist. Classes, fields, methods and constructors can be marked as only available in a specific distribution based on the presence of this annotation. This is generally meant for internal Forge and FML use only and modders should avoid its use whenever possible. Note, this will only apply to the direct element marked. This code: `@Onl…

## 公开成员（2 个）

```java
public Dist value()
```
源码 :49 —（无 javadoc）

```java
public Class<?> _interface() default Object.class
```
源码 :56 — Only valid on Type definitions. Marks a interface the class implements as only being available on the specific distribution. This does not propagate down to that interfaces methods, as the class doesn't exist so it's methods can't be determined.

