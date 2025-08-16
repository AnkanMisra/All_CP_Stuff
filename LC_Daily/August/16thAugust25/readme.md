
# Problem: Maximum 69 Number

## Problem Description
You are given a **positive integer** `num` consisting only of digits `6` and `9`. Return the **maximum number** you can get by changing **at most one digit** (`6` becomes `9`, and `9` becomes `6`).

## Input Format
- A positive integer `num` consisting only of digits `6` and `9`

## Output Format
- Return the maximum number after changing at most one digit

## Examples

### Example 1
**Input:** `num = 9669`<br/>
**Output:** `9969`<br/>

**Explanation:**
- Changing the first digit results in `6669`
- Changing the second digit results in `9969`
- Changing the third digit results in `9699`
- Changing the fourth digit results in `9666`
- The **maximum number is 9969**

### Example 2
**Input:** `num = 9996`<br/>
**Output:** `9999`<br/>

**Explanation:** Changing the last digit `6` to `9` results in the maximum number.

### Example 3
**Input:** `num = 9999`<br/>
**Output:** `9999`<br/>

**Explanation:** It is better not to apply any change.

## Constraints
- `1 <= num <= 10^4`
- `num` consists of only `6` and `9` digits

