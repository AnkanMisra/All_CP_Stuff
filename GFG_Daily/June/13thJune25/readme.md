# Koko Eating Bananas

## Problem Statement

Koko is given an array `arr[]`, where each element represents a pile of bananas. She has exactly `k` hours to eat all the bananas.

Each hour, Koko can choose one pile and eat up to `s` bananas from it.

- If the pile has at least `s` bananas, she eats exactly `s` bananas.
- If the pile has fewer than `s` bananas, she eats the entire pile in that hour.

Koko can only eat from one pile per hour.

Your task is to find the **minimum value of `s` (bananas per hour)** such that Koko can finish all the piles within `k` hours.

## Input Format

- An array `arr[]` of pile sizes (1 ≤ arr.size() ≤ 10^5, 1 ≤ arr[i] ≤ 10^6)
- An integer `k` (arr.size() ≤ k ≤ 10^6)

## Output Format

- An integer representing the minimum value of `s` such that Koko can finish all the piles within `k` hours.

## Examples

### Example 1

Input:  
arr[] = [5, 10, 3], k = 4

Output:  
5

Explanation:  
Koko eats at least 5 bananas per hour to finish all piles within 4 hours, as she can consume each pile in 1 + 2 + 1 = 4 hours.

### Example 2

Input:  
arr[] = [5, 10, 15, 20], k = 7

Output:  
10

Explanation:  
At 10 bananas per hour, Koko finishes in 6 hours, just within the limit 7.

## Constraints

- 1 ≤ arr.size() ≤ 10^5 
- 1 ≤ arr[i] ≤ 10^6
- arr.size() ≤ k ≤ 10^6
