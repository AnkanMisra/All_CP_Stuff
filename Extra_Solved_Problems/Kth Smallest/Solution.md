# Solution Explanation

## Intuition
The problem is to find the kth smallest element in an array without using the inbuilt sort function. The key insight is to use a max-heap (priority queue with reverse order) of size k to keep track of the k smallest elements seen so far.

## Approach
1. **Use a Max-Heap:**  
   - Create a max-heap (priority queue in reverse order).
2. **Iterate Through the Array:**  
   - For each element, add it to the heap.
   - If the heap size exceeds k, remove the largest element (the root of the max-heap).
   - This ensures the heap always contains the k smallest elements seen so far.
3. **Result:**  
   - After processing all elements, the root of the heap is the kth smallest element.

## Complexity
- **Time Complexity:** O(n log k), where n is the length of the array (each insertion/removal in the heap takes O(log k)).
- **Space Complexity:** O(k), for the heap.

## Summary
**By maintaining a max-heap of size k, we efficiently track the k smallest elements and retrieve the kth smallest in O(n log k) time.**  
This approach is optimal for large arrays and avoids sorting the entire array.

```java
class Solution {
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : arr) {
            pq.add(x);
            if (pq.size() > k) {
                pq.poll(); 
            }
        }
        return pq.peek(); 
    }
}
