
# Problem: A. Powered Addition

## Problem Description
You have an array `a` of length `n`. For every positive integer `x` you are going to perform the following operation during the `x`-th second:

Select some distinct indices `i1, i2, ..., ik` which are between `1` and `n` inclusive, and add `2^(x-1)` to each corresponding position of `a`. Formally, `a[ij] := a[ij] + 2^(x-1)` for `j = 1, 2, ..., k`. Note that you are allowed to not select any indices at all.

You have to **make array `a` nondecreasing as fast as possible**. Find the **smallest number `T`** such that you can make the array nondecreasing after at most `T` seconds.

Array `a` is nondecreasing if and only if `a1 ≤ a2 ≤ ... ≤ an`.

## Input Format
The first line contains a single integer `t` (`1 ≤ t ≤ 10^4`) — the number of test cases.

The first line of each test case contains single integer `n` (`1 ≤ n ≤ 10^5`) — the length of array `a`. It is guaranteed that the sum of values of `n` over all test cases in the input does not exceed `10^5`.

The second line of each test case contains `n` integers `a1, a2, ..., an` (`-10^9 ≤ ai ≤ 10^9`).

## Output Format
For each test case, print the **minimum number of seconds** in which you can make `a` nondecreasing.

## Examples

### Input

`3`<br/>
`4`<br/>
`1 7 6 5`<br/>
`5`<br/>
`1 2 3 4 5`<br/>
`2`<br/>
`0 -4`<br/>

### Output

`2`<br/>
`0`<br/>
`3`<br/>

## Constraints
- **Time limit:** 1 second per test
- **Memory limit:** 256 megabytes
- `1 ≤ t ≤ 10^4`
- `1 ≤ n ≤ 10^5`
- `-10^9 ≤ ai ≤ 10^9`
- Sum of `n` over all test cases ≤ `10^5`

## Notes
In the first test case, if you select indices `3, 4` at the 1st second and `4` at the 2nd second, then `a` will become `[1, 7, 7, 8]`. There are some other possible ways to make `a` nondecreasing in `2` seconds, but you can't do it faster.

In the second test case, `a` is already nondecreasing, so answer is `0`.

In the third test case, if you do nothing at first `2` seconds and select index `2` at the 3rd second, `a` will become `[0, 0]`.

