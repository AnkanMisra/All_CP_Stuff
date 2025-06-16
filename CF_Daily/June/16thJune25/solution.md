# Solution Explanation

## Intuition
The problem requires converting a word to either all lowercase or all uppercase, depending on which case is more frequent. If the counts are equal, convert to all lowercase. This ensures the minimum number of letter changes.

## Approach
- Count the number of uppercase and lowercase letters in the input word.
- If the number of uppercase letters is greater than the number of lowercase letters, convert the entire word to uppercase.
- Otherwise (including the case when counts are equal), convert the entire word to lowercase.
- Print the result.

## Complexity
- Time Complexity: O(n), where n is the length of the word, since we scan the word once.
- Space Complexity: O(1), as only a few counters and the result string are used.

## Summary
By counting the uppercase and lowercase letters and converting the word accordingly, we ensure the minimum number of changes and meet the problem's requirements.
