# Coin Piles

## Problem Statement

You are given an array `arr[]` of integers, where each element represents the number of coins in a pile. You are also given an integer `k`.

Your task is to remove the **minimum number of coins** such that the absolute difference between the number of coins in any two updated piles is at most `k`.

**Note:** You can also remove a pile by removing all the coins of that pile.

## Input Format

- An array `arr[]` of pile sizes (1 ≤ arr.size() ≤ 10^5, 1 ≤ arr[i] ≤ 10^4)
- An integer `k` (0 ≤ k ≤ 10^4)

## Output Format

- An integer representing the minimum number of coins to remove.

## Examples

### Example 1

Input:  
arr[] = [2, 2, 2, 2], k = 0

Output:  
0

Explanation:  
For any two piles the difference in the number of coins is ≤ 0. So no need to remove any coin.

### Example 2

Input:  
arr[] = [1, 5, 1, 2, 5, 1], k = 3

Output:  
2

Explanation:  
If we remove one coin each from both the piles containing 5 coins, then for any two piles the absolute difference in the number of coins is ≤ 3. This means the final piles should all be within a range `[x, x+k]`. For example, setting all piles to be between 1 and 4 would mean reducing the two 5-coin piles by 1 coin each, costing 2 removals.

## Constraints

- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ arr[i] ≤ 10^4
- 0 ≤ k ≤ 10^4
