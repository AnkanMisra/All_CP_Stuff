
# Problem: Mortal Kombat Tower

## Problem Description
You and your friend are playing Mortal Kombat XI and trying to pass a challenge tower with **n bosses numbered from 1 to n**. Each boss has a type: `ai = 0` for easy bosses and `ai = 1` for hard bosses.

During gameplay, sessions alternate between you and your friend, starting with **your friend's session first**. In each session, a player must kill **one or two bosses** (skipping is not allowed). Your friend **cannot kill hard bosses** without using skip points - **one skip point kills one hard boss**.

Your task is to find the **minimum number of skip points** your friend needs to kill all n bosses in the given order.

## Input Format
- First line: integer `t` (number of test cases)
- For each test case:
  - First line: integer `n` (number of bosses)
  - Second line: `n` integers `a1, a2, ..., an` where `ai` is the type of the i-th boss

## Output Format
For each test case, print the **minimum number of skip points** needed.

## Examples

### Input

```
6
8
1 0 1 1 0 1 1 1
5
1 1 1 1 0
7
1 1 1 1 0 0 1
6
1 1 1 1 1 1
1
1
1
0
```

### Output

```
2
2
2
2
1
0
```

## Constraints
- `1 ≤ t ≤ 2×10^4`
- `1 ≤ n ≤ 2×10^5`
- `0 ≤ ai ≤ 1`
- Sum of all n across test cases ≤ `2×10^5`

## Notes
**Example walkthrough** for `n = 8`, `a = [1,0,1,1,0,1,1,1]`:
- Friend's turn: kills bosses 1,2 (uses 1 skip point for boss 1)
- Your turn: kills bosses 3,4
- Friend's turn: kills boss 5
- Your turn: kills bosses 6,7
- Friend's turn: kills boss 8 (uses 1 skip point)

**Total skip points used: 2**

