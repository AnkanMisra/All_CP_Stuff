# Solution Explanation

## Intuition
To find the number of distinct strings that can be obtained by exactly one swap, we need to consider all possible pairs of indices `(i, j)` (`i < j`). Swapping two identical characters does not change the string, so such swaps do not create new strings. If the string has duplicate characters, the original string can be obtained by swapping two identical characters, so it should be counted as well.

## Approach
- Count the frequency of each character in the string.
- The total number of possible swaps is `n * (n - 1) / 2` (all pairs of indices).
- For each character that appears more than once, the number of swaps that do not change the string is `count * (count - 1) / 2` for that character.
- Subtract the number of swaps that do not change the string from the total number of swaps to get the number of distinct strings that can be formed by swapping two different characters.
- If the string has any duplicate characters, the original string can be obtained by swapping two identical characters, so add 1 to the result.
- If all characters are unique, the original string cannot be obtained by any swap, so do not add 1.

## Complexity
- Time Complexity: O(n), where n is the length of the string, for counting frequencies and calculating the result.
- Space Complexity: O(1), since the frequency array size is constant (26 for lowercase English letters).

## Summary
By counting all possible swaps and subtracting those that do not change the string, and considering whether the original string can be obtained by a swap, we efficiently compute the number of distinct strings obtainable by exactly one swap.
