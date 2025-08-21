# Problem: **Maximize the Minimum Difference between k Elements**

## Problem Description
Given an integer array `arr[]` of size `n` and an integer `k`, select exactly **k** elements such that the **minimum absolute difference** between any two of the selected elements is **maximized**. Return this maximum possible minimum difference.

## Input Format
- `n` — size of the array
- `arr[]` — `n` space-separated integers
- `k` — number of elements to select (`2 ≤ k ≤ n`)

## Output Format
- A single integer representing the maximum possible minimum absolute difference.

## Examples

### **Input:**<br/>
`4`
`2 6 2 5`
`3`

### **Output:**<br/>
`1`

---

### **Input:**<br/>
`7`
`1 4 9 0 2 13 3`
`4`

### **Output:**<br/>
`4`

## Constraints
- **1 ≤ n ≤ 100000**
- **0 ≤ arr[i] ≤ 1000000**
- **2 ≤ k ≤ n**

## Notes
- The chosen `k` elements can be in any order; only their pairwise differences matter.
- The answer is the largest value `d` such that at least `k` elements can be picked where every pair differs by **at least** `d`.


