# Build, run and validate

## Requirements

Install a Java 21 JDK and Node.js 20 or later. Confirm `java -version` reports 21 and `node --version` reports 20 or newer. The project includes its Gradle Wrapper; no global Gradle installation is required.

## Build the bridge mod

From `neoforge-1.21.1/mod`:

```powershell
.\gradlew.bat compileJava jar --no-daemon --no-configuration-cache --max-workers=1
```

The main development run configurations are `runClient` and `runGameTestServer`. They use this mod source set and write generated files under `mod/run/`.

## Start the MCP server

From `neoforge-1.21.1`, start `node .\tools\mcmcp.mjs` as a stdio MCP server. When connected to an AI client, configure the executable as `node`, pass the absolute path to `tools/mcmcp.mjs`, and set the environment values described below in that MCP server's process configuration.

With no installed-profile variables, `mc_start_client` runs the Gradle development client. It automatically creates a uniquely named disposable single-player world beneath `mod/run/client/` and waits until the world and bridge are ready.

To test against the installed NeoForge 21.1.235 profile, set:

```powershell
$env:MC_MCP_SOURCE_GAME_DIR = Join-Path $env:APPDATA '.minecraft'
$env:MC_MCP_VERSION_ID = '1.21.1-NeoForge_21.1.235'
$env:MC_MCP_JAVA = (Get-Command java).Source
node .\tools\mcmcp.mjs
```

If the launcher uses a custom game directory, set `MC_MCP_SOURCE_GAME_DIR` to that directory. The directory must contain the selected version's JSON, libraries and assets. `MC_MCP_JAVA` must resolve to Java 21. The launcher copies the profile's `mods/` and `config/` into `.validation/game-dir`; it creates a fresh test world and does not copy saves.

`tools/run-mcp.ps1` is a Windows helper for the default `%APPDATA%\.minecraft` profile. For a non-default launcher directory, pass `-GameDir`.

## Build the validation mod

The independent `examples/mcmcp-e2e` mod registers `mcmcp_e2e:probe_block` and `mcmcp_e2e:probe_wand`. Its NeoForge GameTest checks that the wand changes the block's `active` state. From `neoforge-1.21.1/mod`:

```powershell
.\gradlew.bat -p ..\examples\mcmcp-e2e compileJava jar --no-daemon --no-configuration-cache --max-workers=1
Copy-Item ..\examples\mcmcp-e2e\build\libs\mcmcp_e2e-0.1.0.jar ..\test-mods\ -Force
```

Top-level JAR files in `test-mods/` are loaded as local runtime mods by `runClient` and copied into the isolated installed-profile client. The MCP launcher rejects duplicate filenames that conflict with profile mods. Keep test dependencies in that directory when a mod requires them; JARs are ignored by Git.

The development client enables NeoForge GameTests and includes the `minecraft` and `mcmcp` template-resource namespaces. It exposes a bridge smoke test through `mc_game_test`; the example mod's wand behavior is separately exercised by its own `runGameTestServer` workflow above. To include other test template namespaces, pass a comma-separated override such as `-Pmcmcp.gametestNamespaces=minecraft,mcmcp,my_mod`. Minecraft 1.21.1 reads structure templates from `data/<namespace>/structure/`.

## End-to-end acceptance

From `neoforge-1.21.1`, run:

```powershell
.\tools\e2e.ps1
```

The script builds the example and bridge, launches the MCP stdio server and validation client, checks the live mod and registry, moves the instance player through the client API, checks the GameTest registration and runs it in a development client, then stops the game. For an installed profile, set `MC_MCP_SOURCE_GAME_DIR`, `MC_MCP_VERSION_ID`, and `MC_MCP_JAVA` first, then run `.\tools\e2e.ps1 -UseInstalledProfile`. In that mode GameTests are skipped because the installed production launch does not register them; the script still checks client startup, registries and player control.

To run the example test directly with NeoForge's GameTest server, from `neoforge-1.21.1/mod` run:

```powershell
.\gradlew.bat -p ..\examples\mcmcp-e2e runGameTestServer --no-daemon --no-configuration-cache --max-workers=1
```

The first run may need to download Minecraft assets. Confirm a per-test pass line in the server log; task startup by itself is not proof of a passing GameTest.
