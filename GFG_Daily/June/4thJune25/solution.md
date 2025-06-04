# Solution Explanation

## Intuition
The problem is a classic extension of the Longest Common Subsequence (LCS) problem, but for three strings instead of two. The main idea is to use dynamic programming to efficiently compute the LCS length by considering all prefixes of the three strings.

## Approach
- Use a 3D dynamic programming table `dp[i][j][k]` where each entry represents the length of the LCS for the first `i` characters of `s1`, the first `j` characters of `s2`, and the first `k` characters of `s3`.
- Initialize the table with zeros, as the LCS of any string with an empty string is zero.
- Iterate through all possible positions in the three strings:
  - If the current characters in all three strings match, increment the LCS length by 1 from the previous state (`dp[i-1][j-1][k-1]`).
  - If they do not match, take the maximum LCS length by excluding the current character from one of the strings (i.e., consider `dp[i-1][j][k]`, `dp[i][j-1][k]`, or `dp[i][j][k-1]`).
- The answer is found at `dp[n][m][o]`, where `n`, `m`, and `o` are the lengths of `s1`, `s2`, and `s3` respectively.

## Algorithm
1. Create a 3D array `dp` of size `(n+1) x (m+1) x (o+1)` initialized to zero.
2. For each `i` from 1 to `n`, each `j` from 1 to `m`, and each `k` from 1 to `o`:
   - If `s1[i-1] == s2[j-1] == s3[k-1]`, set `dp[i][j][k] = 1 + dp[i-1][j-1][k-1]`.
   - Otherwise, set `dp[i][j][k]` to the maximum of `dp[i-1][j][k]`, `dp[i][j-1][k]`, and `dp[i][j][k-1]`.
3. Return `dp[n][m][o]` as the result.

## Complexity
- Time Complexity: O(n * m * o), where n, m, and o are the lengths of the three strings.
- Space Complexity: O(n * m * o) for the 3D DP table.

## Summary
This approach efficiently computes the LCS for three strings by building up solutions for smaller prefixes using dynamic programming. By considering all possible ways to match or skip characters, it guarantees finding the longest common subsequence shared by all three strings.
