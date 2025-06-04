## Solution Explanation

## Intuition
The problem is about reconstructing a drone's flight program, where the drone can either stay at the same height or rise by 1 at each obstacle, and must pass through a series of height constraints. Some steps in the program are unknown and must be filled in. The key is to ensure that at every step, the drone's height remains within the allowed range, and the sequence of moves is valid.

## Approach
- Use dynamic programming to track the possible minimum and maximum heights (`low` and `high`) the drone can have at each obstacle, given the constraints and the known/unknown moves.
- For each obstacle:
  - If the move is unknown (`-1`), the drone could either stay or rise, so update the possible height range accordingly.
  - If the move is known (`0` or `1`), update the possible height range based on the move.
  - After updating, intersect the possible range with the obstacle's allowed range.
  - If at any point the possible range becomes invalid (lower bound exceeds upper bound), it is impossible to complete the course.
- If a valid sequence is possible, reconstruct the actual moves by working backwards from the last obstacle, choosing moves that keep the drone within the valid height range at each step.

## Algorithm
1. Initialize `low[0] = 0` and `high[0] = 0` (the drone starts on the ground).
2. For each obstacle `i` from 1 to `n`:
   - If `d[i] == -1`, set the possible range to `[low[i-1], high[i-1]+1]`.
   - If `d[i] == 0`, set the possible range to `[low[i-1], high[i-1]]`.
   - If `d[i] == 1`, set the possible range to `[low[i-1]+1, high[i-1]+1]`.
   - Intersect this range with `[l[i], r[i]]` (the allowed range for the obstacle).
   - If the intersection is empty, mark as impossible.
3. If possible, reconstruct the answer by iterating backwards:
   - At each step, choose `0` if possible (i.e., if the current height is within the previous range), otherwise choose `1`.
   - Decrement the current height by the chosen move.
4. Output the reconstructed sequence or `-1` if impossible.

## Complexity
- Time Complexity: O(n) per test case, where n is the number of obstacles.
- Space Complexity: O(n) per test case for storing ranges and the answer.

## Summary
This approach efficiently checks if a valid flight program exists by maintaining possible height ranges at each step and reconstructs the sequence if possible. It ensures that all constraints are satisfied and handles both known and unknown moves in the program. Solution for 4thJune25
