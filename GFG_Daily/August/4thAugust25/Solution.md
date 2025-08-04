
# Solution Explanation

## Intuition
The **Maximum Sum Rectangle** problem is an extension of the classic **Maximum Subarray Problem** (Kadane's algorithm) to 2D matrices. The key insight is to reduce the 2D problem to multiple 1D problems by considering all possible pairs of columns and finding the maximum sum subarray in the compressed 1D array.

## Approach
The solution uses **Kadane's algorithm** combined with a technique to compress columns:

1. **Column Compression:** For each pair of columns `(left, right)`, compress all columns between them into a single 1D array by summing corresponding row elements.
2. **Apply Kadane's Algorithm:** On the compressed 1D array, find the maximum sum subarray which represents the maximum sum rectangle between the selected columns.
3. **Iterate All Column Pairs:** Try all possible combinations of left and right columns to find the global maximum.

## Algorithm
1. Initialize `maxSum` to the smallest possible value
2. For each possible **left column** `left` from `0` to `m-1`:
   - Initialize a temporary array `temp[]` of size `n` with all zeros
   - For each possible **right column** `right` from `left` to `m-1`:
     - Add the current column `M[i][right]` to `temp[i]` for all rows `i` (row-wise addition)
     - Apply **Kadane's algorithm** on `temp[]` to find maximum sum subarray
     - Update `maxSum` if current sum is greater
3. Return `maxSum`

## Complexity
- **Time Complexity:** `O(m² × n)` where `n` is number of rows and `m` is number of columns
  - `O(m²)` for trying all column pairs
  - `O(n)` for Kadane's algorithm on each compressed array
- **Space Complexity:** `O(n)` for the temporary array used in column compression

## Summary
This approach efficiently solves the 2D maximum sum rectangle problem by **reducing it to multiple 1D maximum subarray problems**. The key insight is that any rectangle can be represented by its left and right columns, and the rows within that rectangle form a 1D array when compressed. By applying Kadane's algorithm to find the maximum sum subarray in this compressed representation, we can find the optimal rectangle for each column pair combination.

