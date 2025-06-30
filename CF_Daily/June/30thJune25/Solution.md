# Solution Explanation

## Intuition
The key insight is to use a **greedy approach** for both minimum and maximum numbers:
- For the **minimum number**: place digits as far **right** as possible to minimize the overall value, but ensure the first digit is at least 1 (no leading zeros)
- For the **maximum number**: place digits as far **left** as possible to maximize the overall value

## Approach
1. **Handle edge cases first:**
   - If `s = 0` and `m > 1`: impossible (can't have multi-digit number with sum 0 without leading zeros)
   - If `s > 9 × m`: impossible (maximum possible sum with m digits is 9m)
   - If `s = 0` and `m = 1`: return `"0 0"`

2. **For minimum number:**
   - **Reserve 1** for the first digit to avoid leading zeros
   - **Distribute remaining sum** `(s - 1)` from right to left
   - At each position from right to left, place the **maximum possible digit** (up to 9)
   - Finally, **add the reserved 1** to the first digit
   - This ensures the smallest possible number while avoiding leading zeros

3. **For maximum number:**
   - **Distribute the full sum** from left to right
   - At each position, place the **maximum possible digit** (minimum of 9 and remaining sum)
   - This creates the largest possible number by placing higher digits in more significant positions

## Algorithm
1. **Input validation:**
   - Read `m` (length) and `s` (digit sum)
   - If `s = 0` and `m = 1`: output `"0 0"` and return
   - If `s = 0` and `m > 1` or `s > 9 × m`: output `"-1 -1"` and return

2. **Construct minimum number:**
   - Initialize `minDigits[]` array of size `m` with zeros
   - Set `remaining = s - 1` (reserve 1 for first digit)
   - For each position from right to left: place `min(9, max(0, remaining))`
   - Add the reserved 1 to `minDigits[0]`

3. **Construct maximum number:**
   - Initialize `maxDigits[]` array of size `m` with zeros  
   - Set `remaining = s`
   - For each position from left to right: place `min(9, remaining)`
   - Update remaining sum after each placement

4. **Output both numbers as space-separated strings**

## Complexity
- **Time Complexity:** `O(m)` - we iterate through the m digits to construct both numbers
- **Space Complexity:** `O(m)` - we use arrays of size m to store the digits

## Summary
This **greedy approach** works because:
- For minimum: placing larger digits rightward minimizes the overall value while maintaining no leading zeros
- For maximum: placing larger digits leftward maximizes the overall value
- **Key insight**: reserving 1 for the first digit of minimum number elegantly handles the leading zero constraint
- **Edge cases handled**: impossible digit sums, zero sum scenarios, and boundary conditions
- The solution efficiently constructs both numbers in linear time by optimally distributing the digit sum

