# 3405. Count the Number of Arrays with K Matching Adjacent Elements

## Problem Statement
You are given three integers `n`, `m`, and `k`. A **good array** `arr` of size `n` is defined as follows:
- Each element in `arr` is in the inclusive range `[1, m]`.
- Exactly `k` indices `i` (where `1 <= i < n`) satisfy the condition `arr[i - 1] == arr[i]`.

Return the number of good arrays that can be formed.

Since the answer may be very large, return it modulo `10^9 + 7`.

## Input Format
- `n`: An integer representing the size of the array.
- `m`: An integer representing the maximum value an element can take.
- `k`: An integer representing the exact number of matching adjacent elements.

## Output Format
- An integer representing the number of good arrays, modulo `10^9 + 7`.

## Examples

### Example 1
Input:  
n = 3, m = 2, k = 1  

Output:  
4  

Explanation:  
There are 4 good arrays. They are [1, 1, 2], [1, 2, 2], [2, 1, 1] and [2, 2, 1].  
Hence, the answer is 4.

### Example 2
Input:  
n = 4, m = 2, k = 2  

Output:  
6  

Explanation:  
The good arrays are [1, 1, 1, 2], [1, 1, 2, 2], [1, 2, 2, 2], [2, 1, 1, 1], [2, 2, 1, 1] and [2, 2, 2, 1].  
Hence, the answer is 6.

### Example 3
Input:  
n = 5, m = 2, k = 0  

Output:  
2  

Explanation:  
The good arrays are [1, 2, 1, 2, 1] and [2, 1, 2, 1, 2]. Hence, the answer is 2.

## Constraints
- 1 <= n <= 10^5
- 1 <= m <= 10^5
- 0 <= k <= n - 1
