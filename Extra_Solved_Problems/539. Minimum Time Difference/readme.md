
# Problem: 539. Minimum Time Difference

## Problem Description
Given a list of **24-hour clock time points** in `"HH:MM"` format, return the **minimum minutes difference** between any two time-points in the list.

## Input Format
- `timePoints`: A list of strings representing time points in `"HH:MM"` format

## Output Format
- An integer representing the **minimum minutes difference** between any two time points

## Examples

### Input

`timePoints = ["23:59","00:00"]`<br/>

### Output

`1`

### Input

`timePoints = ["00:00","23:59","00:00"]`<br/>

### Output

`0`

## Constraints
- **2 <= timePoints.length <= 2 * 10^4**
- **timePoints[i] is in the format "HH:MM"**

## Notes
- Time points are in 24-hour format
- Consider that time wraps around (e.g., difference between `23:59` and `00:00` is 1 minute)
- If there are duplicate time points, the minimum difference is `0`

