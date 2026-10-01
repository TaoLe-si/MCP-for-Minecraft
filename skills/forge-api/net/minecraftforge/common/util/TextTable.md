# TextTable

> `net.minecraftforge.common.util.TextTable` · class · Forge 1.20.1-47.4.10
> 来源：`net/minecraftforge/common/util/TextTable.java` · `mcsrc（forge 反编译源码）`（forge-1.20.1-47.4.10-sources.jar）

**本项目未直接使用**（本项目的 op 不经过这个类）

**职责**（源码 javadoc）：Utility to format data into a textual (markdown-compliant) table.

## 公开成员（11 个）

```java
public static Column column(String header)
```
源码 :23 —（无 javadoc）

```java
public static Column column(String header, Alignment alignment)
```
源码 :28 —（无 javadoc）

```java
public TextTable(List<Column> columns)
```
源码 :36 —（无 javadoc）

```java
public String build(String lineEnding)
```
源码 :41 —（无 javadoc）

```java
public void append(StringBuilder destination, String lineEnding)
```
源码 :59 — Appends the data formatted as a table to the given string builder. The padding character used for the column alignments is a single space (' '), the separate between column headers and values is a dash ('-'). Note that you *have* to specify a line ending, '\n' isn't used by default. The generated ta…

```java
public void add(@NotNull Object... values)
```
源码 :96 —（无 javadoc）

```java
public void clear()
```
源码 :112 —（无 javadoc）

```java
public List<Column> getColumns()
```
源码 :121 —（无 javadoc）

```java
public static class Column
```
源码 :126 —（无 javadoc）

```java
public static class Row
```
源码 :189 —（无 javadoc）

```java
public enum Alignment
```
源码 :203 —（无 javadoc）

