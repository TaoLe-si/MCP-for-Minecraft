# NeoForge MCP protocol

The Node.js process in `tools/mcmcp.mjs` is an MCP stdio server. It talks to the in-game NeoForge mod over an ephemeral HTTP port bound only to `127.0.0.1`. Each game launch receives a fresh bearer token; the token and port are held by the MCP process and are not exposed as tool arguments.

Every RPC is queued onto the Minecraft client thread. The bridge rejects gameplay mutations unless the client is in a local integrated single-player world. The bridge does not send operating-system input events, accept shell commands, or accept arbitrary paths from tools.

## MCP tools

| Tool | Inputs | Purpose |
|---|---|---|
| `mc_start_client` | `timeoutSeconds` (10–240) | Build is not implicit. Starts the configured installed profile or Gradle `runClient`, then waits for the local world. |
| `mc_stop_client` | — | Requests orderly client shutdown and reports the exit code. |
| `mc_client_status` | — | Process, launch mode, world and bridge status. |
| `mc_client_logs` | `tailLines` (20–1000) | Latest game log, process output and newest crash report. |
| `mc_build` | `task`: `compileJava`, `jar` or `build` | Runs one allow-listed Gradle task for `mod/`. |
| `mc_build_status` | — | Build state and output tail. |
| `mc_cancel_build` | — | Stops the MCP-started Gradle process tree. |
| `mc_runtime_info` | — | Minecraft version, loaded mods, current world and player. |
| `mc_registry_list` | `registry`: `blocks`, `items` or `entities`; optional `namespace`, `prefix`, `offset`, `limit` (1–200) | Pages live registered block, item or entity-type IDs. |
| `mc_player_state` | — | Player position, view, health, game mode, inventory and crosshair target. |
| `mc_player_action` | `action` plus action-specific fields | `hold` up to 200 ticks, `release_all`, `look`, `select_slot`, or ordinary `chat`. Held controls are automatically released after their requested ticks. Slash commands are rejected. |
| `mc_inventory_state` | — | Active menu and slot contents. |
| `mc_inventory_click` | `slot`, optional `button`, `clickType` | Uses the active container's Minecraft click API; may move, swap or drop items. |
| `mc_player_give_item` | registered `itemId`, `count` (1–64) | Gives an item in the disposable local world. |
| `mc_block_inspect` | block `x`, `y`, `z` | Reads block ID, state properties and block-entity flag. It does not load chunks and only reads within 128 blocks. |
| `mc_interact_block` | block `x`, `y`, `z`, optional `face` | Uses `MultiPlayerGameMode.useItemOn` with the player's current main-hand item. Target must be loaded and within 128 blocks. |
| `mc_world_inspect` | optional `radius` (1–64), `limit` (1–100) | Lists nearby entities and the crosshair target. |
| `mc_world_setup` | `preset`: time, weather, creative or survival | Applies one fixed local-world preset. No arbitrary command string is accepted. |
| `mc_game_test` | `selector`: `list`, `all` or a registered namespaced ID | Lists or runs NeoForge GameTests in a supported development client. Installed production profiles do not register GameTests; the tool reports that state. |
| `mc_screenshot` | — | Captures the game render target and returns an MCP image. |

## Game-side HTTP RPC

The authenticated `/rpc` endpoint accepts one JSON object per POST body:

```json
{"op":"player_action","args":{"action":"hold","control":"forward","ticks":40}}
```

Supported operations are `runtime_info`, `registry_list`, `player_state`, `player_action`, `inventory_state`, `inventory_click`, `give_item`, `interact_block`, `block_at`, `world_inspect`, `world_setup`, `game_test`, and `shutdown`. The server also exposes an authenticated `/health` check used by the MCP launcher. This HTTP interface is local implementation detail; AI clients should use the MCP tools.

## Runtime boundaries

- The installed-profile launcher copies only `mods/` and `config/` into `.validation/game-dir`; it does not copy or open source saves. Validation worlds and logs stay in the ignored workspace directory.
- Registry and observation tools read the currently loaded client. Chunk reads are bounded; inspection does not generate chunks.
- Player movement uses game key mappings and tick processing. Block interaction goes through Minecraft's interaction manager so the integrated server can validate it.
- Use disposable worlds for world-changing actions. `mc_game_test` may change its test world. An accepted test request is not a pass; inspect test results in `mc_client_logs`.
