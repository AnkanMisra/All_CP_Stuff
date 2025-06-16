# A. Word

## Problem Statement

Vasya wants to standardize the case of words so that each word is either all lowercase or all uppercase, with as few changes as possible. If the word contains an equal number of uppercase and lowercase letters, it should be converted to all lowercase.

Given a word `s`, change its case according to these rules.

## Input Format

- The first line contains a word `s` (1 ≤ |s| ≤ 100), consisting of uppercase and lowercase Latin letters.

## Output Format

- Print the corrected word `s`:
  - If the word has strictly more uppercase letters, print it in all uppercase.
  - Otherwise, print it in all lowercase.

## Examples

### Input
HoUse

### Output
house

---

### Input
ViP

### Output
VIP

---

### Input
maTRIx

### Output
matrix

## Explanation

- In the first example, there are more lowercase letters, so the word is converted to all lowercase.
- In the second example, there are more uppercase letters, so the word is converted to all uppercase.
- In the third example, the number of uppercase and lowercase letters is equal, so the word is converted to all lowercase.
