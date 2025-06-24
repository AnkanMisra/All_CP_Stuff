# Solution Explanation

## Intuition
The problem asks for all indices `i` such that there exists at least one index `j` with `nums[j] == key` and `|i - j| <= k`. The key insight is that for each occurrence of `key`, all indices within `k` distance of it are valid. To avoid duplicates and ensure efficiency, a two-pointer approach is used.

## Approach
1. **Two-Pointer Technique:**  
   - Use two pointers, `i` (current index to check) and `j` (current index to find the next occurrence of `key`).
   - For each `i`, move `j` forward until `nums[j] == key` or `j` reaches the end.
   - If `i` is within `[j - k, j + k]`, add `i` to the answer.
   - If `i` is not in range, increment `i` or `j` as appropriate.
2. **Efficient Scanning:**  
   - This approach ensures each index is checked at most once, and the answer is built in increasing order.

## Complexity
- **Time Complexity:** O(n), where n is the length of the array (each index is processed at most twice).
- **Space Complexity:** O(n), for the answer list.

## Summary
**By using a two-pointer approach, we efficiently find all k-distant indices for the given key, ensuring no duplicates and maintaining sorted order.**  
This method is optimal for the given constraints.

```java
//idk why is this ts easy?
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> answer = new ArrayList<>();
        // i to track [j - k, j + k], j to track nums[j] == key.
        int n = nums.length, i = 0, j = 0;
        while (i < n && j < n) {
            // nums[j] != key, check next j.
            if (nums[j] != key) {
                j++;
            // nums[j] == key, check if i in range [j - k, j + k].
            } else if (i < j - k) {
                // i not in range, check next i.
                i++;
            } else if (i <= j + k) {
                // i in range, add to answer.
                answer.add(i++);
            // i > j + k, check next j.
            } else {
                j++;
            }
        }
        return answer;
    }
}
