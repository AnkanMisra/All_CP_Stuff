# Solution Explanation

## Intuition
The problem asks for the minimum number of deletions needed to make a string **k-special**, meaning the difference between the frequencies of any two characters in the string is at most `k`. The key insight is that we can either delete all occurrences of the least frequent character, or reduce the most frequent character's count, and recursively try both options to find the minimum deletions.

## Approach
1. **Count Frequencies:**  
   - Count the frequency of each character in the string.
2. **Sort Frequencies:**  
   - Store all non-zero frequencies in a list and sort it.
3. **Recursive Search:**  
   - Use a recursive function to try two options:
     - Remove all occurrences of the least frequent character (move left pointer).
     - Reduce the most frequent character so that its frequency is at most `k` more than the least frequent (move right pointer and add the difference to deletions).
   - Continue until the difference between the largest and smallest frequency is at most `k`.
   - Return the minimum deletions found.

## Complexity
- **Time Complexity:** O(26 log 26 + 2^26) in the worst case (since there are at most 26 unique characters, the recursion is manageable).
- **Space Complexity:** O(26) for the frequency array and recursion stack.

## Summary
**By recursively considering the removal of the least or most frequent character, and always choosing the minimum deletions, we can efficiently find the minimum number of deletions needed to make the string k-special.**  
This approach leverages the small number of unique characters in the English alphabet.

```java
class Solution {
    public int minimumDeletions(String word, int k) {
        int[] memo = new int[26];
        for (char c : word.toCharArray()) {
            memo[c-'a']++;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int m : memo) {
            if(m != 0) list.add(m);
        }
        Collections.sort(list);
        int l = 0, r = list.size()-1;
        return getMin(list, l, r, k, 0);

    }

    private int getMin(List<Integer> list, int l, int r, int k, int min) {
        if(l>=r) return min;
        if((list.get(r) - list.get(l)) > k) {
            int leftMin = getMin(list, l+1, r, k, min+list.get(l));
            int rightMin = getMin(list, l, r-1, k, min+(list.get(r)-list.get(l)-k));
            return Math.min(leftMin, rightMin);
        }
        return min;
    }
}
