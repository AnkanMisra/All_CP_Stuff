
# Solution Explanation

## Intuition
To find the **minimum time difference**, we need to compare all pairs of time points. However, since time is **circular** (after 23:59 comes 00:00), we must consider both the direct difference and the wraparound difference. Converting times to minutes makes calculations easier.

## Approach
The key insight is to **convert all time strings to minutes** from 00:00, then **sort them** to efficiently find minimum differences. After sorting, we only need to check consecutive pairs and the circular difference between the last and first elements.

## Algorithm
1. **Convert each time string to minutes**: Parse `"HH:MM"` format and convert to total minutes from midnight (`hour * 60 + minute`)
2. **Sort the minutes array**: This allows us to check only consecutive elements for minimum differences
3. **Find minimum consecutive difference**: Iterate through sorted array and find minimum difference between adjacent elements
4. **Check circular difference**: Calculate the wraparound difference between the last and first elements (`1440 - last + first`)
5. **Return the overall minimum**: Compare all differences and return the smallest

## Complexity
- **Time Complexity:** `O(n log n)` where `n` is the number of time points, due to sorting
- **Space Complexity:** `O(n)` for storing the converted minutes

## Summary
This approach works because **sorting eliminates the need to check all pairs** - we only need to check consecutive elements and the circular case. The key insight is recognizing that time is circular, so we must consider the wraparound difference. **Corner cases** include duplicate times (difference = 0) and times that span midnight.

