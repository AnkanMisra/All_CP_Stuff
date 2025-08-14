
# Problem: B. AGAGA XOOORRR

## Problem Description
Baby Ehab is known for his love for a certain operation. He has an array `a` of length `n`, and he decided to keep doing the following operation on it: he picks **2 adjacent elements**; he then removes them and places a single integer in their place: their **bitwise XOR**. Note that the length of the array decreases by one.

Now he asks you if he can **make all elements of the array equal**. Since babies like to make your life harder, he requires that you **leave at least 2 elements remaining**.

## Input Format
The first line contains an integer `t` (1 ≤ t ≤ 15) — the number of test cases you need to solve.

The first line of each test case contains an integer `n` (2 ≤ n ≤ 2000) — the number of elements in the array `a`.

The second line contains `n` space-separated integers `a1, a2, ..., an` (0 ≤ ai < 2^30) — the elements of the array `a`.

## Output Format
If Baby Ehab can make all elements equal while **leaving at least 2 elements standing**, print `"YES"`. Otherwise, print `"NO"`.

## Examples

### Input

`2`<br/>
`3`<br/>
`0 2 2`<br/>
`4`<br/>
`2 3 1 10`<br/>

### Output

`YES`<br/>
`NO`<br/>

## Constraints
- **1 ≤ t ≤ 15** (number of test cases)
- **2 ≤ n ≤ 2000** (array length)
- **0 ≤ ai < 2^30** (array elements)

## Notes
In the first sample, he can remove the first 2 elements, `0` and `2`, and replace them by `0 ⊕ 2 = 2`. The array will be `[2, 2]`, so all the elements are equal.

In the second sample, there's no way to make all the elements equal.

