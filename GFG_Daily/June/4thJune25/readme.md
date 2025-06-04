# LCS of Three Strings

## Problem Statement
Given three strings `s1`, `s2`, and `s3` containing uppercase letters, lowercase letters, and digits, find the length of the longest common subsequence (LCS) present in all three strings.

## Input Format
- Three strings `s1`, `s2`, and `s3`.

## Output Format
- An integer representing the length of the longest common subsequence among the three strings.

## Constraints
- 1 ≤ s1.size(), s2.size(), s3.size() ≤ 100

## Examples

### Example 1
Input:  
s1 = "geeks"  
s2 = "geeksfor"  
s3 = "geeksforgeeks"  

Output:  
5  

Explanation:  
"geeks" is the longest common subsequence with length 5.

### Example 2
Input:  
s1 = "abcd1e2"  
s2 = "bc12ea"  
s3 = "bd1ea"  

Output:  
3  

Explanation:  
The longest common subsequence is "b1e", so the length is 3.
