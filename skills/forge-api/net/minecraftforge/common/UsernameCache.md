# UsernameCache

> `net.minecraftforge.common.UsernameCache` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/UsernameCache.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Caches player's last known usernames Modders should use #getLastKnownUsername(UUID) to determine a players last known username. For convenience, #getMap() is provided to get an immutable copy of the caches underlying map.

## 公开成员（7 个）

```java
protected static void setUsername(UUID uuid, String username)
```
源码 :61 — Set a player's current usernamee @param uuid the player's java.util.UUID @param username the player's username

```java
protected static boolean removeUsername(UUID uuid)
```
源码 :79 — Remove a player's username from the cache @param uuid the player's java.util.UUID @return if the cache contained the user

```java
public static String getLastKnownUsername(UUID uuid)
```
源码 :103 —（无 javadoc）

```java
public static boolean containsUUID(UUID uuid)
```
源码 :116 — Check if the cache contains the given player's username @param uuid the player's java.util.UUID @return if the cache contains a username for the given player

```java
public static Map<UUID, String> getMap()
```
源码 :127 — Get an immutable copy of the cache's underlying map @return the map

```java
protected static void save()
```
源码 :135 — Save the cache to file

```java
protected static void load()
```
源码 :143 — Load the cache from file

