# D. Fewer Batteries

## Problem Statement

In the year 2077, robots compete in a game involving checkpoints and batteries. There are `n` checkpoints, and the `i`-th checkpoint contains `bi` batteries. The robot starts at the 1st checkpoint with no batteries and must reach the `n`-th checkpoint.

There are `m` one-way passages between checkpoints. The `i`-th passage allows movement from checkpoint `si` to checkpoint `ti` (`si < ti`), but not the other way. The passage can only be used if the robot has at least `wi` charged batteries.

When the robot arrives at checkpoint `v`, it can take any number of batteries from 0 to `bv` (inclusive). The robot always carries all previously collected batteries, and at each checkpoint, it recharges all previously collected batteries.

Find the minimum number of batteries that the robot can have at the end of the journey, or report that it is impossible to reach from the first checkpoint to the last.

## Input Format

- The first line contains the number of test cases `t` (1 ≤ t ≤ 10^4).
- For each test case:
  - The first line contains two integers `n` and `m` (2 ≤ n ≤ 2⋅10^5, 0 ≤ m ≤ 3⋅10^5) — the number of checkpoints and passages.
  - The second line contains `n` integers `b1, b2, ..., bn` (0 ≤ bi ≤ 10^9) — the number of batteries at each checkpoint.
  - The next `m` lines each contain three integers `si, ti, wi` (1 ≤ si < ti ≤ n, 1 ≤ wi ≤ 10^9) — the endpoints of the passage and the minimum number of batteries required to pass through it.

It is guaranteed that the sum of `n` across all test cases does not exceed 2⋅10^5, and the sum of `m` does not exceed 3⋅10^5.

## Output Format

For each test case, output the minimum number of batteries that you can have at the end of the journey, or `-1` if it is impossible to reach point `n`.

## Examples

### Input
4  
3 3  
2 0 0  
1 2 1  
2 3 1  
1 3 2  
5 6  
2 2 5 0 1  
1 2 2  
1 3 1  
1 4 3  
3 5 5  
2 4 4  
4 5 3  
2 0  
1 1  
4 4  
3 10 0 0  
1 2 1  
1 3 3  
2 3 10  
3 4 5  

### Output
1  
4  
-1  
10  

### Explanation

- In the first test case, you need to take 1 battery at the starting point, then move to point 2, and then to point 3.
- In the second test case, you need to take 2 batteries at the starting point, then move to point 2, take another 2 batteries, move to point 4, and then to point 5.
- In the third test case, there is no path from point 1 to point n.
- In the fourth test case, you need to take 1 battery at the starting point, then move to point 2, take another 9 batteries, move to point 3, and then to point 4.
