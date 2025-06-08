# Solution Explanation

## Intuition
The problem is to check if a string of digits can be split into a sequence where each number (from the third onwards) is the sum of the previous two, and no number has leading zeros (unless it is '0'). This is similar to the "Additive Number" problem, but the sum-string property must hold for the entire string.

## Approach
- Try all possible ways to split the string into the first two numbers (`s1` and `s2`).
- For each split, check if the rest of the string can be built by repeatedly summing the previous two numbers and matching the next part of the string.
- Use a helper function to add two numbers as strings to handle large numbers.
- Ensure that no number in the split has leading zeros (unless it is exactly '0').
- If any valid split is found, return `true`; otherwise, return `false`.

## Complexity
- Time Complexity: O(n^3), where n is the length of the string. This is because we try all possible splits for the first two numbers and, for each, may scan the rest of the string.
- Space Complexity: O(n) for recursion and string operations.

## Summary
By trying all possible initial splits and recursively checking the sum-string property, we can determine if the string is a sum-string. The approach handles large numbers by working with strings and ensures no leading zeros are present in any number.
