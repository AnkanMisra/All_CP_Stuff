
# Solution Explanation

## Intuition
The key insight is that when two ants meet and reverse directions, it is equivalent to them passing through each other without changing direction. Thus, the time for the last ant to fall is determined solely by the farthest distance any ant must travel to reach the nearest end, regardless of collisions.

## Approach
- For each ant moving left, the time to fall is simply its current position (distance to the left end).
- For each ant moving right, the time to fall is `n - position` (distance to the right end).
- The last moment before all ants fall is the maximum among all these times.
- If there are no ants in one direction, treat the corresponding maximum/minimum as zero.

## Complexity
- Time Complexity: `O(left.length + right.length)`
- Space Complexity: `O(1)`

## Summary
By treating ant collisions as pass-throughs, we only need to consider the farthest distance any ant must travel to an edge. This approach is efficient and handles all edge cases, including when ants start at the ends or when one direction is empty.

