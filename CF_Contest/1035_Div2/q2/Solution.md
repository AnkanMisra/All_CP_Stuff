# Solution Explanation

## Intuition
The problem asks whether it is possible to reach a target point from a starting point in exactly `n` moves, where each move must be exactly a given distance (from the array `a`). The key insight is that after all moves, the total path length is fixed, but the direction of each move is arbitrary. Thus, the set of all possible endpoints forms an annulus (ring) centered at the start point, with the minimum and maximum possible distances from the start determined by the move lengths.

## Approach
- Calculate the **total distance** `S = a_1 + a_2 + ... + a_n` (the sum of all move lengths).
- The **minimum possible distance** you can be from the start after all moves is:
  - If all moves are in the same direction, you are `S` away from the start.
  - If you can "cancel out" some moves (by going in opposite directions), the minimum possible distance is `max(0, 2 * max(a_i) - S)` (if one move is longer than the sum of the others, you can't fully cancel it).
- Compute the **Euclidean distance** `D` between the start and end points.
- It is possible to reach the end point **if and only if**:
  - `min_possible_distance ≤ D ≤ S`
  - The difference `S - D` is even (since each move is a fixed length, and you can only reach points at certain distances depending on the parity of the sum and the target distance).

## Complexity
- **Time Complexity:** `O(n)` per test case (for summing and finding max)
- **Space Complexity:** `O(1)` (only a few variables needed per test case)

## Summary
- The solution works by reducing the problem to a geometric question about reachability with fixed-length moves in any direction.
- The main check is whether the distance between the start and end points is within the possible range of distances after all moves, and whether the parity matches.
- This approach is efficient and handles all edge cases, including when the start and end points are the same, or when one move is much longer than the others.

