# Case-specific Sorting of Strings

## Constraints
- 1 ≤ s.length() ≤ 10^5

## Problem Statement
Given a string **s** consisting of only uppercase and lowercase characters, the task is to sort uppercase and lowercase letters separately such that if the ith place in the original string had an uppercase character, then it should not have a lowercase character after being sorted, and vice versa.

## Input Format
- A single string **s** consisting of only uppercase and lowercase English letters.

## Output Format
- Output the case-specific sorted string as described.

## Examples

Input:  
GEekS  
Output:  
EGekS  
Explanation: Sorted form of the given string with the same case of character will result in output as EGekS.

Input:  
XWMSPQ  
Output:  
MPQSWX  
Explanation: Since all characters are of the same case, we can simply perform a sorting operation on the entire string.
