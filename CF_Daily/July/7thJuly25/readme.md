# Problem: Pair of Topics

## Problem Description
You are given **n topics** for a high school lecture. Each topic has an interestingness value for the **teacher** (`a_i`) and for the **students** (`b_i`). A pair of topics `i` and `j` (`i < j`) is called **good** if `a_i + a_j > b_i + b_j` (i.e., the pair is more interesting for the teacher than for the students). Your task is to **find the number of good pairs of topics**.

## Input Format
- The first line contains **one integer** `n` — the number of topics.
- The second line contains **n integers** `a_1, a_2, ..., a_n` — interestingness for the teacher.
- The third line contains **n integers** `b_1, b_2, ..., b_n` — interestingness for the students.

## Output Format
- Print **one integer** — the number of good pairs of topics.

## Examples

**Input:** <br/>`5`<br/>`4 8 2 6 2`<br/>`4 5 4 1 3`<br/><br/>
**Output:** <br/>`7`<br/>

**Input:** <br/>`4`<br/>`1 3 2 4`<br/>`1 3 2 4`<br/><br/>
**Output:** <br/>`0`<br/>

## Constraints
- `2 ≤ n ≤ 2⋅10^5`
- `1 ≤ a_i ≤ 10^9`
- `1 ≤ b_i ≤ 10^9`

## Notes
- Only pairs with `i < j` are considered.
- The sum `a_i + a_j` must be **strictly greater** than `b_i + b_j` for the pair to be good.


