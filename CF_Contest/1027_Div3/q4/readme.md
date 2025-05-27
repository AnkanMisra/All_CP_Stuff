# Problem D :  "Come a Little Closer"

## Problem Statement

You have a game field represented as a **109 × 109** matrix. Each cell is identified by its row and column, denoted as (**a**, **b**).

- There are **n** monsters on the field, each occupying a unique cell (**xᵢ, yᵢ**).
- You can move **at most one monster** to any empty cell (not occupied by another monster).
- After optionally moving one monster, you select a rectangular region on the field to destroy all monsters inside it.
- You pay **1 coin per cell** in the chosen rectangle.
- Your goal is to minimize the number of coins spent to destroy all monsters.

## Input Format

- The first line contains integer **t** — number of test cases.
- For each test case:
  - The first line contains integer **n** — number of monsters.
  - Then **n** lines follow, each with two integers **xᵢ** and **yᵢ** — coordinates of the i-th monster.
- All coordinates are distinct.
- Constraints:
  - 1 ≤ t ≤ 10⁴
  - 1 ≤ n ≤ 2×10⁵
  - 1 ≤ xᵢ, yᵢ ≤ 10⁹
  - Sum of all n across test cases ≤ 2×10⁵

## Output Format

- For each test case, output the minimum cost (number of coins) needed to destroy all monsters.

## Example

**Input**
```
7
3
1 1
1 2
2 1
5
1 1
2 6
6 4
3 3
8 2
4
1 1
1 1000000000
1000000000 1
1000000000 1000000000
1
1 1
5
1 2
4 2
4 3
3 1
3 2
3
1 1
2 5
2 2
4
4 3
3 1
4 4
1 2
```

**Output**
```
3
32
1000000000000000000
1
6
4
8
```

## Notes

- You can move only one monster once to any free cell to possibly reduce the rectangle size.
- The cost is the area of the chosen rectangle.
- The rectangle must cover all monsters after the move.
- The problem tests your ability to optimize the rectangle dimensions using the move.

## Summary

- Find minimal rectangle covering all monsters after moving **at most one monster**.
- Minimize the area (cost) of that rectangle.
- Efficient input/output handling is required due to large constraints.
