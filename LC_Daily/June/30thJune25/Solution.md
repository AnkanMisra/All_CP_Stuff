# Solution Explanation

## Intuition
The key insight is that a **harmonious subsequence** requires elements where the maximum and minimum values differ by exactly 1. By **sorting the array first**, we can use a **two-pointer technique** to efficiently find all harmonious subsequences where consecutive distinct values have a difference of 1.

## Approach
The solution uses a **two-pointer sliding window approach** on a sorted array:

1. **Sort the array** to group identical elements together and arrange elements in ascending order
2. Use two pointers (`start` and `end`) where `start` tracks the beginning of a potential harmonious subsequence
3. **Expand the window** by moving `end` pointer and check the difference between `nums[end]` and `nums[start]`
4. **Maintain the harmonious property** by ensuring the difference is exactly 1
5. **Track the maximum length** of valid harmonious subsequences found

## Algorithm
1. Sort the input array `nums`
2. Initialize `start = 0`, `end = 1`, and `result = 0`
3. While `end < nums.length`:
   - If `nums[end] - nums[start] > 1`: **move start pointer** forward (window too wide)
   - If `nums[end] - nums[start] == 1`: **valid harmonious subsequence found**
     - Update `result = max(result, end - start + 1)`
     - Move `end` pointer forward
   - If `nums[end] - nums[start] < 1`: **move end pointer** forward (need larger difference)
4. Return the maximum length found

## Complexity
- **Time Complexity:** `O(n log n)` due to sorting, where `n` is the length of the array
- **Space Complexity:** `O(1)` excluding the space used by sorting algorithm

## Summary
This approach works because **sorting groups identical elements together** and allows us to use two pointers to efficiently find harmonious subsequences. The algorithm ensures that we only consider subsequences where the **maximum and minimum values differ by exactly 1**. Key advantages include **single pass after sorting** and **optimal space usage**. The corner case where no harmonious subsequence exists (all elements are the same) is naturally handled by returning 0.

