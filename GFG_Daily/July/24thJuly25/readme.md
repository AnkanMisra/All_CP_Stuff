

# Problem: Last Moment Before All Ants Fall Out

## Problem Description
You are given a **wooden plank of length `n` units**. Some ants are walking on the plank, each moving at a speed of **1 unit per second**. Some ants move to the **left**, and others to the **right**. When two ants moving in opposite directions meet, they **change directions instantly** and continue moving. When an ant reaches either end of the plank at time `t`, it **falls out of the plank immediately**. Given the integer `n` and two integer arrays `left[]` and `right[]` representing the positions of ants moving left and right, **return the time when the last ant(s) fall out of the plank**.

## Input Format
- An integer `n` — the length of the plank.
- An integer array `left[]` — positions of ants moving to the left.
- An integer array `right[]` — positions of ants moving to the right.

## Output Format
- An integer — the time when the last ant(s) fall out of the plank.

## Examples

### Input
`n = 4, left[] = [2], right[] = [0, 1, 3]`<br/>

### Output
`4`<br/>

### Input
`n = 4, left[] = [], right[] = [0, 1, 2, 3, 4]`<br/>

### Output
`4`<br/>

### Input
`n = 3, left[] = [0], right[] = [3]`<br/>

### Output
`0`<br/>

## Constraints
- `1 ≤ n ≤ 10^5`
- `0 ≤ left.length, right.length ≤ n + 1`
- `0 ≤ left[i], right[i] ≤ n`
- `1 ≤ left.length + right.length ≤ n + 1`
- All values in `left` and `right` are **unique** and appear in only one of the two arrays.

## Notes
- **Changing direction does not take any extra time.**
- **Ants fall off immediately upon reaching the end.**

