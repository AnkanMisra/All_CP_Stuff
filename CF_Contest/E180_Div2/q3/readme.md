# Problem: C. Coloring Game

## Problem Description

Alice and Bob are playing a game using an integer array `a` of size `n`.

- Initially, all elements of the array are colorless.
- First, Alice chooses 3 elements and colors them red.
- Then Bob chooses any element and colors it blue (if it was red — recolor it).
- Alice wins if the sum of the red elements is **strictly greater** than the value of the blue element.

Your task is to calculate the number of ways that Alice can choose 3 elements in order to win **regardless of Bob's actions**.

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- For each test case:
  - The first line contains a single integer `n` (3 ≤ n ≤ 5000).
  - The second line contains `n` integers `a1, a2, ..., an` (1 ≤ a1 ≤ a2 ≤ ... ≤ an ≤ 10^5).
- Additional constraint: the sum of `n` over all test cases doesn't exceed 5000.

## Output Format

- For each test case, print a single integer — the number of ways that Alice can choose 3 elements in order to win regardless of Bob's actions.

## Examples

### Input
6<br />
3<br />
1 2 3<br />
4<br />
1 1 2 4<br />
5<br />
7 7 7 7 7<br />
5<br />
1 1 2 2 4<br />
6<br />
2 3 3 4 5 5<br />
5<br />
1 1 1 1 3<br />

### Output
0<br />
0<br />
10<br />
2<br />
16<br />
0<br />

## Notes

- In the first two test cases, no matter which three elements Alice chooses, Bob will be able to paint one element blue so that Alice does not win.
- In the third test case, Alice can choose any three elements. If Bob colors one of the red elements, the sum of red elements will be 14, and the sum of blue elements will be 7. If Bob chooses an uncolored element, the sum of red elements will be 21, and the sum of blue elements will be 7.
- In the fourth test case, Alice can choose either the 1st, 3rd and 4th element, or the 2nd, 3rd and 4th element.
