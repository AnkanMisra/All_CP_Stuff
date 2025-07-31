
# Problem: Powerful Integer

## Problem Description
You are given a **2D integer array** `intervals[][]` of length `n`, where each `intervals[i] = [start, end]` represents a **closed interval** (i.e., all integers from start to end, inclusive). You are also given an integer `k`. An integer is called **Powerful** if it appears in **at least k intervals**. Find the **maximum Powerful Integer**.

**Note:** If no integer occurs at least k times return **-1**.

## Input Format

- First line contains integer `n` (number of intervals)
- Next `n` lines contain two integers each representing `intervals[i][0]` and `intervals[i][1]`
- Last line contains integer `k`

## Output Format

Return the **maximum Powerful Integer**, or **-1** if no such integer exists.

## Examples

### Example 1
**Input:** `n = 3, intervals[][] = [[1, 3], [4, 6], [3, 4]], k = 2`<br/>

**Output:** `4`<br/>

**Explanation:** Integers `3` and `4` appear in **2 intervals**. The maximum is `4`.

### Example 2
**Input:** `n = 4, intervals[][] = [[1, 4], [12, 45], [3, 8], [10, 12]], k = 3`<br/>

**Output:** `-1`<br/>

**Explanation:** **No integer appears** in at least `3` intervals.

### Example 3
**Input:** `n = 5, intervals[][] = [[16, 21], [5, 8], [12, 17], [17, 29], [9, 24]], k = 3`<br/>

**Output:** `21`<br/>

**Explanation:** Integers `16, 17, 18, 19, 20` and `21` appear in **at least 3 intervals**. The maximum is `21`.

## Constraints
- `1 ≤ n ≤ 10^5`
- `1 ≤ intervals[i][0] ≤ intervals[i][1] ≤ 10^9`
- `1 ≤ k ≤ 10^5`

