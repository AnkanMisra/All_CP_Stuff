# Solution Explanation

## Intuition
Yousef can use the button at any moment to open all closed doors for `x` seconds. To guarantee passing through all doors, the longest segment of consecutive doors containing all the closed doors must be at most `x` in length. In other words, the distance (in seconds) from the first closed door to the last closed door must be less than `x` for Yousef to pass through all closed doors in one button press.

## Approach
- For each test case, scan the array of doors and record the position of the first closed door (`d`) and the last closed door (`e`).
- The minimum time needed to pass through all closed doors is `e - d + 1` seconds, but since Yousef can start pressing the button at any time, the key is whether the interval from the first to the last closed door fits within the button's duration.
- If `e - d < x`, then Yousef can pass through all closed doors in one button press, so output "YES".
- Otherwise, output "NO".

## Complexity
- Time Complexity: O(n) per test case, where n is the number of doors.
- Space Complexity: O(1), only a few variables are used.

## Summary
By finding the first and last closed doors and checking if the interval between them is less than the button's duration, we can efficiently determine if Yousef can reach the exit using the button at most once.
