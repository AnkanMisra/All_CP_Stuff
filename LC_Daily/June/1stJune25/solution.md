# Solution Explanation

### Intuition

We need to count the number of ways to distribute `n` candies among 3 children such that no child gets more than `limit` candies. This is a classic stars-and-bars (combinatorics) problem with upper bounds, which can be solved using inclusion-exclusion.

### Approach

- The total number of non-negative integer solutions to `x + y + z = n` is C(n+2, 2).
- We need to subtract the cases where at least one child gets more than `limit` candies.
- Use inclusion-exclusion:
  - Subtract cases where one child gets more than `limit` candies: 3 * C(n-limit+1, 2)
  - Add back cases where two children get more than `limit` candies: 3 * C(n-2*limit, 2)
- If `n > 3*limit`, it's impossible to distribute, so return 0.

### Code

public class Solution {

    public long distributeCandies(int n, int limit) {
        long ans = 0;

        // If it's not possible to distribute candies, return 0
        if (n > 3 * limit) {
            return 0;
        }

        // Calculate a base value using combinations
        ans = 1L * (n + 2) * (n + 1) / 2;

        // Adjust based on conditions
        if (n > limit) {
            // Subtract if exceeding the limit
            ans -= 3 * 1L * (n - limit + 1) * (n - limit) / 2;
        }

        if (n - 2 >= 2 * limit) {
            // Add if enough candies are available to distribute
            ans += 3 * 1L * (n - 2 * limit) * (n - 2 * limit - 1) / 2;
        }

        // Return the final result
        return ans;
    }
}

### Complexity

- **Time Complexity:** O(1), as all calculations are direct arithmetic.
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution uses combinatorics and inclusion-exclusion to count valid distributions.
- It efficiently handles the upper bound constraint for each child.
- Returns 0 if it's impossible to distribute the candies under the given constraints.
