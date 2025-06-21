# Problem: Police and Thieves

## Problem Description

Given an array `arr[]`, where each element contains either a `'P'` for policeman or a `'T'` for thief, find the **maximum number of thieves that can be caught by the police**. 

### Rules:
- Each policeman can catch only one thief.
- A policeman cannot catch a thief who is more than `k` units away from him.

## Input Format

- An array `arr[]` of characters, each being either `'P'` or `'T'`.
- An integer `k` representing the maximum distance a policeman can catch a thief.

## Output Format

- An integer representing the maximum number of thieves that can be caught.

## Examples

### Example 1

**Input:**  
arr[] = ['P', 'T', 'T', 'P', 'T'], k = 1

**Output:**  
2

**Explanation:**  
Maximum 2 thieves can be caught. First policeman catches first thief and second policeman can catch either second or third thief.

### Example 2

**Input:**  
arr[] = ['T', 'T', 'P', 'P', 'T', 'P'], k = 2

**Output:**  
3

**Explanation:**  
Maximum 3 thieves can be caught.

## Constraints

- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ k ≤ 1000
- arr[i] = 'P' or 'T'
