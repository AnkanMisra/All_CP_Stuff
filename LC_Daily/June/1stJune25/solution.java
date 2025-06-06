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
