# Solution Explanation

### Intuition

To make a string a palindrome with the minimum number of deletions, we need to keep the longest palindromic subsequence (LPS) and delete the rest. The minimum number of deletions is the length of the string minus the length of its LPS.

### Approach

- The LPS of a string is the longest subsequence that is a palindrome.
- The LPS can be found by computing the longest common subsequence (LCS) between the string and its reverse.
- Use dynamic programming with memoization to compute the LCS between the string and its reverse.
- The answer is the length of the string minus the length of the LPS.

### Code

```java
class Solution {
    static int find(int i, int j, String a, String s, int dp[][]) {
        if (i < 0 || j < 0 || i >= a.length() || j >= s.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (a.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 1 + find(i - 1, j - 1, a, s, dp);
        } else {
            return dp[i][j] = Math.max(find(i - 1, j, a, s, dp), find(i, j - 1, a, s, dp));
        }
    }

    static int minDeletions(String s) {
        StringBuilder str = new StringBuilder(s);
        String a = str.reverse().toString();
        int dp[][] = new int[a.length()][a.length()];
        for (int v[] : dp) Arrays.fill(v, -1);
        return s.length() - find(s.length() - 1, s.length() - 1, s, a, dp);
    }
}
```

### Complexity

- **Time Complexity:** O(n^2), where n is the length of the string (due to the DP table).
- **Space Complexity:** O(n^2), for the DP table.

### Summary

- The solution finds the minimum number of deletions by keeping the longest palindromic subsequence.
- It uses dynamic programming to efficiently compute the LCS between the string and its reverse.
- The answer is the string length minus the LPS length.
