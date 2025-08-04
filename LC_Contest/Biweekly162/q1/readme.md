
# Problem: Earliest Finish Time for Land and Water Rides I

## Problem Description
You are given two categories of theme park attractions: **land rides** and **water rides**.

**Land rides:**
- `landStartTime[i]` – the earliest time the `i`th land ride can be boarded
- `landDuration[i]` – how long the `i`th land ride lasts

**Water rides:**
- `waterStartTime[j]` – the earliest time the `j`th water ride can be boarded
- `waterDuration[j]` – how long the `j`th water ride lasts

A tourist must experience **exactly one ride from each category**, in either order. A ride may be started at its opening time or any later moment. If a ride is started at time `t`, it finishes at time `t + duration`. **Immediately after finishing one ride** the tourist may board the other (if it is already open) or wait until it opens.

Return the **earliest possible time** at which the tourist can finish both rides.

## Input Format
- `landStartTime[]` - array of integers representing start times for land rides
- `landDuration[]` - array of integers representing durations for land rides  
- `waterStartTime[]` - array of integers representing start times for water rides
- `waterDuration[]` - array of integers representing durations for water rides

## Output Format
Return an integer representing the **earliest possible finish time** for both rides.

## Examples

### Example 1
**Input:**
`landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]`<br/>

**Output:**
`9`<br/>

**Explanation:**
Plan A (land ride 0 → water ride 0):
- Start land ride 0 at time `2`. Finish at `2 + 4 = 6`.
- Water ride 0 opens at time `6`. Start immediately at `6`, finish at `6 + 3 = 9`.

Plan B (water ride 0 → land ride 1):
- Start water ride 0 at time `6`. Finish at `6 + 3 = 9`.
- Land ride 1 opens at `8`. Start at time `9`, finish at `9 + 1 = 10`.

Plan A gives the earliest finish time of `9`.

### Example 2
**Input:**
`landStartTime = [5], landDuration = [3], waterStartTime = [1], waterDuration = [10]`<br/>

**Output:**
`14`<br/>

**Explanation:**
Plan A (water ride 0 → land ride 0):
- Start water ride 0 at time `1`. Finish at `1 + 10 = 11`.
- Land ride 0 opened at `5`. Start immediately at `11` and finish at `11 + 3 = 14`.

Plan B (land ride 0 → water ride 0):
- Start land ride 0 at time `5`. Finish at `5 + 3 = 8`.
- Water ride 0 opened at `1`. Start immediately at `8` and finish at `8 + 10 = 18`.

Plan A provides the earliest finish time of `14`.

## Constraints
- `1 <= landStartTime.length, waterStartTime.length <= 1000`
- `1 <= landStartTime[i], landDuration[i], waterStartTime[i], waterDuration[i] <= 1000`

## Notes
- The tourist must take **exactly one ride from each category**
- Rides can be taken in **any order** (land first or water first)
- A ride can be started at its opening time or **any later moment**
- After finishing one ride, the tourist can **immediately board** the other if it's open, or wait until it opens

