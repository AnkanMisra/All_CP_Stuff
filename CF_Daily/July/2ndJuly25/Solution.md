# Solution Explanation

## Intuition
The key insight is to **work backwards from the target `m` to the starting number `n`**. Instead of thinking "how do we get from `n` to `m`", we ask "**how could we have reached `m`?**" This reverse approach allows us to make **greedy choices** at each step.

When working backwards:
- If `m` is **odd**, the last operation must have been a **blue button press** (subtract 1), so we reverse it by adding 1
- If `m` is **even**, it's optimal to reverse a **red button press** (multiply by 2) by dividing by 2

## Approach
The solution uses a **greedy reverse traversal** approach:

1. **Base Case**: If `m ≤ n`, we can only use the **blue button** (subtract 1) to go from `n` to `m`, requiring exactly `n - m` presses.

2. **Reverse Greedy Process**: When `m > n`, we work backwards from `m`:
   - **Odd `m`**: Add 1 to `m` (reverse of blue button operation)
   - **Even `m`**: Divide `m` by 2 (reverse of red button operation)
   - Count each reverse operation as one button press

3. **Final Step**: Once `m ≤ n`, add the remaining difference `n - m` to account for the blue button presses needed to reach the final target.

## Algorithm
1. Read input values `n` and `m`
2. If `m ≤ n`, return `n - m`
3. Initialize `presses = 0`
4. While `m > n`:
   - If `m` is odd: `m = m + 1`
   - If `m` is even: `m = m / 2`
   - Increment `presses`
5. Add `n - m` to `presses`
6. Return `presses`

## Complexity
- **Time Complexity**: `O(log m)` - In the worst case, we repeatedly halve `m`, which takes logarithmic time
- **Space Complexity**: `O(1)` - Only using a constant amount of extra space

## Summary
This **reverse greedy approach** works because when working backwards, the optimal choice at each step is clear: for odd numbers we must reverse a subtraction, and for even numbers it's always better to reverse a multiplication rather than a subtraction. The algorithm efficiently finds the minimum operations by **avoiding unnecessary red button presses** when `m ≤ n` and making **optimal reverse choices** when `m > n`. Key corner case: when the target is smaller than or equal to the starting number, only blue button operations are needed.

