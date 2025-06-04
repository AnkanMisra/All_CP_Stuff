# C. Racing

## Problem Statement
In the year 2077, hobby-droning is a popular sport. You have a drone and want to win a race by flying through a course with `n` obstacles.

Each obstacle is defined by two numbers `li` and `ri`. The height of your drone at the `i`-th obstacle is `hi`. The drone passes through the obstacle if `li ≤ hi ≤ ri`. Initially, the drone is on the ground, so `h0 = 0`.

The drone's flight program is represented by an array `d1, d2, ..., dn`, where `hi - hi-1 = di` and `0 ≤ di ≤ 1`. This means the drone can either stay at the same height or rise by 1 between obstacles. Some values of `di` are unknown and marked as `-1`. Your task is to replace the unknown `di` with numbers 0 or 1 to create a valid flight program that passes through all obstacles, or report that it is impossible.

## Input Format
- The first line contains the number of test cases `t` (1 ≤ t ≤ 10^4).
- For each test case:
  - The first line contains an integer `n` (1 ≤ n ≤ 2 * 10^5) — the number of obstacles.
  - The second line contains `n` integers `d1, d2, ..., dn` (−1 ≤ di ≤ 1) — the flight program, where `-1` means unknown.
  - The next `n` lines each contain two integers `li` and `ri` (0 ≤ li ≤ ri ≤ n) — the allowed height range for the `i`-th obstacle.

It is guaranteed that the sum of `n` across all test cases does not exceed 2 * 10^5.

## Output Format
For each test case, output `n` integers `d1, d2, ..., dn` if it is possible to correctly restore the array `d`. If it is not possible, output `-1`.

## Examples

### Input
5  
4  
0 -1 -1 1  
0 4  
1 2  
2 4  
1 4  
3  
0 -1 -1  
1 2  
2 2  
0 3  
2  
-1 -1  
0 0  
2 2  
8  
-1 1 1 -1 -1 1 0 0 -1  
0 0  
0 1  
0 2  
0 2  
1 3  
0 4  
2 5  
4 5  
1  
0  
1 1  

### Output
0 1 1 1  
-1  
-1  
0 1 1 0 1 0 0 1  
-1  

### Explanation
- In the first test case, one possible answer is `0 1 1 1`. The heights will be `[0, 1, 2, 3]`, which all satisfy the obstacle constraints.
- In the second and third test cases, it is impossible to find a suitable array `d`, so the answer is `-1`.
