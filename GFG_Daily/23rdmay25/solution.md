# Solution Explanation

### Intuition

This is a classic dynamic programming problem. We want to count the number of ways to roll `n` dice (each with `m` faces) so that the sum of the faces is exactly `x`. For each die, we can choose any face value from 1 to `m`, and we need to keep track of the current sum and the number of dice used so far.

### Approach

- Use recursion with memoization (top-down DP).
- Define `recurse(i, sum)` as the number of ways to reach the target sum using dice from position `i` to `n`, where `sum` is the current sum so far.
- Base case: If all dice have been used (`i > n`) and the sum is exactly the target, return 1 (valid way). If all dice are used but the sum is not the target, return 0.
- If the current sum exceeds the target, return 0.
- For each die, try all possible face values (from 1 to `m`), and recursively compute the number of ways for the next die and updated sum.
- Use a DP table to memoize results for each `(i, sum)` pair to avoid recomputation.

### Code

```java
class Solution {
    static int noOfWays(int m, int n, int x) {
        int dp[][] = new int[n + 1][100];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        int ans = recurse(1, 0, dp, x, n, m);
        return ans;
    }

    static int recurse(int i, int sum, int dp[][], int target, int n, int m) {
        if (i > n && target == sum)
            return 1;
        if (i > n)
            return 0;
        if (sum > target)
            return 0;
        if (dp[i][sum] != -1)
            return dp[i][sum];

        int value = 0;
        for (int k = 1; k <= m; k++) {
            value += recurse(i + 1, sum + k, dp, target, n, m);
        }
        return dp[i][sum] = value;
    }
}
```

### Complexity

- **Time Complexity:** O(n * x * m), where n is the number of dice, x is the target sum, and m is the number of faces.
- **Space Complexity:** O(n * x), for the DP table.

### Summary

- The solution uses recursion with memoization to efficiently count the number of ways to reach the target sum with the given dice.
- It tries all possible face values for each die and memoizes results to avoid redundant calculations.
- This approach is efficient for the given constraints.
