# Group Balls by Sequence

## Constraints
- 1 ≤ arr.size() ≤ 10^6
- 0 ≤ arr[i] ≤ 10^5
- 1 ≤ k ≤ 10^3

## Problem Statement
You are given an array **arr[]** of positive integers, where each element **arr[i]** represents the number written on the i-th ball, and a positive integer **k**.

Your task is to determine whether it is possible to rearrange all the balls into groups such that:
- Each group contains exactly **k** balls.
- The numbers in each group are consecutive integers.

## Input Format
- An array **arr[]** of positive integers.
- An integer **k**.

## Output Format
- Output **true** if it is possible to rearrange the balls into the required groups, otherwise output **false**.

## Examples

Input:  
arr[] = [10, 1, 2, 11], k = 2  
Output:  
true  
Explanation: The hand can be rearranged as [1, 2], [10, 11]. There are two groups of size 2. Each group has 2 consecutive cards.

Input:  
arr[] = [7, 8, 9, 10, 11], k = 2  
Output:  
false  
Explanation: The hand cannot be rearranged into groups of 2, since there are 5 cards, and 5 cards cannot be divided into groups of 2.
