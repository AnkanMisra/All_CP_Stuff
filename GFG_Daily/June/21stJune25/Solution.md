# Solution Explanation

## Intuition
The problem is to maximize the number of thieves caught by policemen, where each policeman can catch only one thief and only if the thief is within `k` units of distance. The key insight is to use two queues to keep track of the positions of policemen and thieves as we scan the array from left to right.

## Approach
1. **Use Two Queues:**  
   - One queue for the indices of policemen (`'P'`).
   - One queue for the indices of thieves (`'T'`).
2. **Scan the Array:**  
   - For each character, add its index to the appropriate queue.
3. **Pair Policemen and Thieves:**  
   - While both queues are not empty:
     - If the policeman and thief at the front of their queues are within `k` distance, increment the count and remove both from their queues.
     - If the policeman is to the left of the thief, remove the policeman (he can't catch any thief to his right within `k`).
     - Otherwise, remove the thief (he can't be caught by any policeman to his left within `k`).
4. **Return the Result:**  
   - The total number of successful catches.

## Complexity
- **Time Complexity:** O(n), where n is the length of the array (each element is processed at most once).
- **Space Complexity:** O(n), for the queues.

## Summary
**By using two queues to track the positions of policemen and thieves, and greedily pairing the closest possible matches, we can efficiently compute the maximum number of thieves that can be caught.**  
This approach is optimal and works well within the given constraints.

```java
class Solution {
    public int catchThieves(char[] arr, int k) {
        Queue<Integer> police = new LinkedList<>(), thieves = new LinkedList<>();
        int caught = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.offer(i);
            else thieves.offer(i);
        }
        while (!police.isEmpty() && !thieves.isEmpty()) {
            if (Math.abs(police.peek() - thieves.peek()) <= k) {
                caught++;
                police.poll();
                thieves.poll();
            } else if (police.peek() < thieves.peek()) police.poll();
            else thieves.poll();
        }
        return caught;
    }
}
