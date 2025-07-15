
# Problem: Valid Word Checker

## Problem Description
A word is considered **valid** if:
- It contains a **minimum of 3 characters**.
- It contains **only digits (0-9) and English letters** (uppercase and lowercase).
- It includes **at least one vowel** (`a`, `e`, `i`, `o`, `u`, and their uppercase forms).
- It includes **at least one consonant** (an English letter that is not a vowel).

Given a string `word`, return `true` if `word` is valid, otherwise, return `false`.

## Input Format
- A single string `word`.

## Output Format
- Output `true` if the word is valid, otherwise output `false`.

## Examples

### Input
`word = "234Adas"`
<br/>
### Output
`true`
<br/>

### Input
`word = "b3"`
<br/>
### Output
`false`
<br/>

### Input
`word = "a3$e"`
<br/>
### Output
`false`
<br/>

## Constraints
- `1 <= word.length <= 20`
- `word` consists of English uppercase and lowercase letters, digits, `@`, `#`, and `$`.

## Notes
- Vowels are `a`, `e`, `i`, `o`, `u` and their uppercase forms.
- A consonant is any English letter that is not a vowel.
- The word must not contain any characters other than English letters and digits to be valid.

