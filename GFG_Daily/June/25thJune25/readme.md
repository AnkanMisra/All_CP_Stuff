# Problem: Check if Frequencies Can Be Equal

## Problem Description

Given a string `s` consisting only of lowercase alphabetic characters, check whether it is possible to remove **at most one character** such that the frequency of each distinct character in the string becomes the same. Return `true` if it is possible; otherwise, return `false`.

## Input Format

- A string `s` of lowercase English letters.

## Output Format

- Return `true` if it is possible to remove at most one character so that all remaining characters have the same frequency, otherwise return `false`.

## Examples

### Example 1

**Input:**  
s = "xyyz"

**Output:**  
true

**Explanation:**  
Removing one 'y' will make the frequency of each distinct character 1.

### Example 2

**Input:**  
s = "xyyzz"

**Output:**  
true

**Explanation:**  
Removing one 'x' will make the frequency of each distinct character 2.

### Example 3

**Input:**  
s = "xxxxyyzz"

**Output:**  
false

**Explanation:**  
Frequency cannot be made the same by removing at most one character.

## Constraints

- 1 ≤ s.size() ≤ 10^5
