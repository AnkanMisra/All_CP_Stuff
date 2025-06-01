# C. Gellyfish and Flaming Peony

Gellyfish hates math problems, but she has to finish her math homework:

Gellyfish is given an array of `n` positive integers `a₁, a₂, ..., aₙ`.

She needs to do the following two-step operation until all elements of `a` are equal:

1. Select two indexes `i, j` satisfying `1 ≤ i, j ≤ n` and `i ≠ j`.
2. Replace `aᵢ` with `gcd(aᵢ, aⱼ)`.

Now, Gellyfish asks you for the minimum number of operations to achieve her goal.

It can be proven that Gellyfish can always achieve her goal.

---

## Input

Each test contains multiple test cases.  
The first line contains the number of test cases `t` (1 ≤ t ≤ 5000).  
The description of the test cases follows.

The first line of each test case contains a single integer `n` (1 ≤ n ≤ 5000) — the length of the array.

The second line of each test case contains `n` integers `a₁, a₂, ..., aₙ` (1 ≤ aᵢ ≤ 5000) — the elements of the array.

It is guaranteed that the sum of `n` over all test cases does not exceed 5000.

---

## Output

For each test case, output a single integer — the minimum number of operations to achieve her goal.

---

## Example

Input
3
3
12 20 30
6
1 9 1 9 8 1
3
6 14 15

Output
4
3
3

---

## Note

In the first test case, the following is a way that minimizes the number of operations:

1. Choose i = 3 and j = 2 and replace a₃ with gcd(a₃, a₂) = gcd(30, 20) = 10, then a becomes [12, 20, 10].
2. Choose i = 1 and j = 3 and replace a₁ with gcd(a₁, a₃) = gcd(12, 10) = 2, then a becomes [2, 20, 10].
3. Choose i = 2 and j = 1 and replace a₂ with gcd(a₂, a₁) = gcd(20, 2) = 2, then a becomes [2, 2, 10].
4. Choose i = 3 and j = 1 and replace a₃ with gcd(a₃, a₁) = gcd(10, 2) = 2, then a becomes [2, 2, 2].
