
# Solution Explanation

## Intuition
The key insight is that we need to **count how many intervals each integer appears in** and find the **maximum integer** that appears in at least `k` intervals. We use **coordinate compression** with a `TreeMap` and **difference array technique** to efficiently track coverage counts only at critical points (interval boundaries).

## Approach
1. **Use TreeMap for coordinate compression**: Store only the **critical points** (interval start and end+1 positions) to avoid creating a large array.

2. **Mark interval boundaries**: For each interval `[start, end]`, increment the count at `start` and decrement at `end + 1` in the TreeMap.

3. **Process in sorted order**: Iterate through the TreeMap entries in ascending order of coordinates to simulate a **sweep line** approach.

4. **Calculate running coverage**: Maintain a running sum to track how many intervals are currently active at each critical point.

5. **Track maximum powerful integer**: For each coordinate, check if the current coverage is ≥ `k`. Also check if the previous coverage (before applying current change) was ≥ `k` to handle the case where coverage drops.

6. **Handle edge cases**: If no coordinate has coverage ≥ `k`, return **-1**.

## Algorithm
1. Create a `TreeMap` to store coordinate changes
2. For each interval `[start, end]`, increment `map[start]` and decrement `map[end + 1]`
3. Initialize running sum `sum = 0` and answer `ans = -1`
4. Iterate through TreeMap entries in sorted order:
   - Add current value to running sum
   - If current sum ≥ `k`, update answer with current coordinate
   - If previous sum (before current change) was ≥ `k`, update answer with `coordinate - 1`
5. Return the maximum coordinate found, or `-1` if none exists

## Complexity
- **Time Complexity:** `O(n log n)` - Due to TreeMap operations and processing intervals
- **Space Complexity:** `O(n)` - For storing at most `2n` coordinates in the TreeMap

## Summary
This approach uses **coordinate compression** with TreeMap to handle large coordinate ranges efficiently. The difference array technique tracks interval coverage changes only at critical points. The key insight is checking both current coverage and previous coverage at each coordinate to ensure we don't miss any valid powerful integers. This method works well even when endpoint values are very large (up to `10^9`) since we only process the relevant coordinates.

