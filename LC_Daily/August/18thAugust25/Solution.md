
# Solution Explanation

## Intuition
The **core insight** is to use **backtracking** to try all possible ways of combining four numbers with mathematical operations. Since we need to evaluate expressions to get exactly `24`, we can **recursively reduce** the problem by picking any two numbers, applying all possible operations, and continuing with the reduced set until only one number remains.

## Approach
The solution uses a **recursive backtracking approach** with the following strategy:

1. **Base Case**: When only one number remains, check if it equals `24` (within floating-point precision).

2. **Recursive Case**: For each pair of numbers in the current list:
   - Remove both numbers from the list
   - Apply all possible operations (`+`, `-`, `*`, `/`) between them
   - Add each result back to the list and recursively solve
   - If any recursive call returns `true`, we found a solution
   - Backtrack by removing the added result

3. **Operation Handling**: For each pair `(a, b)`, we try:
   - `a + b` and `b + a` (same result, but we include both for completeness)
   - `a - b` and `b - a` (different results due to non-commutativity)
   - `a * b` and `b * a` (same result, but we include both for completeness)
   - `a / b` and `b / a` (different results, with division by zero checks)

## Algorithm
1. Convert all integers to doubles to handle real division
2. Call the recursive solve function with the list of four numbers
3. In each recursive call:
   - If list size is 1, check if the number equals 24
   - Otherwise, try all pairs of numbers
   - For each pair, try all six operations (including non-commutative cases)
   - Recursively solve with the reduced list
   - Return `true` if any combination works

## Complexity
- **Time Complexity:** `O(1)` - Since we always have exactly 4 numbers, the number of operations is constant. The recursive tree has a fixed depth and branching factor.
- **Space Complexity:** `O(1)` - The recursion depth is at most 3 (reducing from 4 numbers to 1), and we use constant extra space.

## Summary
This **backtracking approach** works because it **exhaustively explores** all possible ways to combine the four numbers with the allowed operations. The key insight is that any mathematical expression with four numbers can be represented as a **binary tree of operations**, and we systematically try all possible trees. The algorithm handles **floating-point precision** issues and **division by zero** cases. Since the input size is fixed at 4 numbers, the solution runs in constant time despite the exponential nature of the search space.
```java
import java.util.*;
class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> l = new ArrayList<>();
        for (int c : cards) l.add((double) c);
        return solve(l);
    }
    private boolean solve(List<Double> l) {
        if (l.size() == 1) return Math.abs(l.get(0) - 24) < 1e-6;
        int n = l.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++)
                    if (k != i && k != j) next.add(l.get(k));
                double a = l.get(i), b = l.get(j);
                for (double v : calc(a, b)) {
                    next.add(v);
                    if (solve(next)) return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
    private List<Double> calc(double a, double b) {
        List<Double> r = new ArrayList<>();
        r.add(a + b); r.add(a - b); r.add(b - a); r.add(a * b);
        if (Math.abs(b) > 1e-6) r.add(a / b);
        if (Math.abs(a) > 1e-6) r.add(b / a);
        return r;
    }
}

```
