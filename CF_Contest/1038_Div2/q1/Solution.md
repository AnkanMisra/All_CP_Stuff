# A. Greedy Grid - Solution

## Problem Analysis

We need to determine if there exists an n×m grid where no greedy path achieves the maximum value among all down/right paths.

### Key Insights

1. **Greedy Path**: Starts at top-left, moves only right or down, always choosing the neighbor with greater value (or either if equal).

2. **Goal**: Find when a non-greedy path can have a higher sum than any greedy path.

### Solution Logic

The answer is **"NO"** only in these cases:
- **1×m or n×1 grids**: Only one possible path exists, so greedy = optimal
- **2×2 grid**: All paths visit the same cells, so greedy = optimal

For all other cases (**n≥3 or m≥3** with both dimensions ≥2), we can construct a grid where:
- The optimal path goes through cells with smaller immediate values but leads to a higher total
- The greedy path gets "trapped" by locally optimal choices

### Example (3×3 grid from problem):
```
3 2 5
5 1 4
1 2 3
```

- **Optimal path**: (1,1)→(2,1)→(3,1)→(3,2)→(3,3) = 3+5+1+2+3 = 14
- **Greedy path**: (1,1)→(1,2)→(2,2)→(3,2)→(3,3) = 3+2+1+2+3 = 11

(Note: The example in the problem statement uses different values, but the principle is the same)

### Implementation

```java
if (n == 1 || m == 1 || (n == 2 && m == 2)) {
    out.println("NO");
} else {
    out.println("YES");
}
```

**Time Complexity**: O(1) per test case  
**Space Complexity**: O(1)