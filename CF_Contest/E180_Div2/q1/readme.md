# Problem: A. Race

## Problem Description

Alice and Bob participate in a game TV show. When the game starts, the prize will be dropped to a certain point, and whoever gets to it first will get the prize.

Alice decided that she would start running from point `a`. Bob, however, has not yet chosen his starting position.

Bob knows that the prize could drop either at point `x` or at point `y`. He also knows that he can reach the prize faster than Alice if the distance from his starting position to the prize is **strictly less** than the distance from Alice's starting position to the prize. The distance between any two points `c` and `d` is calculated as |c - d|.

Your task is to determine whether Bob can choose an integer point that is guaranteed to get to the prize faster, regardless of where it appears (at point `x` or `y`). Bob can choose any integer point, except for `a` (in particular, he can choose to start in point `x`, point `y`, or any other point, but not `a`).

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 1000) — the number of test cases.
- The only line of each test case contains three integers `a`, `x`, `y` (1 ≤ a, x, y ≤ 100). Points `a`, `x`, and `y` are pairwise distinct.

## Output Format

- For each test case, print "YES" (case insensitive) if Bob can choose an integer point that is guaranteed to get to the prize faster, regardless of where it appears. Otherwise, print "NO" (case insensitive).

## Examples

### Input
3<br />
1 3 4<br />
5 3 1<br />
3 1 5<br />

### Output
YES<br />
YES<br />
NO<br />

## Notes

- In the first example, Bob can choose point 4. If the prize will be at point x, then Bob's distance is |4 - 3| = 1 and Alice's distance is |1 - 3| = 2. If the prize will be at point y, then Bob's distance is |4 - 4| = 0 and Alice's distance is |1 - 4| = 3.
- In the second example, Bob can choose point 2. If the prize will be at point x, then Bob's distance is |2 - 3| = 1 and Alice's distance is |5 - 3| = 2. If the prize will be at point y, then Bob's distance is |2 - 1| = 1 and Alice's distance is |5 - 1| = 4.
- In the third example, Bob cannot choose a point to guarantee his victory.
