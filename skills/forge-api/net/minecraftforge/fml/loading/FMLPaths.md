# FMLPaths

> `net.minecraftforge.fml.loading.FMLPaths` · enum · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/FMLPaths.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目用法**：拿游戏目录（读 logs/latest.log 用）

**职责**：源码没有 javadoc，看下面的成员自行判断。

## 公开成员（6 个）

```java
enum 常量 GAMEDIR(), MODSDIR("mods"), CONFIGDIR("config"), FMLCONFIG(false, CONFIGDIR, "fml.toml")
```
源码 :22 —（无 javadoc）

```java
public static void setup(IEnvironment env)
```
源码 :51 —（无 javadoc）

```java
public static void loadAbsolutePaths(Path rootPath)
```
源码 :57 —（无 javadoc）

```java
public static Path getOrCreateGameRelativePath(Path path)
```
源码 :77 —（无 javadoc）

```java
public Path relative()
```
源码 :91 —（无 javadoc）

```java
public Path get()
```
源码 :95 —（无 javadoc）

