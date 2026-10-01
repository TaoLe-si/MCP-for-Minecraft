# IEntityAdditionalSpawnData

> `net.minecraftforge.entity.IEntityAdditionalSpawnData` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/entity/IEntityAdditionalSpawnData.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：A interface for Entities that need extra information to be communicated between the server and client when they are spawned.

## 公开成员（2 个）

```java
void writeSpawnData(FriendlyByteBuf buffer)
```
源码 :22 — Called by the server when constructing the spawn packet. Data should be added to the provided stream. @param buffer The packet data stream

```java
void readSpawnData(FriendlyByteBuf additionalData)
```
源码 :30 — Called by the client when it receives a Entity spawn packet. Data should be read out of the stream in the same way as it was written. @param additionalData The packet data stream

