# Solution Explanation

## Intuition
The key insight is to use **binary search on the answer**. Instead of trying all possible selections of `k` elements, we can binary search on the minimum difference value and check if it's possible to select `k` elements with at least that minimum difference.

## Approach
The solution uses a **greedy approach combined with binary search**:

1. **Sort the array** to enable efficient checking of feasible minimum differences
2. **Binary search on the minimum difference value** from `0` to `max_element - min_element`
3. For each candidate minimum difference `mid`, use a **greedy selection strategy**:
   - Start with the first element
   - Select the next element only if its difference from the last selected element is at least `mid`
   - Count how many elements can be selected this way
4. If we can select at least `k` elements with minimum difference `mid`, try a larger difference; otherwise, try a smaller one

## Algorithm
1. **Sort** the input array `arr`
2. Initialize binary search bounds: `low = 0`, `high = arr[n-1] - arr[0]`
3. **Binary search loop**:
   - Calculate `mid = (low + high) / 2`
   - Check if we can place `k` elements with minimum difference `mid` using `canPlace()` function
   - If yes: update answer and search for larger difference (`low = mid + 1`)
   - If no: search for smaller difference (`high = mid - 1`)
4. **canPlace() helper function**:
   - Greedily select elements starting from the first one
   - For each subsequent element, select it only if `arr[i] - last_selected >= diff`
   - Return `true` if at least `k` elements can be selected

## Complexity
- **Time Complexity:** `O(n log n + n log(max_diff))`
  - `O(n log n)` for sorting the array
  - `O(n log(max_diff))` for binary search with `O(n)` validation per iteration
- **Space Complexity:** `O(1)` excluding the input array

## Summary
This approach works because **sorting enables greedy selection** and **binary search optimizes the search space**. The greedy strategy is optimal: if we can select `k` elements with minimum difference `d`, we should always pick elements as early as possible to maximize future choices. Key corner cases include arrays with duplicate elements and when `k` equals the array size.
```java
class Solution {
    public int maxMinDiff(int[] arr, int k) {
        if (arr == null || arr.length == 0 || k <= 1) {
            return 0;
        }

        Arrays.sort(arr);

        int n = arr.length;
        int low = 0;
        int high = arr[n - 1] - arr[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(arr, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean canPlace(int[] arr, int k, int diff) {
        int count = 1;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= diff) {
                count++;
                last = arr[i];
                if (count >= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
