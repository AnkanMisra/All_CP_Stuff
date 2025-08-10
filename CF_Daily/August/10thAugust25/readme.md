
# Problem: Tetrahedron

## Problem Description
You are given a tetrahedron with vertices marked as **A**, **B**, **C**, and **D**.

![Tetrahedron](https://espresso.codeforces.com/3be56c11ee711a62cf3764b079d14a9dd16dac0e.png)

An ant is standing at vertex **D** and is quite active - it **cannot stay idle**. At each moment, the ant **must make a step** from one vertex to another along some edge of the tetrahedron.

Your task is to **count the number of ways** the ant can go from the initial vertex **D** to itself in **exactly n steps**. In other words, find the number of different **cyclic paths with length n** from vertex D to itself.

## Input Format
The first line contains a single integer **n** (`1 ≤ n ≤ 10^7`) — the required length of the cyclic path.

## Output Format
Print a single integer — the required number of ways **modulo 1000000007** (`10^9 + 7`).

## Examples

### Input

`2`<br/>

### Output

`3`<br/>

### Input

`4`<br/>

### Output

`21`<br/>

## Constraints
- **1 ≤ n ≤ 10^7**
- Answer should be printed **modulo 1000000007**

## Notes
The required paths in the first sample are:
- **D - A - D**
- **D - B - D**
- **D - C - D**

In a tetrahedron, each vertex is connected to all other three vertices, so from any vertex the ant has **exactly 3 choices** for the next step.

