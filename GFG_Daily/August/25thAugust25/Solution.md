
# Solution Explanation

## Intuition
To **maximize the median**, we need to focus on the elements that contribute to the median calculation. After sorting the array, the median is determined by the middle element(s). The key insight is that we should **prioritize increasing elements from the median position onwards** since these directly affect the median value. We use a **greedy approach** to distribute the `k` operations optimally.

## Approach
The solution uses a **greedy strategy** to maximize the median by intelligently distributing operations:

1. **Sort the array** to identify the median position
2. **Handle even-length arrays** specially - if we can't make both middle elements equal with available operations, return the average after partial operations
3. **Use a greedy filling strategy** - process elements from median position onwards, filling gaps between consecutive elements
4. **Distribute remaining operations** evenly among all elements from median position to the end

## Algorithm
1. Sort the input array and identify the median index as `(n-1)/2`
2. For **even-length arrays**: Check if we can equalize the two middle elements. If the gap is too large, return the average after using `k` operations
3. **Greedy gap filling**: For each position from median index onwards:
   - Calculate the gap to the next element
   - Determine how many operations are needed to bring all elements up to the next level
   - If we have enough operations, fill the gap completely; otherwise, distribute available operations
4. **Final distribution**: If operations remain, distribute them evenly among all elements from median position onwards

## Complexity
- **Time Complexity:** `O(n log n)` - dominated by the sorting step
- **Space Complexity:** `O(1)` - only using constant extra space for variables

## Summary
This **greedy approach** works because maximizing the median requires focusing on elements that directly contribute to the median calculation. By processing elements from the median position onwards and **filling gaps strategically**, we ensure optimal distribution of operations. The algorithm handles both **odd and even array lengths** correctly, with special consideration for the averaging requirement in even-length arrays. Key corner cases include arrays where all elements are already equal and scenarios where `k` is very large relative to the array values.
```java
class Solution {
    public int maximizeMedian(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int medianIndex = (arr.length-1)/2;
        int current = arr[medianIndex];

        if(arr.length%2 == 0 && arr[medianIndex+1]-arr[medianIndex] >=k ) {
            return (arr[medianIndex+1]+arr[medianIndex]+k)/2;
        }

        for (int i = medianIndex; i < n - 1 && k > 0; i++) {
            int gap = arr[i + 1] - arr[i];
            int count = (i - medianIndex + 1);
            int needed = gap * count;

            if (k >= needed) {
                current = arr[i + 1];
                k -= needed;
            } else {
                current += k / count;
                k = 0;
            }
        }

        if (k > 0) {
            current += k / (n - medianIndex);
        }

        return current;
    }
}
```
