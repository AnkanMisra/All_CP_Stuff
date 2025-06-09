# C. Cool Partition

## Problem Statement

Yousef has an array `a` of size `n`. He wants to partition the array into one or more contiguous segments such that each element `ai` belongs to exactly one segment.

A partition is called **cool** if, for every segment `bj`, all elements in `bj` also appear in `bj+1` (if it exists). That is, every element in a segment must also be present in the segment following it.

- After partitioning the array, you do not change the order of the segments.
- If an element appears several times in some segment `bj`, it only needs to appear at least once in `bj+1`.

Your task is to help Yousef by finding the **maximum number of segments** that make a cool partition.

## Input Format

- The first line contains an integer `t` (1 ≤ t ≤ 10^4) — the number of test cases.
- For each test case:
  - The first line contains an integer `n` (1 ≤ n ≤ 2⋅10^5) — the size of the array.
  - The second line contains `n` integers `a1, a2, ..., an` (1 ≤ ai ≤ n) — the elements of the array.

It is guaranteed that the sum of `n` over all test cases doesn't exceed 2⋅10^5.

## Output Format

For each test case, print one integer — the maximum number of segments that make a cool partition.

## Examples

### Input
8  
6  
1 2 2 3 1 5  
8  
1 2 1 3 2 1 3 2  
5  
5 4 3 2 1  
10  
5 8 7 5 8 5 7 8 10 9  
3  
1 2 2  
9  
3 3 1 4 3 2 4 1 2  
6  
4 5 4 5 6 4  
8  
1 2 1 2 1 2 1 2  

### Output
2  
3  
1  
3  
1  
3  
3  
4  

## Explanation

- In the first test case, we can partition it into b1 = [1,2], b2 = [2,3,1,5]. It can be shown there is no other partition with more segments.
- In the second test case, we can partition the array into b1 = [1,2], b2 = [1,3,2], b3 = [1,3,2]. The maximum number of segments is 3.
- In the third test case, the only partition we can make is b1 = [5,4,3,2,1]. Any other partition will not satisfy the condition. Therefore, the answer is 1.
