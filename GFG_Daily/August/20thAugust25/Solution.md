
# Solution Explanation

## Intuition
The key insight is to treat the **2D matrix as a flattened 1D rotated sorted array**. Since the matrix was originally sorted row-wise and then rotated, we can use **modified binary search** to find the target element efficiently.

## Approach
We apply **binary search on the conceptual 1D array** while working with 2D indices:

1. **Map 2D to 1D**: Convert matrix coordinates to 1D indices using `index = row * m + col`
2. **Map 1D to 2D**: Convert 1D index back to matrix coordinates using `row = index / m`, `col = index % m`
3. **Modified Binary Search**: Use the rotation property to determine which half of the array is sorted
4. **Search Strategy**:
   - Compare `mid` element with `low` element to identify the sorted half
   - If **left half is sorted** (`lowVal <= midVal`): check if target lies in this range
   - If **right half is sorted**: check if target lies in the right range
   - Adjust search boundaries accordingly

## Algorithm
1. Initialize `low = 0` and `high = n * m - 1` (total elements - 1)
2. While `low <= high`:
   - Calculate `mid = low + (high - low) / 2`
   - Get `midVal = mat[mid / m][mid % m]`
   - If `midVal == x`, return `true`
   - Get `lowVal = mat[low / m][low % m]`
   - If `lowVal <= midVal` (left half sorted):
     - If `x >= lowVal && x < midVal`: search left half (`high = mid - 1`)
     - Else: search right half (`low = mid + 1`)
   - Else (right half sorted):
     - Get `highVal = mat[high / m][high % m]`
     - If `x > midVal && x <= highVal`: search right half (`low = mid + 1`)
     - Else: search left half (`high = mid - 1`)
3. Return `false` if not found

## Complexity
- **Time Complexity**: `O(log(n * m))` - Binary search on total elements
- **Space Complexity**: `O(1)` - Only using constant extra space

## Summary
This approach efficiently handles the **rotated sorted matrix** by leveraging the fact that at least one half of the search space is always sorted. The key insight is **mapping between 1D and 2D indices** while maintaining the binary search properties. Corner cases include empty matrix and single element matrix, both handled by the boundary conditions.
```java
class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0) return false;
        int m = mat[0].length;
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = mat[mid / m][mid % m];
            if (midVal == x) {
                return true;
            }
            int lowVal = mat[low / m][low % m];
            if (lowVal <= midVal) {
                if (x >= lowVal && x < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                int highVal = mat[high / m][high % m];
                if (x > midVal && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}

```
