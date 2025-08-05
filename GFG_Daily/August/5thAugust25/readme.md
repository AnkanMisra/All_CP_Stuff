
# Problem: Palindrome Sentence

## Problem Description
Given a single string `s`, the task is to check if it is a **palindrome sentence** or not. A palindrome sentence is a sequence of characters, such as word, phrase, or series of symbols that reads the **same backward as forward** after converting all **uppercase letters to lowercase** and removing all **non-alphanumeric characters** (including spaces and punctuation).

## Input Format
A single string `s`.

## Output Format
Return `true` if the string is a palindrome sentence, otherwise return `false`.

## Examples

### Input
`s = "Too hot to hoot"`<br/>

### Output
`true`<br/>
**Explanation:** If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become `"toohottohoot"` which is a palindrome.

### Input
`s = "Abc 012..## 10cbA"`<br/>

### Output
`true`<br/>
**Explanation:** If we remove all non-alphanumeric characters and convert all uppercase letters to lowercase, string s will become `"abc01210cba"` which is a palindrome.

### Input
`s = "ABC $. def01ASDF"`<br/>

### Output
`false`<br/>
**Explanation:** The processed string becomes `"abcdef01asdf"`, which is not a palindrome.

## Constraints
- `1 ≤ s.length() ≤ 10^6`

