
# Solution Explanation

## Intuition
Since we **must delete exactly one element**, we can think of this as finding the **longest subarray that contains at most one 0**. After we find such a subarray, we remove one element (either the 0 or any 1), and the remaining elements will all be 1s.

## Approach
We use a **sliding window technique** with two pointers to find the longest subarray containing **at most one 0**:

1. **Expand the window** by moving the right pointer and counting zeros
2. **Contract the window** when we have more than one zero by moving the left pointer
3. **Track the maximum window size** throughout the process
4. **Subtract 1** from the final result since we must delete exactly one element

## Algorithm
1. Initialize `left = 0`, `zeroCount = 0`, and `maxLength = 0`
2. For each `right` pointer from 0 to `nums.length - 1`:
   - If `nums[right] == 0`, increment `zeroCount`
   - While `zeroCount > 1`, move `left` pointer right and decrement `zeroCount` if `nums[left] == 0`
   - Update `maxLength = max(maxLength, right - left + 1)`
3. Return `maxLength - 1` (since we must delete one element)

## Complexity
- **Time Complexity:** `O(n)` where n is the length of the array. Each element is visited at most twice (once by right pointer, once by left pointer).
- **Space Complexity:** `O(1)` as we only use a constant amount of extra space.

## Summary
The sliding window approach works because it efficiently finds the **longest subarray with at most one zero**. By maintaining this constraint, we ensure that after deleting one element, all remaining elements will be 1s. The key insight is that we must always delete exactly one element, so we subtract 1 from our maximum window size. **Edge case:** If the array contains only 1s, we still must delete one element, so the answer is `length - 1`.
```java
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength - 1;
    }
}
```
