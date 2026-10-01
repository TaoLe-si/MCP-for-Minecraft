# IArmPoseTransformer

> `net.minecraftforge.client.IArmPoseTransformer` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/client/IArmPoseTransformer.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：An ArmPose that can be defined by the user. Register one by creating a custom net.minecraft.client.model.HumanoidModel.ArmPose and returning it in IClientItemExtensions#getArmPose(LivingEntity,.

## 公开成员（1 个）

```java
void applyTransform(HumanoidModel<?> model, LivingEntity entity, HumanoidArm arm)
```
源码 :32 — This method should be used to apply all wanted transformations to the player when the ArmPose is active. You can use LivingEntity#getTicksUsingItem() and LivingEntity#getUseItemRemainingTicks() for moving animations. @param model The humanoid model @param entity The humanoid entity @param arm Arm to…

