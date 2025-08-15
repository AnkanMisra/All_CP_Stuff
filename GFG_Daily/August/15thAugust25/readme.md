

# Problem: Insert Interval

## Problem Description
Geek has an array of **non-overlapping intervals** `intervals[][]`, where `intervals[i] = [start_i, end_i]` represents the start and end of the `i`-th event. The array is **sorted in ascending order by `start_i`**. You are also given a new interval `newInterval[] = [newStart, newEnd]`.

Your task is to **insert `newInterval` into `intervals`** such that:
- The final list remains **sorted by start value**.
- There are **no overlapping intervals** after insertion (merge any that overlap).

Return the updated list of intervals.

## Input Format
- The first line contains an integer **`n`** — the number of existing intervals.
- The next **`n`** lines each contain two integers: **`start_i`** and **`end_i`**.
- The last line contains two integers: **`newStart`** and **`newEnd`** representing the new interval.

## Output Format
Print the updated list of intervals after inserting and merging, in the same format: each interval as `[start, end]` separated by spaces.

## Examples

### Input
`4`<br/>
`1 3`<br/>
`4 5`<br/>
`6 7`<br/>
`8 10`<br/>
`5 6`

### Output
`[1, 3] [4, 7] [8, 10]`

### Input
`5`<br/>
`1 2`<br/>
`3 5`<br/>
`6 7`<br/>
`8 10`<br/>
`12 16`<br/>
`4 9`

### Output
`[1, 2] [3, 10] [12, 16]`

## Constraints
- **`1 ≤ n ≤ 10^5`**
- **`0 ≤ start_i ≤ end_i ≤ 10^9`**
- **`0 ≤ newStart ≤ newEnd ≤ 10^9`**

## Notes
- The solution should run in **O(n)** time, where `n` is the number of intervals.


