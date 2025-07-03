# Problem: Vacations

## Problem Description
Vasya has **n days of vacations** and wants to improve his IT skills and do sport. For each day, he knows whether the gym is open and whether a contest is available. For the i-th day there are **four options**:

- `a_i = 0`: gym is **closed** and contest is **not carried out**
- `a_i = 1`: gym is **closed** and contest is **carried out** 
- `a_i = 2`: gym is **open** and contest is **not carried out**
- `a_i = 3`: gym is **open** and contest is **carried out**

On each day Vasya can either **rest**, **write the contest** (if available), or **do sport** (if gym is open).

The goal is to find the **minimum number of days** on which Vasya will have a rest. The only limitation is that Vasya **does not want to do the same activity on two consecutive days** - he will not do sport on two consecutive days, and will not write contests on two consecutive days.

## Input Format
- First line: positive integer **n** (`1 ≤ n ≤ 100`) - number of vacation days
- Second line: sequence of integers `a_1, a_2, ..., a_n` (`0 ≤ a_i ≤ 3`) separated by space

## Output Format
Print the **minimum possible number of days** on which Vasya will have a rest.

## Examples

### Input
`4`<br/>
`1 3 2 0`

### Output
`2`

### Input
`7`<br/>
`1 3 3 2 1 2 3`

### Output
`0`

### Input
`2`<br/>
`2 2`

### Output
`1`

## Constraints
- `1 ≤ n ≤ 100`
- `0 ≤ a_i ≤ 3` for all i
- **Cannot do sport on two consecutive days**
- **Cannot write contests on two consecutive days**

## Notes
- In the first example: Vasya can write the contest on day 1 and do sport on day 3, resting for **2 days** (days 2 and 4).
- In the second example: Vasya can write contests on days 1, 3, 5, 7 and do sport on days 2, 4, 6, resting for **0 days**.
- In the third example: Vasya can do sport on either day 1 or day 2, but not both consecutive days, so he rests for **1 day**.

