
# Problem: Almost All Divisors

## Problem Description
We guessed some integer number `x`. You are given a list of **almost all its divisors**. Almost all means that there are **all divisors except 1 and x** in the list.

Your task is to find the **minimum possible integer x** that can be the guessed number, or say that the input data is contradictory and it is impossible to find such number.

You have to answer `t` independent queries.

## Input Format
- The first line contains one integer `t` **(1 ≤ t ≤ 25)** — the number of queries
- For each query:
  - First line contains one integer `n` **(1 ≤ n ≤ 300)** — the number of divisors in the list
  - Second line contains `n` integers `d1, d2, ..., dn` **(2 ≤ di ≤ 10^6)** — the divisors of the guessed number
  - All values `di` are **distinct**

## Output Format
For each query:
- If the input data is **contradictory** and it's impossible to find such number `x`, print **-1**
- Otherwise, print the **minimum possible x**

## Examples

### Input

`2`<br/>
`8`<br/>
`8 2 12 6 4 24 16 3`<br/>
`1`<br/>
`2`<br/>

### Output

`48`<br/>
`4`<br/>

## Constraints
- **1 ≤ t ≤ 25**
- **1 ≤ n ≤ 300**
- **2 ≤ di ≤ 10^6**
- All divisor values are **distinct**

## Notes
- The list contains **all divisors except 1 and x itself**
- We need to find the **minimum possible value** of `x`
- If no valid `x` exists, return **-1**
- For the first example: divisors `[8, 2, 12, 6, 4, 24, 16, 3]` correspond to `x = 48`
- For the second example: divisor `[2]` corresponds to `x = 4`

