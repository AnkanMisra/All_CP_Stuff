# Solution Explanation

## Intuition

This problem is a variant of the **Longest Increasing Subsequence (LIS)**, but with custom rules for adjacency:
- Adjacent words in the subsequence must have different groups.
- The words must be of equal length and have a Hamming distance of exactly 1.

We use dynamic programming to build the longest valid subsequence ending at each index.

---

## Approach

1. **Dynamic Programming (DP):**
   - Let `dp[i]` be the length of the longest valid subsequence ending at index `i`.
   - Let `prev[i]` store the previous index in the subsequence for reconstruction.

2. **Transition:**
   - For each `i`, check all `j < i`:
     - If `groups[i] != groups[j]`
     - If `words[i]` and `words[j]` are the same length
     - If their Hamming distance is 1
     - Then, if `dp[j] + 1 > dp[i]`, update `dp[i]` and `prev[i]`.

3. **Reconstruction:**
   - Track the index with the maximum `dp[i]`.
   - Use the `prev` array to reconstruct the subsequence.

---

## Code

```java
class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] &&
                    words[i].length() == words[j].length() &&
                    hammingDistance(words[i], words[j]) == 1) {
                    
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        // Reconstruct the subsequence
        LinkedList<String> result = new LinkedList<>();
        int current = endIndex;
        while (current != -1) {
            result.addFirst(words[current]);
            current = prev[current];
        }

        return result;
    }

    private int hammingDistance(String a, String b) {
        int dist = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
```

---

## Complexity Analysis

- **Time Complexity:**  
  \(O(n^2 \cdot L)\), where \(n\) is the number of words and \(L\) is the maximum word length (since Hamming distance is checked for each pair).
- **Space Complexity:**  
  \(O(n)\) for the DP and previous index arrays.

---

## Summary

- The solution uses DP to find the longest valid subsequence under custom adjacency rules.
- The answer is reconstructed using a `prev` array.
- Efficient for the given constraints (\(n \leq 1000\), \(L \leq 10\)).
