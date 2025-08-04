
# Problem: Earliest Finish Time for Land and Water Rides II

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
- `landStartTime`: array of integers representing the start times of land rides
- `landDuration`: array of integers representing the durations of land rides
- `waterStartTime`: array of integers representing the start times of water rides
- `waterDuration`: array of integers representing the durations of water rides

## Output Format
Return an integer representing the **earliest possible time** at which the tourist can finish both rides.

## Examples

### Example 1
**Input:**

`landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6], waterDuration = [3]`<br/>

**Output:**

`9`<br/>

**Explanation:**
- **Plan A** (land ride 0 → water ride 0): Start land ride 0 at time `2`, finish at `6`. Start water ride 0 at `6`, finish at `9`.
- **Plan B** (water ride 0 → land ride 1): Start water ride 0 at time `6`, finish at `9`. Start land ride 1 at `9`, finish at `10`.
- **Plan C** (land ride 1 → water ride 0): Start land ride 1 at time `8`, finish at `9`. Start water ride 0 at `9`, finish at `12`.
- **Plan D** (water ride 0 → land ride 0): Start water ride 0 at time `6`, finish at `9`. Start land ride 0 at `9`, finish at `13`.

Plan A gives the **earliest finish time of 9**.

### Example 2
**Input:**

`landStartTime = [5], landDuration = [3], waterStartTime = [1], waterDuration = [10]`<br/>

**Output:**

`14`<br/>

**Explanation:**
- **Plan A** (water ride 0 → land ride 0): Start water ride 0 at time `1`, finish at `11`. Start land ride 0 at `11`, finish at `14`.
- **Plan B** (land ride 0 → water ride 0): Start land ride 0 at time `5`, finish at `8`. Start water ride 0 at `8`, finish at `18`.

Plan A provides the **earliest finish time of 14**.

## Constraints
- **1 <= n, m <= 5 * 10^4**
- `landStartTime.length == landDuration.length == n`
- `waterStartTime.length == waterDuration.length == m`
- **1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <= 10^5**

## Notes
- The tourist can choose any land ride and any water ride
- The rides can be taken in any order (land first or water first)
- After finishing one ride, the tourist can immediately start the next ride if it's already open, or wait until it opens

