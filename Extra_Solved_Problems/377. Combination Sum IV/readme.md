
# Problem: 377. Combination Sum IV

## Problem Description
Given an array of **distinct integers** `nums` and a **target integer** `target`, return the **number of possible combinations** that add up to `target`.

The test cases are generated so that the answer can fit in a **32-bit integer**.

**Note:** Different sequences are counted as different combinations.

## Input Format
- `nums`: An array of distinct integers
- `target`: A target integer

## Output Format
Return the number of possible combinations that add up to `target`.

## Examples

### Example 1
**Input:**

`nums = [1,2,3], target = 4`<br/>

**Output:**

`7`<br/>

**Explanation:**
The possible combination ways are:
- `(1, 1, 1, 1)`
- `(1, 1, 2)`
- `(1, 2, 1)`
- `(1, 3)`
- `(2, 1, 1)`
- `(2, 2)`
- `(3, 1)`

### Example 2
**Input:**

`nums = [9], target = 3`<br/>

**Output:**

`0`<br/>

## Constraints
- **1 <= nums.length <= 200**
- **1 <= nums[i] <= 1000**
- **All elements of nums are unique**
- **1 <= target <= 1000**

