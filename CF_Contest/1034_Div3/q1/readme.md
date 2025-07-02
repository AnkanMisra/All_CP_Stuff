# Problem: D. Binary String Battle

## Problem Description
Alice and Bob are given a **binary string** `s` of length `n`, and an integer `k` (1 ≤ k < n).

**Alice wins** if she is able to **transform all characters** of `s` into zeroes. If Alice is unable to win in a finite number of moves, then **Bob wins**.

Alice and Bob take turns, with **Alice going first**.

- **On Alice's turn**, she may choose any **subsequence** of length `k` in `s`, then **set all characters in that subsequence to zero**.
- **On Bob's turn**, he may choose any **substring** of length `k` in `s`, then **set all characters in that substring to one**.

**Note:** Alice wins if the string consists of **all zeros at any point** during the game, including in between Alice's and Bob's turns.

**Objective:** Determine who wins with optimal play.

**Important Definitions:**
- A **subsequence** of a string `s` is a set of characters in `s`. Note that these characters **do not have to be adjacent**.
- A **substring** of a string `s` is a contiguous group of characters in `s`. Note that these characters **must be adjacent**.

## Input Format
- The first line contains an integer `t` (1 ≤ t ≤ 10^4) — the **number of test cases**.
- The first line of each test case contains two integers `n` and `k` (2 ≤ n ≤ 2×10^5, 1 ≤ k < n).
- The second line of each test case contains a **binary string** `s` of length `n`.

## Output Format
For each test case, output on a single line **"Alice"** if Alice wins with optimal play, and **"Bob"** if Bob wins with optimal play.

You can output the answer in any case (upper or lower). For example, the strings "aLiCe", "alice", "ALICE", and "alICE" will be recognized as "Alice".

## Examples

### Input
`6`<br/>
`5 2`<br/>
`11011`<br/>
`7 4`<br/>
`1011011`<br/>
`6 1`<br/>
`010000`<br/>
`4 1`<br/>
`1111`<br/>
`8 3`<br/>
`10110110`<br/>
`6 4`<br/>
`111111`<br/>

### Output
`Bob`<br/>
`Alice`<br/>
`Alice`<br/>
`Bob`<br/>
`Bob`<br/>
`Alice`<br/>

## Constraints
- **Time limit:** 2 seconds
- **Memory limit:** 256 megabytes
- `1 ≤ t ≤ 10^4`
- `2 ≤ n ≤ 2×10^5`
- `1 ≤ k < n`
- The sum of `n` over all test cases does not exceed `2×10^5`

## Notes
- In the **third sample**, Alice can choose the subsequence consisting of `s[2]`, turning `s` into `000000`. Then she **wins immediately**.
- In the **fourth sample**, it can be shown that there is **no way for Alice** to guarantee that she can turn `s` into `0000` within a finite number of moves.

