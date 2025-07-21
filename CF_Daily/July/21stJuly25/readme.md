
# Problem: Little Girl and Maximum Sum

## Problem Description
You are given an array of `n` elements (indexed from 1). There are `q` queries, each defined by a pair of integers `li`, `ri` (`1 ≤ li ≤ ri ≤ n`). For each query, you need to find the sum of elements of the array with indexes from `li` to `ri`, inclusive.

The little girl finds this problem boring and decides to reorder the array elements before answering the queries, in a way that **maximizes the total sum of all query replies**. Your task is to find the value of this **maximum possible sum**.

## Input Format
- The first line contains two space-separated integers: **`n`** (number of elements in the array) and **`q`** (number of queries).
- The second line contains `n` space-separated integers: **`a_i`** (the elements of the array).
- Each of the next `q` lines contains two space-separated integers: **`li`** and **`ri`** (the bounds of the i-th query).

## Output Format
- Print a single integer — the **maximum sum of all query replies** after optimally reordering the array elements.

## Examples

### Input
`3 3`
`5 3 2`
`1 2`
`2 3`
`1 3`<br/>

### Output
`25`<br/>

### Input
`5 3`
`5 2 4 1 3`
`1 5`
`2 3`
`2 3`<br/>

### Output
`33`<br/>

## Constraints
- `1 ≤ n ≤ 2⋅10^5`
- `1 ≤ q ≤ 2⋅10^5`
- `1 ≤ a_i ≤ 2⋅10^5`
- `1 ≤ li ≤ ri ≤ n`

## Notes
- You can reorder the array elements in any way before answering the queries.
- The goal is to **maximize the sum of all query answers** by choosing the best possible order of the array.

