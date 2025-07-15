
# Problem: Number Game

## Problem Description
Ashishgup and FastestFinger play a game starting with a number `n`. They take turns, with **Ashishgup moving first**. On each turn, a player can make **one of the following moves**:
- **Divide `n` by any of its odd divisors greater than 1** (divisors include `n` itself).
- **Subtract 1 from `n`** (only if `n > 1`).

The player who cannot make a move **loses the game**. Both players play **optimally**.

Determine the winner for a given `n`.

## Input Format
- The first line contains a single integer `t` — **the number of test cases**.
- Each of the next `t` lines contains a single integer `n` — **the starting number for the game**.

## Output Format
- For each test case, print `Ashishgup` if he wins, or `FastestFinger` otherwise.

## Examples

### Input

7
1
2
3
4
5
6
12
<br/>

### Output

FastestFinger
Ashishgup
Ashishgup
FastestFinger
Ashishgup
FastestFinger
Ashishgup
<br/>

## Constraints
- `1 ≤ t ≤ 100`
- `1 ≤ n ≤ 10^9`

## Notes
- In the first test case, `n = 1`, Ashishgup cannot make a move and loses.
- In the second test case, `n = 2`, Ashishgup subtracts 1, making `n = 1`, and FastestFinger cannot move.
- In the third test case, `n = 3`, Ashishgup divides by 3, making `n = 1`, and FastestFinger cannot move.
- In the last test case, `n = 12`, Ashishgup divides by 3, making `n = 4`, and can force a win as described in the problem statement.

