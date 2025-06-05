# Solution Explanation

## Intuition
The problem is to find the minimum number of batteries the robot can have at the end of its journey from the first to the last checkpoint, given that each passage requires a minimum number of batteries to traverse. The robot can pick up batteries at each checkpoint, and all previously collected batteries are recharged at every checkpoint. The challenge is to minimize the number of batteries while ensuring the robot can traverse a valid path to the end.

## Approach
- Model the checkpoints and passages as a directed graph, where each edge has a weight representing the minimum number of batteries required to traverse it.
- The key observation is that the minimum number of batteries needed at the end is the minimum value `B` such that there exists a path from checkpoint 1 to checkpoint n, and all passages on the path can be traversed with at least `B` batteries.
- Use binary search over all unique passage requirements (`wi`) to find the smallest `B` for which a valid path exists.
- For each candidate `B`, simulate the journey using a greedy approach:
  - At each checkpoint, keep track of the maximum number of batteries the robot can have upon arrival.
  - Only traverse passages where the requirement is at most `B` and the robot has enough batteries.
  - If the robot can reach the last checkpoint, `B` is feasible.

## Algorithm
1. For each test case, collect all unique passage requirements (`wi`) and sort them.
2. Use binary search over these values:
   - For each candidate `B`, check if it's possible to reach the last checkpoint using only passages with requirement ≤ `B`.
   - Use a greedy simulation to propagate the maximum number of batteries the robot can have at each checkpoint.
3. The answer is the smallest `B` for which the robot can reach the last checkpoint, or `-1` if no such path exists.

## Complexity
- Time Complexity: O(M log M + N + M) per test case, where N is the number of checkpoints and M is the number of passages. The binary search runs in O(log M), and each check is O(N + M).
- Space Complexity: O(N + M) for storing the graph and auxiliary arrays.

## Summary
This approach efficiently finds the minimum number of batteries required at the end by combining binary search with a greedy simulation. By checking only feasible passage requirements and simulating the robot's journey, it ensures both correctness and efficiency, even for large inputs.
