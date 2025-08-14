
# Problem: Largest 3-Same-Digit Number in String

## Problem Description
You are given a string `num` representing a large integer. An integer is **good** if it meets the following conditions:
- It is a **substring** of `num` with **length 3**
- It consists of **only one unique digit**

Return the **maximum good integer** as a string or an **empty string** `""` if no such integer exists.

## Input Format

`num`: A string representing a large integer

## Output Format

Return the maximum good integer as a string, or an empty string `""` if no good integer exists

## Examples

### Example 1:
**Input:** `num = "6777133339"`<br/>
**Output:** `"777"`<br/>
**Explanation:** There are two distinct good integers: `"777"` and `"333"`. `"777"` is the largest, so we return `"777"`.

### Example 2:
**Input:** `num = "2300019"`<br/>
**Output:** `"000"`<br/>
**Explanation:** `"000"` is the only good integer.

### Example 3:
**Input:** `num = "42352338"`<br/>
**Output:** `""`<br/>
**Explanation:** No substring of length 3 consists of only one unique digit. Therefore, there are no good integers.

## Constraints
- **3 <= num.length <= 1000**
- `num` **only consists of digits**

## Notes
- A **substring** is a contiguous sequence of characters within a string
- There may be **leading zeroes** in `num` or a good integer

