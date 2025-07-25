
# Problem: Make a Palindrome

## Problem Description
You are given an array `a` of size `n`, and an integer `k`. You may perform the following operation any number of times:

- Select two integers `l` and `r` (`1 ≤ l ≤ r ≤ |a|`) such that **`r - l + 1 ≥ k`**.
- Then, select an index `i` such that `l ≤ i ≤ r` where `a_i` is the **k-th smallest number** out of the subarray `[a_l, a_{l+1}, ..., a_r]`. If there are multiple possible `i`, you may select any.
- Then, **delete `a_i`** from `a`, concatenating the remaining parts of the array.

Determine if it is possible to get an array that is a **palindrome** after any number of operations. Note that an **empty array is considered a palindrome**.

*An array `b = [b_1, b_2, ..., b_m]` is a palindrome if for each `1 ≤ i ≤ m`, `b_i = b_{m+1-i}`.*

## Input Format
Each test contains multiple test cases. The first line contains the number of test cases `t` (`1 ≤ t ≤ 10^4`).

The description of the test cases follows:
- The first line contains two integers **`n`** and **`k`** (`1 ≤ k ≤ n ≤ 2⋅10^5`).
- The second line contains **`n` integers** `a_1, a_2, ..., a_n` (`1 ≤ a_i ≤ n`) — denoting the array `a`.

It is guaranteed that the **sum of `n` over all test cases does not exceed `2⋅10^5`**.

## Output Format
For each test case, output **YES** if it is possible to create a palindrome, and **NO** otherwise. You can output in any case (upper or lower).

## Examples

### Input

```
8
5 3
5 4 3 4 5
4 1
1 1 2 1
6 6
2 3 4 5 3 2
5 4
5 2 4 3 1
8 5
4 7 1 2 3 1 3 4
5 4
1 2 1 2 2
3 3
1 2 2
4 4
2 1 2 2
```

### Output

```
YES
YES
YES
NO
NO
YES
NO
YES
```

## Constraints
- **`1 ≤ t ≤ 10^4`** (number of test cases)
- **`1 ≤ k ≤ n ≤ 2⋅10^5`** (array size and parameter)
- **`1 ≤ a_i ≤ n`** (array elements)
- **Sum of `n` over all test cases ≤ `2⋅10^5`**

## Notes
- In the **first test case**, `a` is already a palindrome.
- In the **second test case**, we can perform two operations as follows: `[1,1,2,1] → [1,2,1] → [1,1]`
- In the **third test case**, we can perform one operation as follows: `[2,3,4,5,3,2] → [2,3,4,3,2]`
- In the **fourth and fifth test cases**, it can be shown it is impossible to create a palindrome no matter what operations are used.
- For example, consider `a = [1,2,2,1,3]`, `l = 1`, `r = 5` and `k = 3`, the possible candidates of `i` are **indices 2 and 3** (both have value 2, which is the 3rd smallest in the subarray).

