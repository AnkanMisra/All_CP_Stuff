# Solution Explanation

## Intuition

The problem asks for the smallest range that includes at least one element from each of the k sorted lists.  
The optimal way is to always keep one element from each list in a "window" and try to minimize the range between the minimum and maximum elements in this window.

## Approach

- Use a **min-heap (priority queue)** to always know the current minimum among the selected elements from each list.
- Track the **current maximum** among the selected elements.
- Initially, insert the first element from each list into the heap and set the current maximum.
- At each step:
  - Pop the minimum element from the heap.
  - Update the best range if the current range is smaller.
  - If the list from which the minimum was taken has more elements, insert the next element from that list into the heap and update the current maximum if needed.
  - If any list is exhausted, stop (since we can't have a valid range anymore).

## Algorithm

1. Initialize a min-heap and insert the first element from each list.
2. Track the current maximum among the heap elements.
3. While the heap contains one element from each list:
   - Pop the minimum.
   - Update the best range if the current range is smaller.
   - If the list of the minimum element has more elements, insert the next element from that list and update the current maximum.
   - If any list is exhausted, break.
4. Return the best range found.

## Complexity

- **Time Complexity:** \(O(nk \log k)\), where \(n\) is the number of elements per list and \(k\) is the number of lists.
- **Space Complexity:** \(O(k)\) for the heap.

## Code

```java
class Solution {
    static class Node {
        int val, row, col;
        Node(int v, int r, int c) {
            val = v; row = r; col = c;
        }
    }
    
    public ArrayList<Integer> findSmallestRange(int[][] arr) {
        int k = arr.length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        int currentMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < k; i++) {
            pq.offer(new Node(arr[i][0], i, 0));
            currentMax = Math.max(currentMax, arr[i][0]);
        }
        
        int bestL = 0, bestR = Integer.MAX_VALUE;
        
        while (true) {
            Node mn = pq.poll();
            int currentMin = mn.val;
            
            if (currentMax - currentMin < bestR - bestL) {
                bestL = currentMin;
                bestR = currentMax;
            }
            
            if (mn.col + 1 == arr[mn.row].length) {
                break;
            }
            int nextVal = arr[mn.row][mn.col + 1];
            pq.offer(new Node(nextVal, mn.row, mn.col + 1));
            if (nextVal > currentMax) {
                currentMax = nextVal;
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(bestL);
        ans.add(bestR);
        return ans;
    }
}
```

## Summary

- The solution uses a min-heap to always track the smallest current element and a variable to track the current maximum.
- By always advancing the list that contributed the minimum, we ensure the window always contains at least one element from each list.
- The smallest range found during this process is the answer.
