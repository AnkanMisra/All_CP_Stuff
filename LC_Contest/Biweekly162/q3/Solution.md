
# Solution Explanation

## Intuition
Since the tourist must take **exactly one ride from each category** and can choose the order, we need to consider all possible combinations. For each land ride and water ride pair, we can either:
1. Take the land ride first, then the water ride
2. Take the water ride first, then the land ride

The key insight is that we need to **minimize the total finish time** by choosing the optimal ride combination and order.

## Approach
For each possible combination of one land ride and one water ride, calculate the finish time for both possible orders:

1. **Land ride first, then water ride:**
   - Start land ride at `landStartTime[i]`
   - Finish land ride at `landStartTime[i] + landDuration[i]`
   - Start water ride at `max(waterStartTime[j], landStartTime[i] + landDuration[i])`
   - Total finish time = `max(waterStartTime[j], landStartTime[i] + landDuration[i]) + waterDuration[j]`

2. **Water ride first, then land ride:**
   - Start water ride at `waterStartTime[j]`
   - Finish water ride at `waterStartTime[j] + waterDuration[j]`
   - Start land ride at `max(landStartTime[i], waterStartTime[j] + waterDuration[j])`
   - Total finish time = `max(landStartTime[i], waterStartTime[j] + waterDuration[j]) + landDuration[i]`

For each combination, take the **minimum of these two finish times**. Then find the **global minimum** across all combinations.

## Algorithm
1. Initialize `minFinishTime` to a large value
2. For each land ride `i` from `0` to `n-1`:
   - For each water ride `j` from `0` to `m-1`:
     - Calculate finish time for land ride first: `landFirst = max(waterStartTime[j], landStartTime[i] + landDuration[i]) + waterDuration[j]`
     - Calculate finish time for water ride first: `waterFirst = max(landStartTime[i], waterStartTime[j] + waterDuration[j]) + landDuration[i]`
     - Update `minFinishTime = min(minFinishTime, min(landFirst, waterFirst))`
3. Return `minFinishTime`

## Complexity
- **Time Complexity:** `O(n * m)` where `n` is the number of land rides and `m` is the number of water rides
- **Space Complexity:** `O(1)` as we only use constant extra space

## Summary
This approach works by **exhaustively checking all possible combinations** of land and water rides in both possible orders. The key insight is that for any given pair of rides, we only need to consider two scenarios: land first or water first. We calculate the finish time for both scenarios and take the minimum. The global minimum across all combinations gives us the optimal solution. This brute force approach is efficient given the constraints (`n, m <= 5 * 10^4`).

