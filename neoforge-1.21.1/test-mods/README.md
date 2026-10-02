# Local validation mods

Place built mod JARs in this directory to load them into the isolated client started by the MCP server. Only top-level `*.jar` files are copied, and a file name that conflicts with a mod from the selected profile is rejected. This directory is for local test artifacts; JARs are ignored by Git.

The tracked `examples/mcmcp-e2e` project is the repository's tiny registration/interaction test mod. Copy its built JAR here when running the MCP end-to-end check.
