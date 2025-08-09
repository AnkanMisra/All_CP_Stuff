
# Problem: Maze

## Problem Description
Pavel loves grid mazes. A grid maze is an `n × m` rectangle maze where each cell is either empty, or is a wall. You can go from one cell to another only if both cells are empty and have a common side.

Pavel drew a grid maze with **all empty cells forming a connected area**. That is, you can go from any empty cell to any other one. Pavel doesn't like it when his maze has too little walls. He wants to **turn exactly k empty cells into walls** so that **all the remaining cells still formed a connected area**. Help him.

## Input Format
The first line contains three integers `n`, `m`, `k` where:
- `n` and `m` are the **maze's height and width** respectively
- `k` is the **number of walls Pavel wants to add**
- `s` represents the **number of empty cells** in the original maze

Each of the next `n` lines contains `m` characters describing the original maze:
- **"."** represents an **empty cell**
- **"#"** represents a **wall**

## Output Format
Print `n` lines containing `m` characters each: the new maze that fits Pavel's requirements.
- Mark the **empty cells that you transformed into walls** as **"X"**
- The **other cells must be left without changes** (that is, "." and "#")

## Examples

### Input

`3 4 2`<br/>
`#..#`<br/>
`..#.`<br/>
`#...`<br/>

### Output

`#.X#`<br/>
`X.#.`<br/>
`#...`<br/>

### Input

`5 4 5`<br/>
`#...`<br/>
`#.#.`<br/>
`.#..`<br/>
`...#`<br/>
`.#.#`<br/>

### Output

`#XXX`<br/>
`#X#.`<br/>
`X#..`<br/>
`...#`<br/>
`.#.#`<br/>

## Constraints
- **1 ≤ n, m ≤ 500**
- **0 ≤ k < s**
- It is **guaranteed that a solution exists**
- If there are **multiple solutions** you can output any of them

## Notes
- The maze must maintain **connectivity** after adding walls
- You need to convert exactly `k` empty cells to walls
- The solution approach should ensure that all remaining empty cells can still reach each other

