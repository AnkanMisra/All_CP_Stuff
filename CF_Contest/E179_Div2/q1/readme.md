# A. Energy Crystals

## Problem Statement

There are three energy crystals, each starting at energy level 0. Each crystal needs to be charged to level `x` (exactly `x`, not greater). In one action, you can increase the energy level of any one crystal by any positive amount. However, after each action, the following condition must be satisfied for every pair of crystals `i` and `j`:

- `ai ≥ floor(aj / 2)`

What is the minimum number of actions required to charge all the crystals to level `x`?

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- Each of the next `t` lines contains a single integer `x` (1 ≤ x ≤ 10^9).

## Output Format

For each test case, output a single integer — the minimum number of actions required to charge all energy crystals to level `x`.

## Examples

### Input
7  
1  
5  
14  
2025  
31415  
536870910  
1000000000  

### Output
3  
7  
9  
23  
31  
59  
61  

## Explanation

- In the first test case, one possible sequence of actions is:
  - [0,0,0] → [1,0,0] → [1,0,1] → [1,1,1] (3 actions)
- In the second test case, one possible sequence is:
  - [0,0,0] → [1,0,0] → [1,1,0] → [1,1,2] → [3,1,2] → [3,5,2] → [5,5,2] → [5,5,5] (7 actions)
