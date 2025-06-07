# Longest Span in Two Binary Arrays

## Problem Statement

Given two binary arrays, `a1[]` and `a2[]`, find the length of the longest common span `(i, j)` where `j >= i` such that:

`a1[i] + a1[i+1] + ... + a1[j] = a2[i] + a2[i+1] + ... + a2[j]`

## Input Format

- Two binary arrays `a1[]` and `a2[]` of the same length.

## Output Format

- An integer representing the length of the longest span with the same sum in both arrays.

## Constraints

- 1 ≤ a1.size() = a2.size() ≤ 10^6
- 0 ≤ a1[i], a2[i] ≤ 1

## Examples

### Example 1

Input:  
a1[] = [0, 1, 0, 0, 0, 0]  
a2[] = [1, 0, 1, 0, 0, 1]  

Output:  
4  

Explanation:  
The longest span with the same sum is from index 1 to 4 (zero-based indexing).

### Example 2

Input:  
a1[] = [0, 1, 0, 1, 1, 1, 1]  
a2[] = [1, 1, 1, 1, 1, 0, 1]  

Output:  
6  

Explanation:  
The longest span with the same sum is from index 1 to 6 (zero-based indexing).
