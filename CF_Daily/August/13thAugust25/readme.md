
# Problem: Special Elements

## Problem Description
The array `a = [a1, a2, ..., an]` (where `1 ≤ ai ≤ n`) is given. Its element `ai` is called **special** if there exists a pair of indices `l` and `r` (where `1 ≤ l < r ≤ n`) such that `ai = al + al+1 + ... + ar`. In other words, an element is called **special** if it can be represented as the **sum of two or more consecutive elements** of an array (no matter if they are special or not).

Print the **number of special elements** of the given array `a`.

## Input Format
The first line contains an integer `t` (`1 ≤ t ≤ 1000`) — the **number of test cases** in the input. Then `t` test cases follow.

Each test case is given in two lines. The first line contains an integer `n` (`1 ≤ n ≤ 8000`) — the **length of the array** `a`. The second line contains integers `a1, a2, ..., an` (`1 ≤ ai ≤ n`).

## Output Format
Print `t` numbers — the **number of special elements** for each of the given arrays.

## Examples

### Input
<br/>

```
5
9
3 1 4 1 5 9 2 6 5
3
1 1 2
5
1 1 1 1 1
8
8 7 6 5 4 3 2 1
1
1

```

### Output
<br/>

```
5
1
0
4
0

```
## Constraints
- `1 ≤ t ≤ 1000`
- `1 ≤ n ≤ 8000`
- `1 ≤ ai ≤ n`
- It is guaranteed that the **sum of the values of n** for all test cases in the input does not exceed `8000`
- **Memory limit:** 64 megabytes (non-standard)
- **Time limit:** 1 second per test

## Notes
- **Pay attention to the non-standard memory limit** in this problem
- In order to cut off efficient solutions from inefficient ones, the **time limit is rather strict**
- Prefer to use **compiled statically typed languages** (e.g. C++). If you use Python, then submit solutions on **PyPy**
- Some elements of the array `a` may be equal — if **several elements are equal and special**, then **all of them should be counted** in the answer
- For the example with `n = 9` and `a = [3,1,4,1,5,9,2,6,5]`, the answer is `5`:
  - `a3 = 4` is special, since `a3 = 4 = a1 + a2 = 3 + 1`
  - `a5 = 5` is special, since `a5 = 5 = a2 + a3 = 1 + 4`
  - `a6 = 9` is special, since `a6 = 9 = a1 + a2 + a3 + a4 = 3 + 1 + 4 + 1`
  - `a8 = 6` is special, since `a8 = 6 = a2 + a3 + a4 = 1 + 4 + 1`
  - `a9 = 5` is special, since `a9 = 5 = a2 + a3 = 1 + 4`

