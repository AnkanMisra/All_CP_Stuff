# Solution Explanation

## Intuition
The goal is to simulate the robot's operations to produce the lexicographically smallest string possible. At each step, you can either move the next character from `s` to the stack `t`, or pop the smallest available character from `t` to the result. The key is to always write the smallest possible character to the result as soon as it is safe to do so.

## Approach
- Precompute, for each position in `s`, the index of the smallest character in the suffix starting at that position. This allows us to know, at any point, the smallest character that will appear in the remaining part of `s`.
- Use a stack to simulate the robot's string `t`.
- Iterate through `s`:
  - If the stack is not empty, and the top of the stack is less than or equal to the smallest character left in `s`, pop from the stack and append to the result.
  - Otherwise, push the next character from `s` onto the stack.
- After processing all characters in `s`, pop any remaining characters from the stack to the result.

## Complexity
- Time Complexity: O(n), where n is the length of `s`. Each character is pushed and popped at most once.
- Space Complexity: O(n), for the stack and the suffix minimum array.

## Summary
By always comparing the top of the stack with the smallest character left in `s`, we ensure that we write the smallest possible character to the result at every step, thus constructing the lexicographically smallest string.
