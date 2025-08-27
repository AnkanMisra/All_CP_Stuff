
# Solution Explanation

## Intuition
To form a valid triangle with three sides `a`, `b`, and `c`, the **triangle inequality** must be satisfied: the sum of any two sides must be greater than the third side. The key insight is that if we **sort the array** and fix the largest side, we only need to check if the sum of the two smaller sides is greater than the largest side. This is because if `a ≤ b ≤ c` and `a + b > c`, then the other two conditions (`a + c > b` and `b + c > a`) are automatically satisfied.

## Approach
1. **Sort the array** to enable the two-pointer technique and simplify triangle inequality checking.
2. **Fix the largest side** by iterating from the end of the sorted array (index `k` from `n-1` to `2`).
3. **Use two pointers** (`left = 0`, `right = k-1`) to find all valid pairs of smaller sides:
   - If `arr[left] + arr[right] > arr[k]`, then all elements from `left` to `right-1` can form triangles with `arr[right]` and `arr[k]`. Add `(right - left)` to the count and move `right` pointer left.
   - If `arr[left] + arr[right] ≤ arr[k]`, the sum is too small, so move `left` pointer right to increase the sum.
4. **Continue** until all possible triangles are counted.

## Complexity
- **Time Complexity:** `O(n²)`
  - Sorting takes `O(n log n)`
  - The nested loop structure takes `O(n²)` in the worst case
  - Overall: `O(n log n + n²) = O(n²)`
- **Space Complexity:** `O(1)` (excluding the space used by sorting)

## Summary
This approach works efficiently by **leveraging the sorted order** to use the two-pointer technique. By fixing the largest side and using two pointers for the smaller sides, we avoid checking all three triangle inequality conditions. The key insight is that in a sorted array, if the sum of two smaller sides exceeds the largest side, then multiple valid triangles can be formed simultaneously. **Corner cases** include arrays with fewer than 3 elements (return 0) and arrays where no valid triangles exist due to the triangle inequality not being satisfied.
```java
class Solution {
    public int countTriangles(int arr[]) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);

        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int left = 0;
            int right = k - 1;

            while (left < right) {
                if (arr[left] + arr[right] > arr[k]) {
                    count += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }

        return count;
    }
}
```
