
# Problem: Game On Leaves

## Problem Description
Ayush and Ashish play a turn-based game on an **unrooted tree** with `n` nodes numbered `1` to `n`.
On each turn a player selects any **leaf node** (node with degree `≤ 1`) and removes it along with the incident edge.
There is a **special node `x`**; the player who removes this node **wins** the game.
Ayush moves first. Both players play optimally. Determine the winner for each test case.

## Input Format
- The first line contains an integer **`t`** — number of test cases.
- For every test case:
  - A line with two integers **`n`** and **`x`** — number of nodes and the special node.
  - Each of the next `n − 1` lines contains two integers **`u`** and **`v`** describing an edge of the tree.

## Output Format
For every test case print **`Ayush`** if Ayush wins; otherwise print **`Ashish`**.

## Constraints
- `1 ≤ t ≤ 10`
- `1 ≤ n ≤ 1000`
- `1 ≤ x ≤ n`
- `1 ≤ u, v ≤ n`, `u ≠ v`

## Examples

### Example 1
**Input:**

`1
3 1
2 1
3 1`<br/>

**Output:**

`Ashish`<br/>

### Example 2
**Input:**

`1
3 2
1 2
1 3`<br/>

**Output:**

`Ayush`<br/>

## Notes
- In **Example 1** Ayush can only remove node `2` or `3`. After that, node `1` becomes a leaf, allowing Ashish to remove it and win.
- In **Example 2** the special node `2` is already a leaf, so Ayush removes it on his first move and wins immediately.

