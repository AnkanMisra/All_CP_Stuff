# Solution Explanation

### Intuition

The multiplication table of size `m x n` contains numbers in the form `i * j` for `1 <= i <= m` and `1 <= j <= n`. The table is sorted in each row and column, but not globally. To find the `k`th smallest element efficiently, we can use **binary search** on the value, not on the indices.

### Approach

- Use binary search to guess the answer (`mid`), searching between 1 and `m * n`.
- For each guess, count how many numbers in the table are less than or equal to `mid`.
  - For each row `i`, the count is `min(n, mid / i)` (since the row is `[i, 2i, 3i, ..., ni]`).
- If the count is less than `k`, the answer must be larger, so move the lower bound up.
- Otherwise, move the upper bound down.
- When the search ends, `low` will be the `k`th smallest number.

### Code

```java
class Solution {
    public int kthSmallest(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 1; i <= m; i++) {
                count += Math.min(n, mid / i);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
```

### Complexity

- **Time Complexity:** O(m * log(m * n)), since for each binary search step (logarithmic in the value range), we count for all `m` rows.
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution uses binary search on the value space and counts how many numbers are less than or equal to the guess.
- This approach is efficient and optimal for large tables.
