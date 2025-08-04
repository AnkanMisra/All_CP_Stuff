
# Problem: Trionic Array I

## Problem Description
You are given an integer array `nums` of length `n`. An array is **trionic** if there exist indices `0 < p < q < n − 1` such that:
- `nums[0...p]` is **strictly increasing**
- `nums[p...q]` is **strictly decreasing**
- `nums[q...n − 1]` is **strictly increasing**

Return `true` if `nums` is trionic, otherwise return `false`.

## Input Format
- An integer array `nums` of length `n`

## Output Format
- A boolean value: `true` if the array is trionic, `false` otherwise

## Examples

### Example 1
**Input:** `nums = [1,3,5,4,2,6]`<br/>

**Output:** `true`<br/>

**Explanation:**
Pick `p = 2`, `q = 4`:
- `nums[0...2] = [1, 3, 5]` is strictly increasing (`1 < 3 < 5`)
- `nums[2...4] = [5, 4, 2]` is strictly decreasing (`5 > 4 > 2`)
- `nums[4...5] = [2, 6]` is strictly increasing (`2 < 6`)

### Example 2
**Input:** `nums = [2,1,3]`<br/>

**Output:** `false`<br/>

**Explanation:**
There is no way to pick `p` and `q` to form the required three segments.

## Constraints
- **3 <= n <= 100**
- **-1000 <= nums[i] <= 1000**

