
# Problem: Interesting Function

## Problem Description
You are given two integers `l` and `r`, where `l < r`. We will **add 1 to l until the result is equal to r**. Thus, there will be exactly `r - l` additions performed. For each such addition, let's look at the **number of digits that will be changed** after it.

For example:
- if `l = 909`, then adding one will result in `910` and **2 digits will be changed**
- if you add one to `l = 9`, the result will be `10` and **2 digits will also be changed**
- if you add one to `l = 489999`, the result will be `490000` and **5 digits will be changed**

**Changed digits always form a suffix** of the result written in the decimal system.

Output the **total number of changed digits**, if you want to get `r` from `l`, adding `1` each time.

## Input Format
The first line contains an integer `t` (`1 ≤ t ≤ 10^4`). Then `t` test cases follow.

Each test case is characterized by **two integers l and r** (`1 ≤ l < r ≤ 10^9`).

## Output Format
For each test case, calculate the **total number of changed digits** if you want to get `r` from `l`, adding one each time.

## Examples

### Input

`4`<br/>
`1 9`<br/>
`9 10`<br/>
`10 20`<br/>
`1 1000000000`<br/>

### Output

`8`<br/>
`2`<br/>
`11`<br/>
`1111111110`<br/>

## Constraints
- **1 ≤ t ≤ 10^4** (number of test cases)
- **1 ≤ l < r ≤ 10^9** (range values)
- Exactly **r - l additions** will be performed

## Notes
- Changed digits always form a **suffix of the result**
- When incrementing a number, the number of changed digits depends on how many trailing 9s need to carry over
- For example: `999 + 1 = 1000` changes 4 digits (all digits change)

