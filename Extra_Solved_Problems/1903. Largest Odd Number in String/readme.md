
# Problem: 1903. Largest Odd Number in String

## Problem Description
You are given a string `num`, representing a large integer. Return the **largest-valued odd** integer (as a string) that is a **non-empty substring** of `num`, or an empty string `""` if no odd integer exists.

A substring is a contiguous sequence of characters within a string.

## Input Format
A string `num` representing a large integer.

## Output Format
Return the largest-valued odd integer (as a string) that is a non-empty substring of `num`, or an empty string `""` if no odd integer exists.

## Examples

### Example 1:
**Input:** `num = "52"`<br/>

**Output:** `"5"`<br/>

**Explanation:** The only non-empty substrings are `"5"`, `"2"`, and `"52"`. `"5"` is the only odd number.

### Example 2:
**Input:** `num = "4206"`<br/>

**Output:** `""`<br/>

**Explanation:** There are no odd numbers in `"4206"`.

### Example 3:
**Input:** `num = "35427"`<br/>

**Output:** `"35427"`<br/>

**Explanation:** `"35427"` is already an odd number.

## Constraints
- **1 <= num.length <= 10^5**
- `num` only consists of digits and does not contain any leading zeros.

