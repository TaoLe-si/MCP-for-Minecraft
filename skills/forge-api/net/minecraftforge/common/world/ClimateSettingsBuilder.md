# ClimateSettingsBuilder

> `net.minecraftforge.common.world.ClimateSettingsBuilder` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/world/ClimateSettingsBuilder.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Builder for ClimateSettings.

## 公开成员（11 个）

```java
public static ClimateSettingsBuilder copyOf(ClimateSettings settings)
```
源码 :25 — @param settings Existing ClimateSettings. @return A new builder with a copy of that ClimateSettings's values.

```java
public static ClimateSettingsBuilder create(boolean hasPrecipitation, float temperature, TemperatureModifier temperatureModifier, float downfall)
```
源码 :40 — @param hasPrecipitation Synced to clients, determines weather effects @param temperature Synced to clients, affects foliage color, freezing, and weather effects. Vanilla values are in the range [-0.5, 2.0] @param temperatureModifier Synced to clients, applies a positional modifier to temperature. Fr…

```java
public ClimateSettings build()
```
源码 :56 — @return A new ClimateSettings with the finalized values.

```java
public boolean hasPrecipitation()
```
源码 :64 — @return Synced to clients, determines weather effects.

```java
public void setHasPrecipitation(boolean hasPrecipitation)
```
源码 :72 — @param hasPrecipitation Synced to clients, determines weather effects.

```java
public float getTemperature()
```
源码 :81 — Synced to clients, affects foliage color, freezing, and weather effects Vanilla values are in the range [-0.5, 2.0].

```java
public void setTemperature(float temperature)
```
源码 :90 — @param temperature Synced to clients, affects foliage color, freezing, and weather effects. Vanilla values are in the range [-0.5, 2.0].

```java
public TemperatureModifier getTemperatureModifier()
```
源码 :99 — temperatureModifier Synced to clients, applies a positional modifier to temperature. Frozen Oceans use this to have occasional warm patches.

```java
public void setTemperatureModifier(TemperatureModifier temperatureModifier)
```
源码 :108 — @param temperatureModifier Synced to clients, applies a positional modifier to temperature. Frozen Oceans use this to have occasional warm patches.

```java
public float getDownfall()
```
源码 :117 — Synced to clients, affects foliage color. Biomes with downfall > 0.85 count as humid, inhibiting fire spread.

```java
public void setDownfall(float downfall)
```
源码 :126 — @param downfall Synced to clients, affects foliage color. Biomes with downfall > 0.85 count as humid, inhibiting fire spread.

