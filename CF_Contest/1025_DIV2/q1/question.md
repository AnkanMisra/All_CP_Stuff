    # A. Dinner Time

**Time limit per test:** 1 second  
**Memory limit per test:** 256 megabytes

---

## Problem Statement

Given four integers `n`, `m`, `p`, and `q`, determine whether there exists an integer array `a_1, a_2, ..., a_n` (elements may be negative) satisfying the following conditions:

1. The sum of all elements in the array is equal to `m`:
   - `a_1 + a_2 + ... + a_n = m`
2. The sum of every `p` consecutive elements is equal to `q`:
   - For all `1 ≤ i ≤ n - p + 1`:
     - `a_i + a_{i+1} + ... + a_{i+p-1} = q`

---

## Input

Each test contains multiple test cases.  
The first line contains the number of test cases `t` (`1 ≤ t ≤ 10^4`).  
The description of the test cases follows.

Each test case consists of a single line containing four integers `n`, `m`, `p`, and `q` (`1 ≤ p ≤ n ≤ 100`, `1 ≤ q, m ≤ 100`).

---

## Output

For each test case, output "YES" if there exists an array satisfying the above conditions, and "NO" otherwise.

You can output "YES" and "NO" in any case (for example, "yES", "yes", and "Yes" will all be recognized as valid responses).

---

## Example

### Input

5  
3 2 2 1  
1 1 1 1  
5 4 2 3  
10 7 5 2  
4 4 1 3  

### Output

YES  
YES  
YES  
NO  
NO  

---

## Note

- In the first test case, an example of an array satisfying the condition is `[1, 0, 1]`.
- In the second test case, the only array satisfying the condition is `[1]`.
- In the third test case, an example of an array satisfying the condition is `[-2, 5, -2, 5, -2]`.
- In the fourth test case, it can be proven that there is no array satisfying the condition.
