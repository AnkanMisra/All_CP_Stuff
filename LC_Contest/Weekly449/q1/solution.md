
# Solution Explanation

## Intuition

The problem asks us to minimize the number of deletions needed so that the string contains at most `k` distinct characters.  
Since each deletion removes a character, the optimal way is to **completely remove the least frequent characters** until only `k` distinct characters remain.

---

## Approach

1. **Count Frequencies:**  
   Count the frequency of each character in the string.

2. **Sort Frequencies:**  
   Store the frequencies of all distinct characters in a list and sort it in ascending order.

3. **Delete Least Frequent Characters:**  
   If the number of distinct characters is already less than or equal to `k`, no deletions are needed.  
   Otherwise, delete all occurrences of the least frequent characters until only `k` distinct characters remain.  
   The minimum number of deletions is the sum of the frequencies of the characters you remove.

---

## Algorithm

1. Create an array `a` of size 26 to count the frequency of each lowercase letter.
2. Iterate through the string and increment the count for each character.
3. Add all non-zero frequencies to a list `c`.
4. Sort the list `c` in ascending order.
5. If the number of distinct characters (`e`) is less than or equal to `k`, return 0.
6. Otherwise, sum the frequencies of the `e - k` least frequent characters and return this sum.

---

## Code

```java
class Solution {
  public int minDeletion(String s, int k) {
    int[] a = new int[26];
    for (char b : s.toCharArray()) {
      a[b - 'a']++;
    }
    List<Integer> c = new ArrayList<>();
    for (int d = 0; d < 26; d++) {
      if (a[d] > 0) c.add(a[d]);
    }
    Collections.sort(c);
    int e = c.size();
    if (e <= k) return 0;
    int f = 0;
    for (int g = 0; g < e - k; g++) {
      f += c.get(g);
    }
    return f;
  }
}
```

---

## Complexity Analysis

- **Time Complexity:**  
  \(O(n + 26 \log 26)\), where \(n\) is the length of the string.  
  - Counting frequencies takes \(O(n)\).
  - Sorting at most 26 frequencies takes \(O(26 \log 26)\), which is effectively constant.

- **Space Complexity:**  
  \(O(1)\), since the frequency array and list size are bounded by 26.

---

## Edge Cases

- If `k` is greater than or equal to the number of distinct characters, no deletions are needed.
- If all characters are the same, no deletions are needed for any `k >= 1`.
- If `k` is 0, all characters must be deleted.

---

## Summary

This approach efficiently finds the minimum number of deletions by always removing the least frequent characters first, ensuring that the number of distinct characters in the string does not exceed `k`.
