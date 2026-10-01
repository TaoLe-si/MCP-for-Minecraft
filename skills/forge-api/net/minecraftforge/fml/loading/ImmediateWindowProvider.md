# ImmediateWindowProvider

> `net.minecraftforge.fml.loading.ImmediateWindowProvider` · interface · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/fml/loading/ImmediateWindowProvider.java` · `fmlloader-1.20.1-47.4.10`（fmlloader-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：This is for allowing the plugging in of alternative early display implementations. They can be selected through the config value "earlyWindowProvider" which defaults to "fmlearlywindow" implemented by net.minecraftforge.fml.earlydisplay.DisplayWindow There are a few key things to keep in mind if following through on implementation. You cannot access the game state as it literally DOES NOT EXIST at…

## 公开成员（9 个）

```java
String name()
```
源码 :32 — @return The name of this window provider. Do NOT use fmlearlywindow.

```java
Runnable initialize(String[] arguments)
```
源码 :46 — This is called very early on to initialize ourselves. Use this to initialize the window and other GL core resources. One thing we want to ensure is that we try and create the highest GL_PROFILE we can accomplish. GLFW_CONTEXT_VERSION_MAJOR,GLFW_CONTEXT_VERSION_MINOR should be as high as possible on…

```java
void updateFramebufferSize(IntConsumer width, IntConsumer height)
```
源码 :54 — This will be called during the handoff to minecraft to update minecraft with the size of the framebuffer we have. Generally won't be called because Minecraft figures it out for itself. @param width Consumer of the framebuffer width @param height Consumer of the framebuffer height

```java
long setupMinecraftWindow(final IntSupplier width, final IntSupplier height, final Supplier<String> title, final LongSupplier monitor)
```
源码 :69 — This is called to setup the minecraft window, as if Mojang had done it themselves in their Window class. This handoff is difficult to get right - you have to make sure that any activities you're doing to the window are finished prior to returning. You should try and setup the width and height as Moj…

```java
boolean positionWindow(Optional<Object> monitor, IntConsumer widthSetter, IntConsumer heightSetter, IntConsumer xSetter, IntConsumer ySetter)
```
源码 :81 — This is called after window handoff to allow us to tell Mojang about our window's position. This might give a preferrable user experience to users, because we just tell Mojang our truth, rather than accept theirs. @param monitor This is the monitor we're rendering on. Note that this is the Mojang mo…

```java
<T> Supplier<T> loadingOverlay(Supplier<?> mc, Supplier<?> ri, Consumer<Optional<Throwable>> ex, boolean fade)
```
源码 :95 — Return a Supplier of an object extending the LoadingOverlay class from Mojang. This is what will be used once the Mojang window code has taken over rendering of the window, to render the later stages of the loading process. @param mc This supplies the Minecraft object @param ri This supplies the Rel…

```java
void updateModuleReads(ModuleLayer layer)
```
源码 :102 — This is called during the module loading process to allow us to find objects inside the GAME layer, such as a later loading screen. @param layer This is the GAME layer from ModLauncher

```java
void periodicTick()
```
源码 :108 — This is called periodically during the loading process to "tick" the window. It is typically the same as the Runnable from #initialize(String[])

```java
String getGLVersion()
```
源码 :116 — This is called to construct a net.minecraftforge.forgespi.locating.ForgeFeature for the GL_VERSION we managed to create for the window. Should be a string of the format {MAJOR}.{MINOR}, such as 4.6, 4.5 or such. @return the GL profile we created

