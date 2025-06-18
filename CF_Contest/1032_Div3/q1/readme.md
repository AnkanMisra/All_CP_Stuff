# A. Letter Home

## Problem Statement

You are given an array of distinct integers `x1, x2, ..., xn` and an integer `s`.

Initially, you are at position `pos = s` on the X axis. In one step, you can move to `pos + 1` or `pos - 1`.

A sequence of steps is considered successful if, during the entire journey, you visit each position `xi` on the X axis at least once. The initial position `pos = s` is also considered visited.

Your task is to determine the **minimum number of steps** in any successful sequence of steps.

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- For each test case:
  - The first line contains two integers `n` and `s` (1 ≤ n ≤ 10, 1 ≤ s ≤ 100) — the number of positions to visit and the starting position.
  - The second line contains `n` integers `x1, x2, ..., xn` (1 ≤ xi ≤ 100, xi < xi+1).

## Output Format

For each test case, output the minimum number of steps in any successful sequence of steps.

## Examples

### Input
12  
1 1  
1  
1 2  
1  
1 1  
2  
2 1  
2 3  
2 2  
1 3  
2 3  
1 2  
3 1  
1 2 3  
3 2  
1 3 4  
3 3  
1 2 3  
4 3  
1 2 3 10  
5 5  
1 2 3 6 7  
6 6  
1 2 3 9 10 11  

### Output
0  
1  
1  
2  
3  
2  
2  
4  
2  
11  
8  
15  

## Explanation

- In the first test case, you are already at the only required position, so no steps are needed.
- In the second test case, you start at 2 and need to visit 1, so you move left once.
- In the fifth test case, you start at 2 and need to visit 1 and 3. The optimal path is 2 → 1 → 2 → 3, which takes 3 steps.
- In the last test case, you need to visit positions 1, 2, 3, 9, 10, 11 starting from 6. The minimum number of steps is 15.
