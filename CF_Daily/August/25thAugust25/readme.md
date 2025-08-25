

# Problem: No Casino in the Mountains

## Problem Description
You are given an array `a` of length `n` where each element represents the weather on that day:
* `a_i = 1` — it **rains** on day `i`
* `a_i = 0` — the weather is **good** on day `i`

Jean wants to climb as many mountain peaks as possible. A single hike lasts exactly `k` consecutive days, and **every** of those `k` days must have good weather (`a_j = 0`). After finishing a hike Jean must rest for **at least one full day** before starting the next hike.

Your task is to determine the **maximum number of hikes** Jean can complete.

## Input Format
* The first line contains an integer **`t`** — number of test cases (`1 ≤ t ≤ 10 000`).
* For each test case:
  * The first line contains two integers **`n`** and **`k`** (`1 ≤ n ≤ 10^5`, `1 ≤ k ≤ n`).
  * The second line contains `n` integers **`a_i`** (`a_i ∈ {0, 1}`) — the weather array.
* The sum of `n` over all test cases does not exceed `10^5`.

## Output Format
For each test case output a single integer — the **maximum number of hikes** Jean can make.

## Examples

### Example&nbsp;1
**Input:**<br/>
`5`<br/>
`5 1`<br/>
`0 1 0 0 0`<br/>
`7 3`<br/>
`0 0 0 0 0 0 0`<br/>
`3 1`<br/>
`1 1 1`<br/>
`4 2`<br/>
`0 1 0 1`<br/>
`6 2`<br/>
`0 0 1 0 0 0`<br/>

**Output:**<br/>
`3 2 0 0 2`

### Example&nbsp;2
**Input:**<br/>
`2`<br/>
`6 2`<br/>
`0 0 0 0 0 0`<br/>
`8 3`<br/>
`0 1 0 0 0 0 1 0`<br/>

**Output:**<br/>
`2 1`

## Constraints
* `1 ≤ t ≤ 10 000`
* `1 ≤ n ≤ 10^5`
* `1 ≤ k ≤ n`
* `a_i ∈ {0, 1}`
* Total `n` across all test cases ≤ `10^5`

## Notes
*For a hike starting on day `i`, all days from `i` to `i + k − 1` must be good (`a_j = 0`).* After completing the `k`-day hike, Jean must rest on day `i + k` before potentially starting another hike.


