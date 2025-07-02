# Solution Explanation

## Intuition

The key insight is that an element `ai` can be the **final remaining element** if and only if it can be reached through the allowed operations. An element can be reached in two ways:
1. It is the **minimum of some prefix** - we can replace that prefix with its minimum value
2. It is the **maximum of some suffix** - we can replace that suffix with its maximum value

## Approach

The solution uses a **two-pass approach** to identify all reachable elements:

1. **Left-to-right pass**: Track the **running minimum** from the start of the array. Any element that equals the current minimum can be reached by replacing the prefix ending at that position with its minimum value.

2. **Right-to-left pass**: Track the **running maximum** from the end of the array. Any element that equals the current maximum can be reached by replacing the suffix starting at that position with its maximum value.

3. **Combine results**: An element is reachable if it satisfies **either condition** from the two passes above.

## Algorithm

1. Initialize a **boolean array** to track reachable elements
2. **First pass** (left to right):
   - Maintain `minSoFar` starting from the first element
   - For each position, update `minSoFar = min(minSoFar, current_element)`
   - If `current_element == minSoFar`, mark it as reachable
3. **Second pass** (right to left):
   - Maintain `maxSoFar` starting from the last element  
   - For each position, update `maxSoFar = max(maxSoFar, current_element)`
   - If `current_element == maxSoFar`, mark it as reachable
4. **Build result**: Create binary string where `'1'` represents reachable elements and `'0'` represents unreachable ones

## Complexity

- **Time Complexity:** `O(n)` - Two single passes through the array
- **Space Complexity:** `O(n)` - Boolean array to track reachable elements and result string

## Summary

This approach works because it identifies all elements that can be **"exposed"** through the allowed operations. An element can only be the final result if it can become the sole remaining element through a sequence of prefix minimum or suffix maximum operations. The **two-pass technique** efficiently captures all such elements by checking both directions of potential reachability.

Key insight: The operations essentially allow us to **"peel away"** elements that are not optimal (not minimum in prefix or not maximum in suffix), so only elements that are optimal in at least one direction can survive to be the final result.

