# A. Soldier and Bananas

## Problem Statement

A soldier wants to buy `w` bananas in the shop. He has to pay `k` dollars for the first banana, `2k` dollars for the second one, and so on (i.e., he has to pay `i·k` dollars for the i-th banana).

He has `n` dollars. How many dollars does he have to borrow from his friend to buy `w` bananas?

## Input Format

- The first line contains three positive integers `k`, `n`, `w` (1 ≤ k, w ≤ 1000, 0 ≤ n ≤ 10^9):
  - `k`: the cost of the first banana,
  - `n`: the initial number of dollars the soldier has,
  - `w`: the number of bananas he wants.

## Output Format

- Output one integer — the amount of dollars that the soldier must borrow from his friend. If he doesn't have to borrow money, output 0.

## Example

### Input
3 17 4

### Output
13

## Explanation

- The total cost is: 3 + 6 + 9 + 12 = 30.
- The soldier has 17 dollars, so he needs to borrow 30 - 17 = 13 dollars.
