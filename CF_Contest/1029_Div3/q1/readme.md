# A. False Alarm

## Problem Statement

Yousef is at the entrance of a long hallway with `n` doors in a row, numbered from 1 to `n`. He needs to pass through all the doors from 1 to `n` in order and reach the exit (past door `n`).

Each door can be open or closed. If a door is open, Yousef passes through it in 1 second. If the door is closed, Yousef can't pass through it.

However, Yousef has a special button which he can use **at most once** at any moment. This button makes all closed doors become open for `x` seconds.

Your task is to determine if Yousef can pass through all the doors if he can use the button at most once.

## Input Format

- The first line contains an integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- For each test case:
  - The first line contains two integers `n` and `x` (1 ≤ n, x ≤ 10) — the number of doors and the number of seconds the button works.
  - The second line contains `n` integers `a1, a2, ..., an` (ai ∈ {0, 1}) — the state of each door. Open doors are represented by `0`, closed doors by `1`.

It is guaranteed that each test case contains at least one closed door.

## Output Format

For each test case, output `"YES"` if Yousef can reach the exit, and `"NO"` otherwise.

You can output the answer in any case (upper or lower).

## Examples

### Input
7  
4 2  
0 1 1 0  
6 3  
1 0 1 1 0 0  
8 8  
1 1 1 0 0 1 1 1  
1 2  
1  
5 1  
1 0 1 0 1  
7 4  
0 0 0 1 1 0 1  
10 3  
0 1 0 0 1 0 0 1 0 0  

### Output
YES  
NO  
YES  
YES  
NO  
YES  
NO  

## Explanation

- In the first test case, Yousef can use the button at time 1 to pass through the two closed doors within the 2 seconds the button is active.
- In the second test case, the button's duration is not enough to cover all closed doors, so the answer is NO.
- In the third test case, Yousef can turn on the button before starting to move, and all doors will stay open until he reaches the exit.
