# Problem: B. Tournament

## Problem Description
You are given an array of integers `a1, a2, ..., an`. A tournament is held with **n players** where player i has **strength ai**.

While **more than k players remain**:
- **Two remaining players are chosen at random**
- The chosen player with the **lower strength is eliminated**
- If the chosen players have the **same strength**, one is **eliminated at random**

Given integers **j and k**, determine if there is **any way for player j to be one of the last k remaining players**.

## Input Format
- The first line contains an integer **t** - the number of test cases
- For each test case:
  - The first line contains three integers **n, j, and k** where:
    - **n** is the number of players
    - **j** is the player we're checking
    - **k** is the number of final remaining players
  - The second line contains **n integers** `a1, a2, ..., an` representing player strengths

## Output Format
For each test case, output **"YES"** if player j can be one of the last k remaining players, and **"NO"** otherwise.

You can output the answer in any case (upper or lower). For example, the strings `"yEs"`, `"yes"`, `"Yes"`, and `"YES"` will be recognized as positive responses.

## Examples

### Input
`3`<br/>
`5 2 3`<br/>
`3 2 4 4 1`<br/>
`5 4 1`<br/>
`5 3 4 5 2`<br/>
`6 1 1`<br/>
`1 2 3 4 5 6`<br/>

### Output
`YES`<br/>
`YES`<br/>
`NO`<br/>

## Constraints
- **1 ≤ t ≤ 10^4** - number of test cases
- **2 ≤ n ≤ 2 × 10^5** - number of players
- **1 ≤ j, k ≤ n** - player index and final count
- **1 ≤ ai ≤ n** - player strengths
- The **sum of n over all test cases does not exceed 2 × 10^5**

## Notes
In the first sample, suppose that players 2 and 5 are chosen. Then **player 2 defeats player 5**. Now, the remaining player strengths are `[3, 2, 4, 4]`. Next, suppose that players 3 and 4 are chosen. Then **player 3 might defeat player 4**. Now, the remaining player strengths are `[3, 2, 4]`. **Player 2 is one of the last three players remaining**.

In the third sample, it can be shown that there is **no way for player 1 to be the last player remaining**.

