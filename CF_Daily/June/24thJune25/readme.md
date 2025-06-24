# Problem: A. Cheap Travel

## Problem Description

Ann has recently started commuting by subway. A one-ride subway ticket costs `a` rubles. She can also buy a special ticket for `m` rides (and can buy it several times), which costs `b` rubles. Ann needs to use the subway `n` times. Help Ann determine the **minimum sum of money** she will have to spend to make `n` rides.

## Input Format

- A single line contains four space-separated integers:
  - `n` — the number of rides Ann has planned (1 ≤ n ≤ 1000)
  - `m` — the number of rides covered by the m-ride ticket (1 ≤ m ≤ 1000)
  - `a` — the price of a one-ride ticket (1 ≤ a ≤ 1000)
  - `b` — the price of an m-ride ticket (1 ≤ b ≤ 1000)

## Output Format

- Print a single integer — the minimum sum in rubles that Ann will need to spend.

## Examples

### Example 1

**Input:**  
6 2 1 2

**Output:**  
6

**Explanation:**  
One optimal solution is to buy six one-ride tickets (6 × 1 = 6).  
Another optimal solution is to buy three m-ride tickets (3 × 2 = 6).

### Example 2

**Input:**  
5 2 2 3

**Output:**  
8

**Explanation:**  
Buy two m-ride tickets (2 × 3 = 6) for 4 rides, and one one-ride ticket (2) for the last ride. Total = 6 + 2 = 8.

## Notes

- Ann can buy any combination of one-ride and m-ride tickets to minimize her total cost.
- She can buy more rides than she needs if it is cheaper.
