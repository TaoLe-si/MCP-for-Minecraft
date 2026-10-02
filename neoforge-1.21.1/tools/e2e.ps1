param(
    [switch]$UseInstalledProfile
)

$ErrorActionPreference = 'Stop'
$ProjectDir = Split-Path -Parent $PSScriptRoot
$ModDir = Join-Path $ProjectDir 'mod'
$ExampleDir = Join-Path $ProjectDir 'examples\mcmcp-e2e'
$TestModsDir = Join-Path $ProjectDir 'test-mods'
$GradleHome = $env:MC_MCP_GRADLE_USER_HOME
if ([string]::IsNullOrWhiteSpace($GradleHome)) {
    $GradleHome = Join-Path $ProjectDir '.validation\gradle-home'
}
$Wrapper = Join-Path $ModDir 'gradlew.bat'

if ($UseInstalledProfile) {
    if ([string]::IsNullOrWhiteSpace($env:MC_MCP_SOURCE_GAME_DIR)) {
        throw 'Installed-profile mode requires MC_MCP_SOURCE_GAME_DIR, MC_MCP_VERSION_ID and MC_MCP_JAVA.'
    }
    if ([string]::IsNullOrWhiteSpace($env:MC_MCP_VERSION_ID)) {
        throw 'Installed-profile mode requires MC_MCP_SOURCE_GAME_DIR, MC_MCP_VERSION_ID and MC_MCP_JAVA.'
    }
    if ([string]::IsNullOrWhiteSpace($env:MC_MCP_JAVA)) {
        throw 'Installed-profile mode requires MC_MCP_SOURCE_GAME_DIR, MC_MCP_VERSION_ID and MC_MCP_JAVA.'
    }
} else {
    Remove-Item Env:MC_MCP_SOURCE_GAME_DIR -ErrorAction SilentlyContinue
    Remove-Item Env:MC_MCP_VERSION_ID -ErrorAction SilentlyContinue
}

New-Item -ItemType Directory -Force $GradleHome, $TestModsDir | Out-Null
$env:GRADLE_USER_HOME = $GradleHome
$env:MC_MCP_GRADLE_USER_HOME = $GradleHome

& $Wrapper --no-daemon --console=plain -p $ExampleDir jar
if ($LASTEXITCODE -ne 0) {
    throw "Example mod build failed with exit code $LASTEXITCODE."
}

$ExampleJar = Join-Path $ExampleDir 'build\libs\mcmcp_e2e-0.1.0.jar'
if (-not (Test-Path -LiteralPath $ExampleJar -PathType Leaf)) {
    throw "Expected example JAR was not built: $ExampleJar"
}
Copy-Item -LiteralPath $ExampleJar -Destination $TestModsDir -Force

$NodeCommand = Get-Command node -ErrorAction Stop
& $NodeCommand.Source (Join-Path $PSScriptRoot 'e2e.mjs')
exit $LASTEXITCODE
