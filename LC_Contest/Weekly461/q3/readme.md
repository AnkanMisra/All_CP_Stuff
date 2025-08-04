
# Problem: Minimum Time to Activate String

## Problem Description
You are given a string `s` of length `n` and an integer array `order`, where `order` is a **permutation** of the numbers in the range `[0, n - 1]`.

Starting from time `t = 0`, replace the character at index `order[t]` in `s` with `'*'` at each time step.

A **substring** is valid if it contains **at least one** `'*'`.

A string is **active** if the total number of valid substrings is **greater than or equal to** `k`.

Return the **minimum** time `t` at which the string `s` becomes active. If it is impossible, return `-1`.

## Input Format
- A string `s` of length `n`
- An integer array `order` (permutation of `[0, n-1]`)
- An integer `k` (target number of valid substrings)

## Output Format
Return the minimum time `t` when the string becomes active, or `-1` if impossible.

## Examples

### Example 1
**Input:** `s = "abc", order = [1,0,2], k = 2`<br/>

**Output:** `0`<br/>

**Explanation:**
- At `t = 0`: Replace index `1`, string becomes `"a*c"`
- Valid substrings: `"*"`, `"a*"`, `"*c"`, `"a*c"` (count = 4)
- Since `4 >= 2`, the string becomes active at `t = 0`

### Example 2
**Input:** `s = "cat", order = [0,2,1], k = 6`<br/>

**Output:** `2`<br/>

**Explanation:**
- At `t = 0`: `"*at"` → 3 valid substrings (not active)
- At `t = 1`: `"*a*"` → 5 valid substrings (not active)
- At `t = 2`: `"***"` → 6 valid substrings (active)

### Example 3
**Input:** `s = "xy", order = [0,1], k = 4`<br/>

**Output:** `-1`<br/>

**Explanation:**
Even after all replacements, it's impossible to obtain `k = 4` valid substrings.

## Constraints
- `1 <= n == s.length <= 10^5`
- `order.length == n`
- `0 <= order[i] <= n - 1`
- `s` consists of **lowercase English letters**
- `order` is a **permutation** of integers from `0` to `n - 1`
- `1 <= k <= 10^9`

