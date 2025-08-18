
# Solution Explanation

## Intuition
Each tree at coordinate `(i, j)` carries `|i| + |j|` apples.
For a square of half side‐length `n` (coordinates range from `-n` to `n`) the total apples only depend on `n`, not on individual points. If we can express this total as a closed-form function `f(n)`, the task reduces to finding the smallest `n` such that `f(n)` is at least `neededApples`. The perimeter is then `8 × n`.

## Approach
1. **Derive a formula for total apples inside a square of radius `n`.**
   *For a fixed `j`* (row), the apples contributed by all columns `i = -n … n` is:
   `∑ |i| = 2 × (1 + 2 + … + n) = n (n + 1)`.
   There are `(2n + 1)` different rows, so the total contribution from the *|i| part* is `(2n + 1) × n (n + 1)`.
   By symmetry, the *|j| part* contributes the same amount. Therefore

   `f(n) = 2 × (2n + 1) × n × (n + 1)`.
2. **Binary search on `n`.**
   `f(n)` grows monotonically (roughly like `4n³`), so binary search can locate the smallest `n` with `f(n) ≥ neededApples`.
   • Lower bound: `1`.
   • Upper bound: `1 000 000` safely covers the maximum input `10¹⁵` (because `f(1e6) ≈ 2 × 2e6 × 1e6 × 1e6 ≈ 4e18`).
3. **Return perimeter.**
   The minimal perimeter equals `8 × n` since each side has length `2n`.

## Algorithm (Binary Search)
1. `left = 1`, `right = 1 000 000`.
2. While `left < right`:
   - `mid = (left + right) / 2`.
   - If `f(mid) ≥ neededApples`, set `right = mid` (search left half).
     Else set `left = mid + 1` (search right half).
3. Output `8 × left`.

## Complexity
- **Time:** `O(log U)` where `U` is the chosen upper bound (`≈ 20` iterations).
  Dominated by the binary-search loop.
- **Space:** `O(1)` — only a few scalar variables.

## Summary
The key insight is a closed-form count of apples inside a radius-`n` square: `f(n) = 2 (2n + 1) n (n + 1)`.
Because this function is monotone and cubic in `n`, a short binary search finds the minimal `n`; multiplying by `8` yields the required perimeter.
```java
class Solution {
    public long minimumPerimeter(long neededApples) {
        long left = 1, right = 1000000;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (applesInside(mid) >= neededApples) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left * 8;
    }

    private long applesInside(long n) {
        return 2L * (2L * n + 1) * n * (n + 1);
    }
}

```
