# Problem: B. T-primes

## Problem Description

A positive integer t is called a **T-prime** if t has exactly three distinct positive divisors.

You are given an array of n positive integers. For each of them, determine whether it is a T-prime or not.

## Input Format

- The first line contains a single positive integer, n (1 ≤ n ≤ 10^5), showing how many numbers are in the array.
- The next line contains n space-separated integers xi (1 ≤ xi ≤ 10^12).

## Output Format

- Print n lines: the i-th line should contain "YES" if number xi is T-prime, and "NO" if it isn't.

## Examples

### Input
3  
4 5 6  

### Output
YES  
NO  
NO  

## Notes

- The first number 4 has exactly three divisors — 1, 2, and 4, so the answer is "YES".
- The second number 5 has two divisors (1 and 5), and the third number 6 has four divisors (1, 2, 3, 6), so the answer for them is "NO".

## Explanation

A number t has exactly three distinct positive divisors if and only if t is a **perfect square of a prime number** (i.e., t = p^2 for some prime p).