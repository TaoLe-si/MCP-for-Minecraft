# Minecraft MCP — NeoForge 1.21.1

This is the NeoForge counterpart to the repository's Forge 1.20.1 project. It has its own mod project, MCP server, runtime directory, validation assets and documentation; the original `mod/` project remains unchanged.

## Supported environment

- Minecraft Java 1.21.1 with NeoForge 21.1.235
- Java 21
- Node.js 20 or later for the stdio MCP server
- Gradle Wrapper 8.14, included under `mod/gradle/wrapper`

## Project layout

```text
neoforge-1.21.1/
  mod/                       NeoForge Gradle project and in-game bridge mod
    src/main/java/           Client controls and loopback RPC bridge
    src/main/resources/      NeoForge mod metadata
    gradlew[.bat]             Pinned Gradle Wrapper
  tools/                     MCP stdio server and repeatable E2E scripts
  docs/                      MCP protocol, setup and validation guide
  examples/mcmcp-e2e/        Real NeoForge registration and GameTest fixture
  test-mods/                 Local mod JARs loaded by isolated validation clients
  .validation/               Generated Gradle cache and temporary game directory
```

The MCP server starts either the Gradle `runClient` development client or the exact installed NeoForge 21.1.235 profile configured by environment variables. Both launch paths create a new disposable single-player world. Player actions run through Minecraft's client APIs; the bridge does not inject OS keyboard or mouse input.

## Quick start

Build the bridge from `neoforge-1.21.1/mod`:

```powershell
.\gradlew.bat compileJava jar --no-daemon --no-configuration-cache --max-workers=1
```

Start the stdio MCP server from `neoforge-1.21.1`:

```powershell
node .\tools\mcmcp.mjs
```

Without installed-profile environment variables, `mc_start_client` runs the development client and creates a fresh validation world. See [development and validation](docs/development.md) for installed-profile setup and the full acceptance workflow. See [the MCP protocol](docs/protocol.md) for tool schemas, limits and safety boundaries.
