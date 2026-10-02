param(
    [string]$GameDir,
    [string]$VersionId = '1.21.1-NeoForge_21.1.235',
    [string]$JavaPath = $env:MC_MCP_JAVA
)

$ErrorActionPreference = 'Stop'
$ProjectDir = Split-Path -Parent $PSScriptRoot

if ([string]::IsNullOrWhiteSpace($GameDir)) {
    $GameDir = Join-Path $env:APPDATA '.minecraft'
}
if ([string]::IsNullOrWhiteSpace($JavaPath)) {
    $JavaCommand = Get-Command java -ErrorAction Stop
    $JavaPath = $JavaCommand.Source
}

$VersionJson = Join-Path $GameDir "versions\$VersionId\$VersionId.json"
if (-not (Test-Path -LiteralPath $VersionJson -PathType Leaf)) {
    throw "NeoForge version metadata not found: $VersionJson. Install NeoForge 21.1.235 in this launcher directory or pass -GameDir."
}
if (-not (Test-Path -LiteralPath $JavaPath -PathType Leaf)) {
    throw "Java executable not found: $JavaPath"
}

$env:MC_MCP_SOURCE_GAME_DIR = (Resolve-Path -LiteralPath $GameDir).Path
$env:MC_MCP_VERSION_ID = $VersionId
$env:MC_MCP_JAVA = (Resolve-Path -LiteralPath $JavaPath).Path
if ([string]::IsNullOrWhiteSpace($env:MC_MCP_GRADLE_USER_HOME)) {
    $env:MC_MCP_GRADLE_USER_HOME = Join-Path $ProjectDir '.validation\gradle-home'
}

$NodeCommand = Get-Command node -ErrorAction Stop
& $NodeCommand.Source (Join-Path $PSScriptRoot 'mcmcp.mjs')
exit $LASTEXITCODE
