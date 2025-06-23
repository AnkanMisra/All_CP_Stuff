# Problem: Minimum sum

## Problem Description

Given an array `arr[]` consisting of digits, your task is to form **two numbers** using all the digits such that their sum is minimized. Return the minimum possible sum as a string with no leading zeroes.

## Input Format

- An array `arr[]` of digits (0 ≤ arr[i] ≤ 9).

## Output Format

- A string representing the minimum possible sum of the two numbers formed, with no leading zeroes.

## Examples

### Example 1

**Input:**  
arr[] = [6, 8, 4, 5, 2, 3]

**Output:**  
"604"

**Explanation:**  
The minimum sum is formed by numbers 358 and 246.

### Example 2

**Input:**  
arr[] = [5, 3, 0, 7, 4]

**Output:**  
"82"

**Explanation:**  
The minimum sum is formed by numbers 35 and 047.

### Example 3

**Input:**  
arr[] = [9, 4]

**Output:**  
"13"

**Explanation:**  
The minimum sum is formed by numbers 9 and 4.

## Constraints

- 2 ≤ arr.size() ≤ 10^6
- 0 ≤ arr[i] ≤ 9
