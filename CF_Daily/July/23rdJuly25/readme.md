
# Problem: Kefa and Company

## Problem Description
Kefa wants to celebrate his first big salary by going to a restaurant with friends. He has `n` friends, each characterized by the amount of money they have and their friendship factor. Kefa wants to invite a group such that **no friend feels poor** compared to another (Kefa himself is not counted). A friend feels poor if there is someone in the group with at least `d` units more money than them. The goal is to **maximize the total friendship factor** of the invited group.

## Input Format
- The first line contains two space-separated integers: **`n`** (number of friends) and **`d`** (minimum difference in money to feel poor).
- The next `n` lines each contain two integers: **`m_i`** (money of the i-th friend) and **`s_i`** (friendship factor of the i-th friend).

## Output Format
- Print the **maximum total friendship factor** that can be achieved.

## Examples

### Input
4 5<br/>
75 5<br/>
0 100<br/>
150 20<br/>
75 1<br/>

### Output
100<br/>

### Input
5 100<br/>
0 7<br/>
11 32<br/>
99 10<br/>
46 8<br/>
87 54<br/>

### Output
111<br/>

## Constraints
- `1 ≤ n ≤ 100000`
- `0 ≤ m_i, s_i ≤ 1000000000`

## Notes
- In the first example, the best option is to invite only the second friend for a total friendship factor of **100**.
- In the second example, all friends can be invited for a total friendship factor of **111**.

