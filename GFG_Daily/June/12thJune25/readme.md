# K Closest Elements

## Problem Statement

You are given a sorted array `arr[]` of unique integers, an integer `k`, and a target value `x`. Return exactly `k` elements from the array closest to `x`, **excluding `x` if it exists**.

An element `a` is closer to `x` than `b` if:
- `|a - x| < |b - x|`, or
- `|a - x| == |b - x|` and `a > b` (i.e., prefer the larger element if tied)

Return the `k` closest elements in order of closeness.

## Input Format

- A sorted array `arr[]` of unique integers (1 ≤ arr.size() ≤ 10^5)
- An integer `k` (1 ≤ k ≤ arr.size())
- An integer `x` (1 ≤ x ≤ 10^6)

## Output Format

- Output the `k` closest elements to `x` (excluding `x` if present), in order of closeness as defined above.

## Examples

### Example 1

Input:  
arr[] = [1, 3, 4, 10, 12], k = 2, x = 4

Output:  
3 1

Explanation:  
4 is excluded. Closest elements to 4 are: 3 (distance 1), 1 (distance 3). So, the 2 closest elements are: 3 1.

### Example 2

Input:  
arr[] = [12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56], k = 4, x = 35

Output:  
39 30 42 45

Explanation:  
First closest element to 35 is 39 (distance 4).  
Second closest is 30 (distance 5).  
Third closest is 42 (distance 7).  
Fourth closest is 45 (distance 10).

## Constraints

- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ k ≤ arr.size()
- 1 ≤ x ≤ 10^6
- 1 ≤ arr[i] ≤ 10^6
