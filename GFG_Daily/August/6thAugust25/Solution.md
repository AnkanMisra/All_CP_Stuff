
# Solution Explanation

## Intuition
The key insight is that Roman numerals are generally written from **largest to smallest values** (left to right). However, when a **smaller numeral appears before a larger one**, it represents **subtraction** (e.g., IV = 4, IX = 9). We can process the string from **right to left** and keep track of the **previous value** to determine whether to add or subtract the current value.

## Approach
1. **Create a mapping** of Roman characters to their integer values
2. **Traverse the string from right to left** (reverse order)
3. For each character:
   - Get its corresponding integer value
   - If the current value is **less than the previous value**, it means we need to **subtract** (subtraction case)
   - Otherwise, **add** the current value to the result
   - Update the previous value for the next iteration
4. Return the final result

## Algorithm
1. Initialize `result = 0` and `prevValue = 0`
2. Create a map: `{'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}`
3. For each character from **right to left**:
   - Get `currentValue` from the map
   - If `currentValue < prevValue`: `result -= currentValue`
   - Else: `result += currentValue`
   - Set `prevValue = currentValue`
4. Return `result`

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string
- **Space Complexity:** `O(1)` as we only use constant extra space

## Summary
This approach works because **Roman numeral subtraction cases** only occur when a smaller value precedes a larger one. By processing from right to left, we can easily detect these cases by comparing with the previous (larger) value. The algorithm handles all **standard Roman numeral patterns** including subtraction cases like IV, IX, XL, XC, CD, and CM.

