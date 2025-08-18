# Problem: A. Orac and LCM

## Problem Description
Given a multiset of positive integers `s = {s₁, s₂, …, sₖ}`, define:
- **gcd(s)** — the greatest positive integer `x` that divides every element of `s`.
- **lcm(s)** — the smallest positive integer `x` that is divisible by every element of `s`.

Examples: `gcd({8, 12}) = 4`, `gcd({12, 18, 6}) = 6`, `lcm({4, 6}) = 12`.
For any positive integer `x`, `gcd({x}) = lcm({x}) = x`.

You are given a sequence `a` of length `n`. Construct the multiset
`t = { lcm(aᵢ, aⱼ) | i < j }` containing the LCM of every unordered pair in `a`.
Your task is to compute **gcd(t)**.

## Input Format
- The first line contains a single integer `n` (**2 ≤ n ≤ 100000**).
- The second line contains `n` integers `a₁, a₂, …, aₙ` (**1 ≤ aᵢ ≤ 200000**).

## Output Format
Print a single integer — **gcd(t)**.

## Examples

### Input<br/>
2<br/>
1 1

### Output<br/>
1

### Input<br/>
4<br/>
10 24 40 80

### Output<br/>
40

### Input<br/>
10<br/>
540 648 810 648 720 540 594 864 972 648

### Output<br/>
54

## Notes
- **Example 1:** `t = { lcm(1,1) } = {1 }`, hence the answer is `1`.
- **Example 2:** `t = {120, 40, 80, 120, 240, 80}`, and `gcd(t) = 40`.