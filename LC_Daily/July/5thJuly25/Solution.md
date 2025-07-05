# Solution Explanation

## Intuition
The main idea is to count the frequency of each number in the array and then check if any number's frequency matches its value. We want the **largest** such number.

## Approach
- Create a `freq` array to count the occurrences of each number in `arr` (since `arr[i]` is between 1 and 500).
- Iterate through `arr` and increment the count for each number in `freq`.
- Check from the largest possible value (500) down to 1:
  - If `freq[i] == i`, return `i` as the answer.
- If no such number is found, return `-1`.

## Complexity
- Time Complexity: `O(n + k)` where `n` is the length of `arr` and `k` is the range of possible values (here, `k = 500`).
- Space Complexity: `O(k)` for the frequency array.

## Summary
This approach efficiently finds the largest lucky integer by leveraging a frequency array and iterating from the largest possible value. It works well due to the small constraint on the values in `arr`, and ensures we always return the largest lucky integer if multiple exist. Edge cases, such as no lucky integer, are handled by returning `-1`.

