# E. Unpleasant Strings

## Problem Statement

Let's call a letter **allowed** if it is a lowercase letter and is one of the first `k` letters of the Latin alphabet.

You are given a string `s` of length `n`, consisting only of allowed letters.

Let's call a string `t` **pleasant** if `t` is a subsequence of `s`.

You are given `q` strings `t1, t2, ..., tq`, each consisting only of allowed letters. For each string `ti`, calculate the minimum number of allowed letters you need to append to it on the right so that it stops being pleasant (i.e., is no longer a subsequence of `s`).

A sequence `t` is a subsequence of a sequence `s` if `t` can be obtained from `s` by deleting several (possibly zero or all) elements from arbitrary positions.

## Input Format

- The first line contains two integers `n` and `k` (1 ≤ n ≤ 10^6; 1 ≤ k ≤ 26) — the length of the string `s` and the number of allowed letters.
- The second line contains the string `s`, consisting of `n` lowercase Latin letters (each one of the first `k` letters).
- The third line contains one integer `q` (1 ≤ q ≤ 2⋅10^5) — the number of queries.
- The next `q` lines contain the queries: each line contains a string `ti` (consisting only of allowed letters).

Additional constraint: the total length of all `ti` does not exceed 10^6.

## Output Format

For each query, output one integer — the minimum number of allowed letters that need to be appended to the string on the right so that it stops being pleasant.

## Examples

### Input
7 3  
abacaba  
3  
cc  
bcb  
b  

### Output
0  
1  
2  

### Input
5 1  
aaaaa  
6  
a  
aa  
aaa  
aaaa  
aaaaa  
aaaaaa  

### Output
5  
4  
3  
2  
1  
0  

## Explanation

- In the first example:
    - The string `cc` is already unpleasant, so nothing needs to be appended.
    - `bcb` is pleasant, so at least one letter needs to be appended to the right: `bcba` will not work, but `bcbb` and `bcbc` are unpleasant.
    - For `b`, at least two letters need to be appended, since `ba`, `bb`, and `bc` are pleasant. For example, `bbb` is unpleasant.
- In the second example:
    - For each query, the answer is the number of additional `a`'s needed to make the string longer than `s`, so it cannot be a subsequence.
