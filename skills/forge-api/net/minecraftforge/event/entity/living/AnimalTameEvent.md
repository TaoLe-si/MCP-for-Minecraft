# AnimalTameEvent

> `net.minecraftforge.event.entity.living.AnimalTameEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/living/AnimalTameEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This event is fired when an Animal is tamed. It is fired via ForgeEventFactory#onAnimalTame(Animal,. Forge fires this event for applicable vanilla animals, mods need to fire it themselves. This event is net.minecraftforge.eventbus.api.Cancelable. If canceled, taming the animal will fail. This event is fired on the MinecraftForge#EVENT_BUS.

## 公开成员（3 个）

```java
public AnimalTameEvent(Animal animal, Player tamer)
```
源码 :27 —（无 javadoc）

```java
public Animal getAnimal()
```
源码 :34 —（无 javadoc）

```java
public Player getTamer()
```
源码 :39 —（无 javadoc）

