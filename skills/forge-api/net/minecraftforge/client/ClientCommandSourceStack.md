# ClientCommandSourceStack

> `net.minecraftforge.client.ClientCommandSourceStack` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/ClientCommandSourceStack.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：overrides for CommandSourceStack so that the methods will run successfully client side

## 公开成员（13 个）

```java
public ClientCommandSourceStack(CommandSource source, Vec3 position, Vec2 rotation, int permission, String plainTextName, Component displayName, Entity executing)
```
源码 :38 —（无 javadoc）

```java
public void sendSuccess(Supplier<Component> message, boolean sendToAdmins)
```
源码 :48 —（无 javadoc）

```java
public Collection<String> getAllTeams()
```
源码 :57 —（无 javadoc）

```java
public Collection<String> getOnlinePlayerNames()
```
源码 :66 —（无 javadoc）

```java
public Stream<ResourceLocation> getRecipeNames()
```
源码 :75 —（无 javadoc）

```java
public Set<ResourceKey<Level>> levels()
```
源码 :84 —（无 javadoc）

```java
public RegistryAccess registryAccess()
```
源码 :93 —（无 javadoc）

```java
public Scoreboard getScoreboard()
```
源码 :102 —（无 javadoc）

```java
public Advancement getAdvancement(ResourceLocation id)
```
源码 :111 —（无 javadoc）

```java
public RecipeManager getRecipeManager()
```
源码 :120 —（无 javadoc）

```java
public Level getUnsidedLevel()
```
源码 :129 —（无 javadoc）

```java
public MinecraftServer getServer()
```
源码 :139 —（无 javadoc）

```java
public ServerLevel getLevel()
```
源码 :149 —（无 javadoc）

