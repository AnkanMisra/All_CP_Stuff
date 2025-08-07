
# Solution Explanation

## Intuition
To find the **minimum time difference**, we need to consider all possible pairs of times. However, since we're dealing with a **circular clock** (24-hour format that wraps around), we must account for both **direct differences** and **wrap-around differences** across midnight.

## Approach
1. **Convert all time strings to seconds** from 00:00:00 for easier comparison
2. **Sort the array** to efficiently find minimum differences between adjacent times
3. **Calculate differences between consecutive times** in the sorted array
4. **Handle wrap-around case** by calculating the difference between the last and first time (considering the clock wraps at midnight)
5. **Return the minimum** of all calculated differences

## Algorithm
1. Create a helper function `hourToSecond()` to convert "HH:MM:SS" format to total seconds using `substring()` and `parseInt()`
2. Convert all time strings to seconds and store in an `array`
3. Sort the `seconds` array to arrange times in chronological order
4. Iterate through consecutive pairs and calculate their differences in seconds
5. Calculate the wrap-around difference: `24 * 3600 - seconds[n-1] + seconds[0]`
6. Track and return the minimum difference found

## Complexity
- **Time Complexity:** `O(n log n)` due to sorting the array of converted seconds
- **Space Complexity:** `O(n)` for storing the converted seconds array

## Summary
The approach works by **converting times to a comparable format** (seconds) and **sorting to minimize comparisons**. The key insight is handling the **circular nature of time** by considering wrap-around differences. **Corner cases** include times very close to midnight and the wrap-around calculation between the last and first elements after sorting.

