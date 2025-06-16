# Equalize the Towers

## Problem Statement

You are given an array `heights[]` representing the heights of towers and another array `cost[]` where each element represents the cost of modifying the height of the respective tower.

- The goal is to make all towers of the same height by either adding or removing blocks from each tower.
- Modifying the height of tower `i` by 1 unit costs `cost[i]`.

Return the minimum cost to equalize the heights of all towers.

## Input Format

- An array `heights[]` (1 ≤ heights.size() ≤ 10^5, 1 ≤ heights[i] ≤ 10^4)
- An array `cost[]` (1 ≤ cost.size() ≤ 10^5, 1 ≤ cost[i] ≤ 10^3)

## Output Format

- An integer representing the minimum cost to equalize the heights of all towers.

## Examples

### Example 1

Input:  
heights[] = [1, 2, 3]  
cost[] = [10, 100, 1000]  

Output:  
120  

Explanation:  
The heights can be equalized by either "Removing one block from 3 and adding one in 1" or "Adding two blocks in 1 and adding one in 2". Since the cost of operation in tower 3 is 1000, the first process would yield 1010 while the second one yields 120.

### Example 2

Input:  
heights[] = [7, 1, 5]  
cost[] = [1, 1, 1]  

Output:  
6  

Explanation:  
The minimum cost to equalize the towers is 6, achieved by setting all towers to height 5.

## Constraints

- 1 ≤ heights.size() = cost.size() ≤ 10^5
- 1 ≤ heights[i] ≤ 10^4
- 1 ≤ cost[i] ≤ 10^3
