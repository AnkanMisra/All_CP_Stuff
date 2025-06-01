# Solution Explanation

### Intuition

Given that each row and column of the matrix is sorted, we can efficiently find the kth smallest element using a min-heap (priority queue). The idea is similar to merging k sorted lists.

### Approach

- Use a min-heap to keep track of the next smallest element in each row.
- Initially, insert the first element of each row into the heap along with its row and column indices.
- Pop the smallest element from the heap and, if there is a next element in the same row, insert it into the heap.
- Repeat this process k-1 times. The kth smallest element will be at the top of the heap.

### Code

```java
class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);  // {value, row, col}
        for (int i = 0; i < n; i++)
            pq.offer(new int[]{mat[i][0], i, 0});
        
        while (--k > 0) {
            int[] curr = pq.poll();
            if (curr[2] + 1 < n)
                pq.offer(new int[]{mat[curr[1]][curr[2] + 1], curr[1], curr[2] + 1});
        }
        return pq.peek()[0];
    }
}
```

### Complexity

- **Time Complexity:** O(k log n), where n is the number of rows (since the heap size is at most n and we do k pops).
- **Space Complexity:** O(n), for the heap.

### Summary

- The solution uses a min-heap to efficiently find the kth smallest element in a sorted matrix.
- It always keeps track of the next smallest candidate from each row.
- This approach is optimal for the given constraints.
