
# Solution Explanation

## Intuition
The **H-index** represents the maximum number `h` such that a researcher has **at least `h` papers** with **`h` or more citations each**. To find this efficiently, we can **sort the citations in ascending order** and then check from the highest citations backwards to find the maximum valid H-index.

## Approach
The key insight is to **sort the array** and then iterate from the end (highest citations) to find the largest possible H-index:

1. **Sort the citations array** in ascending order
2. **Initialize an index counter** starting from 0
3. **Iterate from the end of the sorted array** (highest citations first)
4. For each position, check if the **citation count is greater than the current index**
5. If yes, **increment the index** (this means we found another paper that satisfies the H-index condition)
6. **Continue until** we find a paper whose citation count is not greater than the current index
7. **Return the final index** as the H-index

## Algorithm
1. Sort the `citations` array in ascending order
2. Initialize `idx = 0` to track the current H-index candidate
3. While `idx < n` and `citations[n-1-idx] > idx`:
   - This checks if the paper at position `(n-1-idx)` has more than `idx` citations
   - If true, increment `idx` (we found another qualifying paper)
4. Return `idx` as the final H-index

## Complexity
- **Time Complexity:** `O(n log n)` due to sorting the array
- **Space Complexity:** `O(1)` as we only use constant extra space

## Summary
This approach works by **leveraging the sorted order** to efficiently count papers that meet the H-index criteria. By checking from the highest citations backwards, we can **incrementally build the H-index** until we find the maximum valid value. The algorithm handles **edge cases** like arrays with all zeros or when no valid H-index exists naturally through the loop condition.
```java
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int idx = 0;

        while(idx < n && citations[n-1-idx] > idx){
            idx++;
        }
        return idx;
    }
}

```
