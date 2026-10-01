# SimpleTicket

> `net.minecraftforge.common.ticket.SimpleTicket` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/ticket/SimpleTicket.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Common class for a simple ticket based system. @param The type that will be used to check if your ticket matches

## 公开成员（10 个）

```java
protected boolean isValid = false
```
源码 :23 —（无 javadoc）

```java
public final void setManager(@NotNull ITicketManager<T> masterManager, @NotNull ITicketManager<T>... dummyManagers)
```
源码 :31 —（无 javadoc）

```java
public boolean isValid()
```
源码 :41 — Checks if your ticket is still registered in the system.

```java
public void invalidate()
```
源码 :50 — Removes the ticket from the managing system. After this call, any calls to #isValid() should return false unless it is registered again using #validate()

```java
public boolean unload(ITicketManager<T> unloadingManager)
```
源码 :66 — Called by the managing system when a ticket wishes to unload all of it's tickets, e.g. on chunk unload The ticket must not remove itself from the manager that is calling the unload! The ticket must ensure that it removes itself from all of it's dummies when returning true @param unloadingManager The…

```java
public void validate()
```
源码 :83 — Re-adds your ticket to the system.

```java
public abstract boolean matches(T toMatch)
```
源码 :92 —（无 javadoc）

```java
protected final void forEachManager(Consumer<ITicketManager<T>> consumer)
```
源码 :96 —（无 javadoc）

```java
protected final ITicketManager<T> getMasterManager()
```
源码 :106 —（无 javadoc）

```java
protected final ITicketManager<T>[] getDummyManagers()
```
源码 :111 —（无 javadoc）

