# 1061. Lexicographically Smallest Equivalent String

## Problem Statement
You are given two strings of the same length `s1` and `s2`, and a string `baseStr`.

We say `s1[i]` and `s2[i]` are equivalent characters. Equivalent characters follow the rules of an equivalence relation:
- Reflexivity: Every character is equivalent to itself.
- Symmetry: If 'a' is equivalent to 'b', then 'b' is equivalent to 'a'.
- Transitivity: If 'a' is equivalent to 'b' and 'b' is equivalent to 'c', then 'a' is equivalent to 'c'.

Given the equivalency information from `s1` and `s2`, return the lexicographically smallest equivalent string of `baseStr` by replacing each character with the smallest character in its equivalence group.

## Input Format
- `s1`: a string of lowercase English letters.
- `s2`: a string of lowercase English letters, same length as `s1`.
- `baseStr`: a string of lowercase English letters.

## Output Format
- Return the lexicographically smallest equivalent string of `baseStr` using the equivalency information from `s1` and `s2`.

## Constraints
- 1 <= s1.length, s2.length, baseStr.length <= 1000
- s1.length == s2.length
- s1, s2, and baseStr consist of lowercase English letters.

## Examples

### Example 1
Input:  
s1 = "parker", s2 = "morris", baseStr = "parser"  
Output:  
"makkek"  
Explanation:  
Based on the equivalency information, the groups are [m,p], [a,o], [k,r,s], [e,i].  
The answer is "makkek".

### Example 2
Input:  
s1 = "hello", s2 = "world", baseStr = "hold"  
Output:  
"hdld"  
Explanation:  
Groups are [h,w], [d,e,o], [l,r].  
Only the second letter 'o' in baseStr is changed to 'd', so the answer is "hdld".

### Example 3
Input:  
s1 = "leetcode", s2 = "programs", baseStr = "sourcecode"  
Output:  
"aauaaaaada"  
Explanation:  
Groups are [a,o,e,r,s,c], [l,p], [g,t], [d,m].  
All letters in baseStr except 'u' and 'd' are transformed to 'a', so the answer is "aauaaaaada".
