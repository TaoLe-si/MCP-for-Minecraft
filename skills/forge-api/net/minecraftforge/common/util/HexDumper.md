# HexDumper

> `net.minecraftforge.common.util.HexDumper` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/HexDumper.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Utility class for creating a nice human readable dump of binary data. It might look something like this: 00 01 02 03 04 05 06 07 08 09 0A 0B 0C 0D 0E 0F ................ 69 68 67 66 65 64 63 62 61 61 6A 6B 6C 6D 6E 00 ihgfedcbaajklmn. 41 00 A. Length: 34

## 公开成员（3 个）

```java
public static String dump(ByteBuf data)
```
源码 :24 —（无 javadoc）

```java
public static String dump(byte[] data)
```
源码 :37 —（无 javadoc）

```java
public static String dump(byte[] data, int marker)
```
源码 :42 —（无 javadoc）

