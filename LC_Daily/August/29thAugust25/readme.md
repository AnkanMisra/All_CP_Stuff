
# Problem: Alice and Bob Playing Flower Game

## Problem Description
Alice and Bob are playing a **turn-based game** on a field with **two lanes of flowers** between them. There are `x` flowers in the first lane and `y` flowers in the second lane.

![3021.png](https://assets.leetcode.com/uploads/2025/08/27/3021.png)

The game proceeds as follows:
- **Alice takes the first turn**
- In each turn, a player must **choose either one lane and pick one flower** from that side
- At the end of the turn, if there are **no flowers left at all**, the current player **captures their opponent and wins** the game

Given two integers `n` and `m`, compute the number of possible pairs `(x, y)` that satisfy:
- **Alice must win** the game according to the described rules
- The number of flowers `x` in the first lane must be in the range **[1, n]**
- The number of flowers `y` in the second lane must be in the range **[1, m]**

## Input Format
Two integers `n` and `m` representing the **maximum number of flowers** in each lane.

## Output Format
Return the **number of possible pairs** `(x, y)` that satisfy the conditions.

## Examples

### Input
`n = 3, m = 2`<br/>

### Output
`3`<br/>

**Explanation:** The following pairs satisfy the conditions: `(1,2)`, `(3,2)`, `(2,1)`.

### Input
`n = 1, m = 1`<br/>

### Output
`0`<br/>

**Explanation:** No pairs satisfy the conditions.

## Constraints
- **1 <= n, m <= 10^5**

## Notes
For Alice to win, she must make the **last move**. Since Alice goes first, she wins when the **total number of flowers is odd**.

