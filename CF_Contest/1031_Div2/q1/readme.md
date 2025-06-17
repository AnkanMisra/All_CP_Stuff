# A. Shashliks

## Problem Statement

You are the owner of a shashlik restaurant. Your grill starts at temperature `k`. You can cook as many portions as possible of two types of shashlik:

- **Type 1:** Requires at least `a` degrees to start, and after cooking, the grill's temperature decreases by `x`.
- **Type 2:** Requires at least `b` degrees to start, and after cooking, the grill's temperature decreases by `y`.

You have an unlimited supply of both types. The grill's temperature can become negative. For each test case, determine the maximum total number of portions you can cook.

## Input Format

- The first line contains the number of test cases `t` (1 ≤ t ≤ 10^4).
- Each test case contains five integers: `k`, `a`, `b`, `x`, `y` (1 ≤ k, a, b, x, y ≤ 10^9).

## Output Format

For each test case, output a single integer — the maximum number of portions of shashlik that can be cooked.

## Examples

### Input
5  
10 3 4 2 1  
1 10 10 1 1  
100 17 5 2 3  
28 14 5 2 4  
277 5 14 1 3  

### Output
8  
0  
46  
10  
273  

## Explanation

- In the first test case, it is best to cook 7 portions of the second type (each drops the temperature by 1), then 1 portion of the first type (drops by 2). Total: 8.
- In the second test case, the grill is too cold to cook any portion.
- In the fourth test case, it is best to cook 8 portions of the first type, then 2 of the second type.
