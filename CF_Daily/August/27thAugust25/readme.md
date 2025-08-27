# Circle of Monsters

## Problem Description
You are given **n monsters** arranged in a circle, numbered clockwise from **1** to **n**. The **i-th monster** starts with **health `a_i`**. You can fire bullets; each bullet decreases the targeted monster's health by **1**.
When a monster's health reaches **0** or below, it **dies** and **explodes**, dealing **`b_i` damage** to the **next monster** (monster `i+1`, or monster `1` if `i = n`).
An explosion can cause a chain reaction if it kills the next monster.
Your task is to find the **minimum number of bullets** needed to kill all monsters.

## Input Format
- The first line contains an integer **T** — the number of test cases.
- For each test case:
  - A line with an integer **n** — the number of monsters.
  - **n** lines follow; the **i-th** of them contains two integers **`a_i` `b_i`** — the initial health of the monster and the explosion damage it deals to the next monster.

## Output Format
For each test case, output **one integer** — the minimum number of bullets required.

## Examples

### Example 1
**Input**

<br/>
1
3
7 15
2 14
5 3
<br/>

**Output**

<br/>
6
<br/>

### Example 2
**Input**

<br/>
1
2
3 1
2 5
<br/>

**Output**

<br/>
2
<br/>

## Constraints
- `1 ≤ T ≤ 150000`
- `2 ≤ n ≤ 300000`
- `1 ≤ a_i, b_i ≤ 10^12`
- The sum of **n** over all test cases does not exceed `300000`.

## Notes
In Example 1, by first shooting the third monster until it dies (5 bullets), its explosion deals 3 damage to the first monster, leaving it with 4 health. One more bullet kills the first monster, whose explosion finishes the second. The minimum total bullets is **6**.

In Example 2, the first bullet kills the first monster, and the second bullet finishes the second. The minimum total bullets is **2**.

