
# Count Unique Vowel Strings

## Problem Description
Given a lowercase string `s`, determine the **total number of distinct strings** that can be formed using the following rules:

- Identify all **unique vowels** (`a`, `e`, `i`, `o`, `u`) present in the string.
- For each distinct vowel, **choose exactly one of its occurrences** from `s`. If a vowel appears multiple times, each occurrence represents a unique selection choice.
- Generate **all possible permutations** of the selected vowels. Each unique arrangement counts as a distinct string.

Return the **total number of such distinct strings**.

## Input Format
- A single line containing the lowercase string `s`.

## Output Format
- A single integer representing the **total number of distinct strings** that can be formed.

## Examples

### Input
`aeiou`<br/>

### Output
`120`<br/>

### Input
`ae`<br/>

### Output
`2`<br/>

### Input
`aacidf`<br/>

### Output
`4`<br/>

## Constraints
- `1 ≤ s.size() ≤ 100`

## Notes
- Each vowel must be selected exactly once, and each selection is from a unique occurrence in `s`.
- The answer counts all possible orderings (permutations) of the selected vowels.

