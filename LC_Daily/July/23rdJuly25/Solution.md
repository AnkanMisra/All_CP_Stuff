

# Solution Explanation

## Intuition
To maximize the score, always remove the substring with the higher point value first, since removing one pair may block the formation of the other. This greedy approach ensures the highest possible score.

## Approach
- **Step 1:** Decide which substring (`ab` or `ba`) yields more points. Remove all occurrences of the higher-value substring first, scanning the string left to right and greedily removing pairs as they appear.
- **Step 2:** After the first pass, process the remaining string to remove all occurrences of the lower-value substring, again greedily.
- **Step 3:** Accumulate the total score from both passes and return it.

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string, since each character is processed at most twice.
- **Space Complexity:** `O(n)` for the stack (or StringBuilder) used to simulate removals.

## Summary
This greedy two-pass approach guarantees the maximum score by always prioritizing the higher-value substring. It efficiently handles all edge cases and ensures optimal performance for large inputs.


