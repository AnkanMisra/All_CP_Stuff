
# Problem: ASCII Range Sum

## Problem Description
Given a string `s` consisting of lowercase English letters, for every character whose **first and last occurrences are at different positions**, calculate the **sum of ASCII values** of characters **strictly between its first and last occurrence**.

Return all such **non-zero sums** (order does not matter).

## Input Format
A string `s` consisting of lowercase English letters.

## Output Format
Return all non-zero ASCII sums for characters that appear more than once.

## Examples

### Example 1
**Input:** `s = "abacab"`<br/>

**Output:** `[293, 294]`<br/>

**Explanation:** Characters `'a'` and `'b'` appear more than once:
- `'a'`: between positions 1 and 5 → characters are `b, a, c` and ASCII sum is `98 + 97 + 99 = 294`
- `'b'`: between positions 2 and 6 → characters are `a, c, a` and ASCII sum is `97 + 99 + 97 = 293`

### Example 2
**Input:** `s = "acdac"`<br/>

**Output:** `[197, 199]`<br/>

**Explanation:** Characters `'a'` and `'c'` appear more than once:
- `'a'`: between positions 1 and 4 → characters are `c, d` and ASCII sum is `99 + 100 = 199`
- `'c'`: between positions 2 and 5 → characters are `d, a` and ASCII sum is `100 + 97 = 197`

## Constraints
- `1 ≤ s.size() ≤ 10^5`

