# Search Pattern (Rabin-Karp Algorithm)

## Problem Statement

Given two strings:
- A text string in which you want to search.
- A pattern string that you are looking for within the text.

Return all positions (1-based indexing) where the pattern occurs as a substring in the text. If the pattern does not occur, return an empty list.

All characters in both strings are lowercase English letters (a to z).

## Input Format

- `text`: The text string (1 ≤ text.size() ≤ 5 * 10^5)
- `pattern`: The pattern string (1 ≤ pattern.size() ≤ text.size())

## Output Format

- A list of integers representing all starting positions (1-based) where the pattern occurs in the text. If the pattern does not occur, return an empty list.

## Examples

### Example 1

Input:  
text = "birthdayboy"  
pattern = "birth"  

Output:  
[1]  

Explanation:  
The string "birth" occurs at index 1 in text.

### Example 2

Input:  
text = "geeksforgeeks"  
pattern = "geek"  

Output:  
[1, 9]  

Explanation:  
The string "geek" occurs twice in text, starting at indices 1 and 9.
