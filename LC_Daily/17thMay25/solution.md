# Solution Explanation

### Intuition

This problem is a classic example of the **Dutch National Flag** algorithm.  
We want to sort the array so that all 0s (red) come first, followed by all 1s (white), and then all 2s (blue), **in-place** and in a single pass.

### Approach

- Use three pointers:
  - `l` (left): the next position to place a 0.
  - `r` (right): the next position to place a 2.
  - `i`: the current index being examined.
- Iterate through the array with `i` from 0 to `nums.length - 1`.
- For each `i`, if `nums[i]` is 0, swap it with `nums[l]` and increment `l`.
- If `nums[i]` is 2, swap it with `nums[r]` and decrement `r`.
- If `nums[i]` is 1, just move to the next index.
- The inner `while` loop ensures that after a swap, the new value at `nums[i]` is checked again, as it could be another 0 or 2.

### Code

```java
class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            while (i >= l && i <= r && (nums[i] == 0 || nums[i] == 2)) {
                if (nums[i] == 0) {
                    swap(nums, i, l);
                    l++;
                } else if (nums[i] == 2) {
                    swap(nums, i, r);
                    r--;
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the length of the array. Each element is moved at most twice.
- **Space Complexity:** O(1), since sorting is done in-place.

### Summary

- The algorithm efficiently sorts the array in a single pass using three pointers.
- It avoids extra space and library sort functions, meeting the problem's requirements.
