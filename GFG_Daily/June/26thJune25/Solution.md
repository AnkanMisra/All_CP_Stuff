# Solution Explanation

## Intuition
The problem asks for the minimum possible value of a string after removing exactly `k` characters, where the value is the sum of the squares of the frequencies of each distinct character. The key insight is that to minimize the sum of squares, we should always remove a character from the most frequent letter available.

## Approach
1. **Count Frequencies:**  
   - Count the frequency of each character in the string.
2. **Use a Max-Heap:**  
   - Add all non-zero frequencies to a max-heap (priority queue in reverse order).
3. **Remove Characters Greedily:**  
   - For `k` times, remove one occurrence from the character with the highest frequency (i.e., poll the max from the heap, decrement it, and add it back if it's still positive).
4. **Calculate the Result:**  
   - After all removals, sum the squares of the remaining frequencies in the heap.
5. **Return the Result:**  
   - The result is the minimum possible value of the string.

## Complexity
- **Time Complexity:** O(n + k log n), where n is the length of the string (for counting and heap operations).
- **Space Complexity:** O(1) (since there are at most 26 characters, the heap size is bounded).

## Summary
**By always removing a character from the most frequent letter, we minimize the sum of squares of frequencies, which is the optimal greedy strategy for this problem.**  
This approach is efficient and works well for large strings.

```java
class Solution {
    public int minValue(String s, int k) {
        int[] freq = new int[26];
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq){
            if(f > 0) maxHeap.add(f);
        }
        
        while(k-- > 0  && !maxHeap.isEmpty()){
            int top = maxHeap.poll();
            if(top > 1){
                maxHeap.add(top - 1);
            }
        }
        
        int result = 0;
        
        while(!maxHeap.isEmpty()){
            int f = maxHeap.poll();
            result += f*f;
        }
        
        return result;
    }
}
