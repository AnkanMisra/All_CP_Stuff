
# Solution Explanation

## Intuition
This problem asks us to find the **minimum number of days** to make `m` bouquets with `k` adjacent flowers each. The key insight is that if we can make `m` bouquets on day `x`, we can also make them on any day greater than `x`. This **monotonic property** makes it perfect for **binary search on the answer**.

## Approach
We use **binary search** to find the minimum day where we can make exactly `m` bouquets:

1. **Check feasibility**: First verify if it's possible to make `m` bouquets. We need at least `m * k` flowers total.

2. **Set search range**: The minimum possible day is the smallest bloom day in the array, and the maximum is the largest bloom day.

3. **Binary search**: For each candidate day `mid`, check if we can make `m` bouquets by that day using a helper function.

4. **Count bouquets**: In the helper function, iterate through the array and count **consecutive bloomed flowers**. When we get `k` consecutive flowers, we can make one bouquet and reset the counter.

5. **Update search**: If we can make enough bouquets, try a smaller day (search left). Otherwise, we need more days (search right).

## Algorithm
1. Check if `m * k > arr.length`, return `-1` if impossible
2. Find `minDay` and `maxDay` from the array
3. Initialize binary search with `left = minDay`, `right = maxDay`
4. While `left <= right`:
   - Calculate `mid = left + (right - left) / 2`
   - If `canMakeBouquets(arr, k, m, mid)` returns true:
     - Update `result = mid`
     - Search for smaller day: `right = mid - 1`
   - Else: `left = mid + 1`
5. Return `result`

**Helper function `canMakeBouquets`**:
1. Initialize `bouquets = 0`, `consecutiveFlowers = 0`
2. For each flower in array:
   - If `bloomDay <= day`: increment `consecutiveFlowers`
   - If `consecutiveFlowers == k`: increment `bouquets`, reset `consecutiveFlowers`
   - Else: reset `consecutiveFlowers = 0`
3. Return `bouquets >= m`

## Complexity
- **Time Complexity**: `O(n log(max_day - min_day))` where `n` is the array length. The binary search runs in `O(log(max_day - min_day))` iterations, and each iteration takes `O(n)` to check if bouquets can be made.
- **Space Complexity**: `O(1)` as we only use constant extra space.

## Summary
The **binary search on answer** approach works because of the monotonic property: if we can make `m` bouquets on day `x`, we can make them on any day after `x`. The helper function efficiently counts consecutive bloomed flowers to determine bouquet formation. **Key corner case**: Always check if total required flowers `m * k` exceeds available flowers to avoid impossible scenarios.
```java
class Solution {
    public int minDaysBloom(int[] arr, int k, int m) {
        if ((long) m * k > arr.length) {
            return -1;
        }

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int day : arr) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int left = minDay, right = maxDay;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canMakeBouquets(arr, k, m, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canMakeBouquets(int[] arr, int k, int m, int day) {
        int bouquets = 0;
        int consecutiveFlowers = 0;

        for (int bloomDay : arr) {
            if (bloomDay <= day) {
                consecutiveFlowers++;
                if (consecutiveFlowers == k) {
                    bouquets++;
                    consecutiveFlowers = 0;
                }
            } else {
                consecutiveFlowers = 0;
            }
        }

        return bouquets >= m;
    }
}
```
