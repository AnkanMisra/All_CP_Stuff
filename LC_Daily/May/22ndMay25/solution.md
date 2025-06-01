# Solution Explanation

### Intuition

We want to maximize the number of queries we can remove while still being able to turn the array into all zeros. Each query allows us to decrement any subset of elements in a given range by at most 1, and the amount can be chosen independently for each index. The key is to use the minimum number of queries to cover the required decrements for each index.

### Approach

- Sort the queries by their starting index.
- Use a max-heap (priority queue) to always select the query that ends the latest (covers the current index as long as possible).
- Use a difference array (`diffs`) to efficiently track the effect of removing queries.
- For each index in `nums`:
  - Add all queries starting at this index to the heap.
  - Apply the effect of previous queries using the difference array.
  - While the current coverage is less than `nums[i]` and there are queries in the heap that cover this index, use (remove) the query that ends the latest and update the difference array.
  - If after using all available queries, the current coverage is still less than `nums[i]`, it's impossible to make the array zero, so return -1.
- The number of queries left in the heap at the end is the maximum number of queries that can be removed.

### Code

```java
class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> last = new PriorityQueue<>((a, b) -> b - a);
        int[] diffs = new int[nums.length + 1];
        int idx = 0;
        int cur = 0;
        for(int i=0; i<nums.length; i++) {
            while(idx < queries.length && queries[idx][0] == i) {
                last.add(queries[idx][1]);
                idx++;
            }
            cur += diffs[i];
            while(cur < nums[i] && !last.isEmpty() && last.peek() >= i) {
                cur++;
                diffs[last.poll() + 1]--;
            }
            if(cur < nums[i]) {
                return -1;
            }
        }
        return last.size();  
    }
}
```

### Complexity

- **Time Complexity:** O(n + q log q), where n is the length of `nums` and q is the number of queries (due to sorting and heap operations).
- **Space Complexity:** O(n + q), for the difference array and heap.

### Summary

- The solution uses a greedy approach with a max-heap to always use the query that covers the current index as long as possible.
- It efficiently tracks the effect of queries using a difference array.
- The answer is the maximum number of queries that can be removed while still being able to zero the array, or -1 if it's impossible.
