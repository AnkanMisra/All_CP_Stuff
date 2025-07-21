
# Problem: Network Recovery Pathways

## Problem Description
You are given a **directed acyclic graph** with `n` nodes numbered from `0` to `n - 1`. The graph is described by a 2D array `edges` of length `m`, where each `edges[i] = [ui, vi, costi]` represents a **one-way communication** from node `ui` to node `vi` with a **recovery cost** of `costi`.

Some nodes may be **offline**. You are given a boolean array `online` where `online[i] = true` means node `i` is online. **Nodes `0` and `n - 1` are always online.**

A path from `0` to `n - 1` is **valid** if:
- **All intermediate nodes on the path are online.**
- **The total recovery cost of all edges on the path does not exceed `k`.**

For each valid path, its **score** is defined as the **minimum edge-cost** along that path.

Return the **maximum path score** (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists, return `-1`.

## Input Format
- An integer `n`, the number of nodes.
- An integer `m`, the number of edges.
- A 2D array `edges` of size `m x 3`, where each row is `[ui, vi, costi]`.
- A boolean array `online` of length `n`.
- An integer `k`, the maximum allowed total recovery cost for a valid path.

## Output Format
- An integer representing the **maximum path score** among all valid paths from node `0` to node `n - 1`. If no valid path exists, output `-1`.

## Examples

### Input
`edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]]`, `online = [true,true,true,true]`, `k = 10`<br/>

### Output
`3`<br/>

### Input
`edges = [[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]]`, `online = [true,true,true,false,true]`, `k = 12`<br/>

### Output
`6`<br/>

## Constraints
- `n == online.length`
- `2 <= n <= 5 * 10^4`
- `0 <= m == edges.length <= min(10^5, n * (n - 1) / 2)`
- `edges[i] = [ui, vi, costi]`
- `0 <= ui, vi < n`
- `ui != vi`
- `0 <= costi <= 10^9`
- `0 <= k <= 5 * 10^{13}`
- `online[i]` is either `true` or `false`, and both `online[0]` and `online[n − 1]` are `true`.
- The given graph is a **directed acyclic graph**.

## Notes
- **All intermediate nodes on a valid path must be online.**
- **The minimum edge-cost along a path determines its score.**
- **Return `-1` if no valid path exists.**

