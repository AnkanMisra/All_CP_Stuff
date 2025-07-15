
# Solution Explanation

## Intuition
- The main idea is to **validate a word based on multiple criteria**: length, allowed characters, and the presence of both vowels and consonants.
- Since the word can contain digits and both uppercase and lowercase letters, but no special characters, we need to check each character carefully.

## Approach
- First, check if the length of the word is at least 3. If not, return `false` immediately.
- Initialize two boolean flags: `hasVowel` and `hasConsonant` to track the presence of vowels and consonants.
- Iterate through each character in the word:
  - If the character is **not** a letter or digit, return `false` (invalid character).
  - If the character is a letter:
    - If it is a vowel (`a`, `e`, `i`, `o`, `u` or their uppercase forms), set `hasVowel` to `true`.
    - Otherwise, set `hasConsonant` to `true`.
- After the loop, return `true` only if both `hasVowel` and `hasConsonant` are `true`.

## Complexity
- **Time Complexity:** `O(n)`, where `n` is the length of the word.
- **Space Complexity:** `O(1)`, as only a constant amount of extra space is used for flags and the vowel string.

## Summary
- This approach efficiently checks all the required conditions in a single pass through the word.
- It ensures the word is long enough, contains only valid characters, and includes at least one vowel and one consonant.
- The solution is robust for all edge cases, including words with only digits, only vowels, only consonants, or invalid characters.

