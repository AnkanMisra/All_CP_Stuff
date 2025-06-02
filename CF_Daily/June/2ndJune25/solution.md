# Solution Explanation

### Intuition

We want to ensure that no two neighboring stones have the same color. If two adjacent stones are the same, we need to remove one of them. The minimum number of stones to remove is simply the count of such adjacent pairs.

### Approach

- Iterate through the string of stone colors.
- For each position from the second character onward, check if the current stone is the same as the previous one.
- If they are the same, increment the removal count.
- At the end, the count will represent the minimum number of stones to remove.

### Algorithm

1. Initialize a counter to 0.
2. Loop from the second character to the end of the string:
   - If the current character is the same as the previous, increment the counter.
3. Output the counter.

### Complexity

- Time Complexity: O(n), where n is the number of stones.
- Space Complexity: O(1), as only a few variables are used.

### Summary

- The solution counts the number of adjacent stones with the same color.
- Each such pair requires one removal to ensure all neighboring stones are different.
- The approach is efficient and optimal for the given constraints.
