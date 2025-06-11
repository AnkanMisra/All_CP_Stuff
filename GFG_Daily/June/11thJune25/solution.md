# Solution Explanation

## Intuition
The problem is similar to removing adjacent duplicates in a string, but here each ball is represented by a pair `(color, radius)`. Whenever two consecutive balls have the same color and radius, they are both removed. This process is repeated until no more such pairs exist. A stack is a natural data structure for this type of problem, as it allows us to efficiently check and remove the most recent ball if it forms a removable pair with the current ball.

## Approach
- Use a stack to keep track of the balls that remain after each step.
- Iterate through the balls:
  - For each ball, check if the top of the stack has the same color and radius.
  - If so, pop the top ball from the stack (removing both balls).
  - If not, push the current ball onto the stack.
- Continue this process for all balls.
- The size of the stack at the end is the number of balls remaining after all possible removals.

## Complexity
- Time Complexity: O(n), where n is the number of balls, since each ball is pushed and popped at most once.
- Space Complexity: O(n) in the worst case, for the stack.

## Summary
By using a stack to simulate the removal process, we efficiently determine the number of balls remaining after all possible consecutive duplicate removals.
