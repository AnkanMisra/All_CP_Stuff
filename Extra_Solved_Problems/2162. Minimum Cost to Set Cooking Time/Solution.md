
# Solution Explanation

## Intuition
The **key insight** is that for any given `targetSeconds`, there can be **multiple valid minute-second combinations** that represent the same total time. For example, `600` seconds can be represented as `10:00` (10 minutes, 0 seconds) or `9:60` (9 minutes, 60 seconds). Since the microwave accepts **at most 4 digits** and normalizes by prepending zeros, we need to find the representation that **minimizes the total cost** of finger movements and button presses.

## Approach
The solution uses a **brute force enumeration** approach to explore all possible valid minute-second combinations:

1. **Enumerate all possible minute values** from `0` to `99` (microwave constraint)
2. For each minute value, **calculate the corresponding seconds** as `targetSeconds - mins * 60`
3. **Validate the seconds range** - must be between `0` and `99` (microwave constraint)
4. **Generate the 4-digit representation** by zero-padding both minutes and seconds to 2 digits each
5. **Remove leading zeros** while keeping at least one digit (microwave normalization)
6. **Calculate the cost** for pressing this digit sequence considering finger movements and pushes
7. **Track the minimum cost** across all valid representations

## Algorithm
1. Initialize `ans` to maximum value
2. For each minute value `mins` from `0` to `99`:
   - Calculate `secs = targetSeconds - mins * 60`
   - Skip if `secs < 0` or `secs > 99`
   - Format as `mmss` with zero-padding
   - Remove leading zeros to get actual button sequence
   - Calculate cost using helper function
   - Update minimum cost
3. Return the minimum cost found

**Cost Calculation Helper:**
- Start with finger at `startAt` position
- For each digit in the sequence:
  - If finger needs to move, add `moveCost`
  - Add `pushCost` for pressing the digit
  - Update finger position

## Complexity
- **Time Complexity:** `O(100)` - We iterate through at most 100 possible minute values, and for each valid combination, we process at most 4 digits
- **Space Complexity:** `O(1)` - Only using constant extra space for variables and temporary strings

## Summary
This approach works because it **exhaustively checks all possible valid representations** of the target time and finds the one with minimum cost. The **key insight** is recognizing that the same time duration can be represented in multiple ways due to the minute-second conversion (e.g., 60 seconds = 1 minute). The algorithm handles **edge cases** like leading zero removal and ensures all constraints are satisfied (minutes ≤ 99, seconds ≤ 99). The solution is efficient since there are only a **limited number of valid combinations** to check.

