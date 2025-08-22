

# Problem: Celex Update

## Problem Description
You are given an **infinite table** that is filled by a special function `GAZ-GIZ`, starting from the upper-left cell. The filling process assigns **consecutive positive integers** along the anti-diagonals (see figure in the statement). After the table is filled, we want to find the **number of different sums** obtainable by traveling from one cell `(x1, y1)` to another cell `(x2, y2)` while moving only **down** or **right**.

Formally, a path starts at cell `(x1, y1)` and ends at cell `(x2, y2)` (`x1 ≤ x2`, `y1 ≤ y2`). At each step you may move to the cell directly **below** `(x+1, y)` or directly **right** `(x, y+1)`. The **sum of a path** is the total of all cell values visited (including both endpoints). You must output the **count of distinct sums** over all such paths for each query.

## Input Format
* The first line contains an integer **t** — the number of test cases.
* Each of the next **t** lines contains four integers `x1 y1 x2 y2` ( `1 ≤ x1 ≤ x2 ≤ 10^9`, `1 ≤ y1 ≤ y2 ≤ 10^9` ).

## Output Format
For each test case, output **one integer** — the number of different path sums between the given cells.

## Examples

### Input
`4`<br/>
`1 1 2 2`<br/>
`1 2 2 4`<br/>
`179 1 179 100000`<br/>
`5 7 5 7`<br/>

### Output
`2`<br/>
`3`<br/>
`1`<br/>
`1`<br/>

## Constraints
* **1 ≤ t ≤ 57 179**
* **1 ≤ x1 ≤ x2 ≤ 10^9**
* **1 ≤ y1 ≤ y2 ≤ 10^9**
* Time limit: **2 seconds per test**
* Memory limit: **256 MB**

## Notes
*In the first example,* the two different paths are:
* `1 → 2 → 5` with sum **8**
* `1 → 3 → 5` with sum **9**

Hence, there are exactly **2** distinct sums.


