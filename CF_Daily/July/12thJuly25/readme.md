
# D. Binary String Battle

## Problem Description
Alice and Bob are given a **binary string** `s` of length `n`, and an integer `k` (`1 ≤ k < n`). The game proceeds in turns, with **Alice going first**. The objective is:

- **Alice wins** if she is able to transform all characters of `s` into zeroes. If Alice is unable to win in a finite number of moves, then **Bob wins**.

The rules for each turn are:
- On **Alice's turn**, she may choose **any subsequence** of length `k` in `s`, then set all characters in that subsequence to zero.
- On **Bob's turn**, he may choose **any substring** of length `k` in `s`, then set all characters in that substring to one.

A **subsequence** is a set of characters in `s` (not necessarily adjacent). A **substring** is a contiguous group of characters in `s` (must be adjacent).

**Alice wins** if the string consists of all zeroes at any point during the game, including in between Alice's and Bob's turns.

Determine who wins with **optimal play**.

## Input Format
- The first line contains an integer `t` — the number of test cases (`1 ≤ t ≤ 10^4`).
- For each test case:
  - The first line contains two integers `n` and `k` (`2 ≤ n ≤ 2⋅10^5`, `1 ≤ k < n`).
  - The second line contains a binary string `s` of length `n`.
- It is guaranteed that the sum of `n` over all test cases does not exceed `2⋅10^5`.

## Output Format
- For each test case, output a single line: `Alice` if Alice wins with optimal play, or `Bob` if Bob wins with optimal play.
- You may output the answer in any case (e.g., `alice`, `ALICE`, `Alice` are all accepted).

## Examples

**Input:**  
`6`  <br/>
`5 2`  <br/>
`11011`  <br/>
`7 4`  <br/>
`1011011`  <br/>
`6 1`  <br/>
`010000`  <br/>
`4 1`  <br/>
`1111`  <br/>
`8 3`  <br/>
`10110110`  <br/>
`6 4`  <br/>
`111111`  <br/>

**Output:**  <br/>
`Bob`  <br/>
`Alice`  <br/>
`Alice`  <br/>
`Bob`  <br/>
`Bob`  <br/>
`Alice`  <br/>

## Constraints
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 2⋅10^5`
- `1 ≤ k < n`
- The sum of `n` over all test cases does not exceed `2⋅10^5`.

## Notes
- Alice can win immediately if she can turn all characters to zero in her first move.
- Bob can prevent Alice from winning if he can always revert Alice's progress using his substring operation.
- The answer depends on the initial configuration of `s`, the value of `k`, and the optimal strategies of both players.

