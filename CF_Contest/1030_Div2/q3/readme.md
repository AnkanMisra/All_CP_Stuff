# C. Make It Beautiful

## Problem Statement
You are given an array `a` of `n` integers. The **beauty** of a number `x` is the number of `1` bits in its binary representation. The **beauty** of an array is the sum of beauties of the numbers it contains.

In one operation, you can select an index `i` (`1 ≤ i ≤ n`) and increase `a[i]` by 1.

Find the **maximum beauty** of the array after doing at most `k` operations.

## Input Format
- The first line contains the number of test cases `t` (1 ≤ t ≤ 5000).
- For each test case:
  - The first line contains two integers `n` and `k` (1 ≤ n ≤ 5000, 0 ≤ k ≤ 10^18) — the length of the array and the maximal number of operations.
  - The second line contains `n` integers `a1, a2, ..., an` (0 ≤ ai ≤ 10^9) — denoting the array `a`.

It is guaranteed that the sum of `n` over all test cases does not exceed 5000.

## Output Format
For each test case, output a single integer, the maximum beauty after at most `k` operations.

## Examples

### Input
5  
5 2  
0 1 7 2 4  
5 3  
0 1 7 2 4  
1 1  
3  
3 0  
2 0 3  
1 100000000000  
0  

### Output
8  
9  
2  
3  
36  

### Explanation
- In the first test case, a=[0,1,7,2,4].
    - Applying 1st operation at i=1 changes a[0] from 0 to 1. Array becomes [1,1,7,2,4]. Cost = 1.
    - Applying 2nd operation at i=4 changes a[3] from 2 to 3. Array becomes [1,1,7,3,4]. Cost = 1. Total cost = 2.
    - The beauty of this array is popcount(1)+popcount(1)+popcount(7)+popcount(3)+popcount(4) = 1+1+3+2+1 = 8.
- In the third test case, a=[3]. Since k=1, and `popcount(3)=2`, increasing it might decrease beauty (e.g., 3->4, popcount 2->1) or yield less efficient use of operations. It is optimal to do none, beauty = 2.
