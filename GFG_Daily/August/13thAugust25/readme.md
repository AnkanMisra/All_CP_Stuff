
# Problem: Tywin's War Strategy

## Problem Description
You are given an array `arr[]` of size `n`, where `arr[i]` represents the **number of soldiers** in the i-th troop. You are also given an integer `k`. A troop is considered **"lucky"** if its number of soldiers is a **multiple of k**. Find the **minimum total number of soldiers** to add across all troops so that **at least ⌈n / 2⌉ troops become lucky**.

## Input Format
- An array `arr[]` of size `n` representing the number of soldiers in each troop
- An integer `k` representing the divisor for lucky troops

## Output Format
Return the **minimum total number of soldiers** to add across all troops

## Examples

### Input

`arr = [5, 6, 3, 2, 1], k = 2`<br/>

### Output

`1`<br/>

**Explanation:** By adding `1` soldier for the troop with `1` soldier, we get `[5, 6, 3, 2, 2]`. Now **3 out of 5 troops** (`6`, `2`, and `2`) are multiples of `2` that satisfy the requirement.

### Input

`arr = [3, 5, 6, 7, 9, 10], k = 4`<br/>

### Output

`4`<br/>

**Explanation:** We need **at least 3 lucky troops** since `⌈6 / 2⌉ = 3`. Currently, no troop is divisible by `4`.
- Add `1` soldier for troop `3` → `4`
- Add `2` for troop `6` → `8`
- Add `1` for troop `7` → `8`

New array: `[4, 5, 8, 8, 9, 10]` with **3 lucky troops** (`4`, `8`, `8`).
Total soldiers added = `4`.

## Constraints
- `1 ≤ arr.size() ≤ 10^5`
- `1 ≤ k ≤ 10^5`
- `1 ≤ arr[i] ≤ 10^5`

