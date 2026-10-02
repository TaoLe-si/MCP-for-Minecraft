# Local validation mods

Place built mod JARs in this directory to load them into the isolated client started by the MCP server. Gradle `runClient` adds these JARs to its local runtime; the installed-profile launcher copies only top-level `*.jar` files into the isolated profile and rejects filenames that conflict with copied profile mods. This directory is for local test artifacts; JARs are ignored by Git.

The tracked `examples/mcmcp-e2e` project is the repository's small registration/interaction test mod. `tools/e2e.ps1` builds it and stages its JAR here before running the MCP end-to-end check.
