# EntityMobGriefingEvent

> `net.minecraftforge.event.entity.EntityMobGriefingEvent` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/event/entity/EntityMobGriefingEvent.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：EntityMobGriefingEvent is fired when mob griefing is about to occur and allows an event listener to specify whether it should or not. This event is fired when ever the `mobGriefing` game rule is checked. This event has a HasResult: Result#ALLOW means this instance of mob griefing is allowed. Result#DEFAULT means the `mobGriefing` game rule is used to determine the behaviour. Result#DENY means this…

## 公开成员（1 个）

```java
public EntityMobGriefingEvent(Entity entity)
```
源码 :27 —（无 javadoc）

