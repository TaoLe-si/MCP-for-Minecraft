# NeoForge 1.21.1 MCP bridge

This is an additive NeoForge client bridge for Minecraft Java 1.21.1. It does not replace the existing Forge 1.20.1 project.

## Support and design

- Minecraft Java 1.21.1, NeoForge 21.1.235, Java 21.
- The in-process client mod exposes a loopback-only, bearer-token-protected HTTP bridge. The Node MCP server owns a fixed local game directory and starts or stops the client.
- MCP actions execute on the Minecraft client thread. Player movement uses the game's key mappings and tick loop; block use goes through `MultiPlayerGameMode`. No OS mouse/keyboard injection or computer-use is involved.
- The bridge can inspect live block, item, and entity-type registries; read player, inventory, block and world state; control the current instance player; capture a game-rendered screenshot; and read client logs.
- Destructive or world-changing actions are scoped to the isolated local single-player test world. The bridge does not accept arbitrary shell commands or filesystem paths from MCP tool arguments.

## MCP tools

`mc_start_client`, `mc_stop_client`, `mc_client_status`, `mc_client_logs`, `mc_build`, `mc_build_status`, `mc_cancel_build`, `mc_runtime_info`, `mc_registry_list`, `mc_player_state`, `mc_player_action`, `mc_player_give_item`, `mc_interact_block`, `mc_block_inspect`, `mc_world_inspect`, `mc_world_setup`, `mc_game_test`, and `mc_screenshot`.

`mc_game_test` lists and runs registered NeoForge GameTests in a local integrated test world. NeoForge does not register GameTests in the installed production client profile used for the end-to-end check; in that profile the tool reports that no tests are available. Run automated `@GameTest` methods with the Gradle `runGameTestServer` task in a development environment.

## Build

Use a Java 21 JDK. From this directory in PowerShell:

```powershell
$env:JAVA_HOME = 'C:\Path\To\jdk-21'
.\gradlew.bat compileJava jar --no-daemon --no-configuration-cache --max-workers=1
.\gradlew.bat -p .\examples\mcmcp-e2e compileJava jar --no-daemon --no-configuration-cache --max-workers=1
```

The example mod registers `mcmcp_e2e:probe_block` and `mcmcp_e2e:probe_wand`. Its small GameTest checks the wand's block interaction. To load the built example in the MCP-launched isolated client, copy its JAR into `test-mods/`; only top-level JARs in that directory are copied, and filename conflicts with profile mods are rejected. JARs there are ignored by Git.

## Run against an installed 1.21.1 profile

Set the environment before starting the MCP server. `MC_MCP_SOURCE_GAME_DIR` points to the launcher data directory used as a read-only source; the server copies the selected profile's `mods` and `config` into `.validation/game-dir` and creates a new validation world there. Never point the MCP server at a valuable world for testing.

```powershell
$env:MC_MCP_SOURCE_GAME_DIR = 'D:\Java\.minecraft'
$env:MC_MCP_VERSION_ID = '1.21.1-NeoForge_21.1.235'
$env:MC_MCP_JAVA = 'C:\Program Files\Java\jdk-21\bin\java.exe'
node .\mcp-server\server.mjs
```

Configure that command as a stdio MCP server in the AI client. Start and control the game through `mc_start_client`; use `mc_client_status` and `mc_client_logs` to inspect startup, then `mc_registry_list` and the player/world tools for testing. Stop it with `mc_stop_client`.

For reproducible automated GameTests, from this project directory run:

```powershell
.\gradlew.bat -p .\examples\mcmcp-e2e runGameTestServer --no-daemon --no-configuration-cache --max-workers=1
```

The task needs the NeoForge/Minecraft assets available to Gradle. A successful client launch or an accepted `mc_game_test` request alone does not prove an automated GameTest passed; confirm the per-test result in the GameTest server log.
