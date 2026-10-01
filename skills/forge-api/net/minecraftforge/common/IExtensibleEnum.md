# IExtensibleEnum

> `net.minecraftforge.common.IExtensibleEnum` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/IExtensibleEnum.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：To be implemented on vanilla enums that should be enhanced with ASM to be extensible. If this is implemented on a class, the class must define a static method called "create" which takes a String (enum name), and the rest of the parameters matching a constructor. For example, an enum with the constructor `MyEnum(Object foo)` would require the method: public static MyEnum create(String name, Object…

## 公开成员（1 个）

```java
default void init() {} /** * Use this instead of {@link StringRepresentable#fromEnum(Supplier)} for extensible enums because this not cache the enum values on construction */ static <E extends Enum<E> & StringRepresentable> Codec<E> createCodecForExtensibleEnum(Supplier<E[]> valuesSupplier, Function<? super String, ? extends E> enumValueFromNameFunction)
```
源码 :44 —（无 javadoc）

