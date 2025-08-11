
# Problem: Table Decorations

## Problem Description
You have `r` red, `g` green and `b` blue balloons. To decorate a single table for the banquet you need **exactly three balloons**. **Three balloons attached to some table shouldn't have the same color**. What **maximum number** `t` of tables can be decorated if we know number of balloons of each color?

Your task is to write a program that for given values `r`, `g` and `b` will find the **maximum number** `t` of tables, that can be decorated in the required manner.

## Input Format
The single line contains **three integers** `r`, `g` and `b` — the number of red, green and blue balloons respectively. The numbers are separated by exactly one space.

## Output Format
Print a single integer `t` — the **maximum number of tables** that can be decorated in the required manner.

## Examples

### Input

`5 4 3`<br/>

### Output

`4`<br/>

### Input

`1 1 1`<br/>

### Output

`1`<br/>

### Input

`2 3 3`<br/>

### Output

`2`<br/>

## Constraints
`0 ≤ r, g, b ≤ 2·10^9`

## Notes
In the first sample you can decorate the tables with the following balloon sets: **"rgg", "gbb", "brr", "rrg"**, where "r", "g" and "b" represent the red, green and blue balls, respectively.

