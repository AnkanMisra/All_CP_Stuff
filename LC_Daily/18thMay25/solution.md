# Solution Explanation

### Intuition

We need to count the number of ways to color an `m x n` grid using three colors (red, green, blue) such that no two adjacent cells (horizontally or vertically) have the same color. Since `m` is small (≤ 5), but `n` can be large (up to 1000), we can use **dynamic programming with state compression**. Each column's coloring can be represented as a "state", and we can precompute all valid states and their transitions.

### Approach

- **State Representation:**  
  Each column's coloring is represented as an integer, where each cell's color is encoded in a few bits. For each column, we store all valid colorings (no two adjacent cells in the column have the same color).

- **DP Transition:**  
  For each column, we keep a map of all valid states and the number of ways to reach each state. For each valid state in the current column, we try all valid states in the next column, ensuring that no cell in the same row has the same color as in the previous column.

- **Initialization:**  
  Start by generating all valid states for a single column and set their count to 1.

- **DP Iteration:**  
  For each column from 2 to `n`, update the count for each valid state in the new column by summing over all compatible states from the previous column.

- **Result:**  
  The answer is the sum of the counts of all valid states after processing all columns.

### Code

```java
import java.util.*;

class Solution {
    private static final int MODULO = 1_000_000_007;

    public int colorTheGrid(int rows, int cols) {
        Map<Integer, Long> stateCount = new HashMap<>();
        createValidStates(stateCount, 0, rows, 0, 0);

        for (int col = 1; col < cols; col++) {
            Map<Integer, Long> newStateCount = new HashMap<>();
            for (int currentState : stateCount.keySet()) {
                for (int nextState : stateCount.keySet()) {
                    if ((currentState & nextState) == 0) {
                        newStateCount.put(
                            nextState,
                            (newStateCount.getOrDefault(nextState, 0L) + stateCount.get(currentState)) % MODULO
                        );
                    }
                }
            }
            stateCount = newStateCount;
        }

        long totalWays = 0;
        for (long count : stateCount.values()) {
            totalWays = (totalWays + count) % MODULO;
        }

        return (int) totalWays;
    }

    private void createValidStates(Map<Integer, Long> stateCount, int position, int totalRows, int previousColor, int currentState) {
        if (position == totalRows) {
            stateCount.put(currentState, stateCount.getOrDefault(currentState, 0L) + 1);
            return;
        }

        for (int color = 1; color <= 3; color++) {
            if (color != previousColor) {
                createValidStates(stateCount, position + 1, totalRows, color, (currentState << 3) | (1 << color));
            }
        }
    }
}
```

### Complexity

- **Time Complexity:**  
  Exponential in `m` (since the number of valid states is O(3^m)), and linear in `n` (since we process each column). For `m ≤ 5`, this is efficient enough.
- **Space Complexity:**  
  O(3^m) for storing the state counts.

### Summary

- The solution uses dynamic programming with state compression, leveraging the small value of `m`.
- All valid colorings for a column are precomputed, and transitions are made only between compatible states.
- The final answer is the sum of all valid ways to color the grid after processing all columns.
