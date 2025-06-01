# Solution Explanation

### Intuition

The problem asks for the difference between the sum of all numbers from 1 to `n` that are **not** divisible by `m` and the sum of all numbers from 1 to `n` that **are** divisible by `m`. This can be solved with a simple loop and two accumulators.

### Approach

- Initialize two sums: `sum` for numbers not divisible by `m`, and `sum1` for numbers divisible by `m`.
- Loop through all numbers from 1 to `n`:
  - If the number is not divisible by `m`, add it to `sum`.
  - If the number is divisible by `m`, add it to `sum1`.
- Return the difference `sum - sum1`.

### Code

```java
class Solution {
    public int differenceOfSums(int n, int m) {
        int sum = 0;
        int sum1 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) sum += i;
            else sum1 += i;
        }
        return (sum - sum1);
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the input number.
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution efficiently computes the required difference by iterating through the range and updating two sums.
- It is simple, direct, and optimal for the given constraints.
