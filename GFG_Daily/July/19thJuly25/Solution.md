
# Solution Explanation

## Intuition
The key idea is to count all possible ways to select one occurrence of each unique vowel present in the string, and then arrange these selected vowels in all possible orders (permutations). Each unique arrangement forms a distinct string.

## Approach
- **Identify all unique vowels** (`a`, `e`, `i`, `o`, `u`) present in the string `s`.
- For each unique vowel, **count the number of times** it appears in `s`.
- For each vowel, you can choose **any one of its occurrences**. So, for `k` unique vowels with counts `c1, c2, ..., ck`, the total number of ways to select one occurrence of each is `c1 * c2 * ... * ck`.
- After selecting one occurrence of each vowel, **arrange them in all possible orders**. The number of such arrangements is `k!` (factorial of the number of unique vowels).
- The final answer is the product of the number of ways to select the vowels and the number of ways to arrange them: `c1 * c2 * ... * ck * k!`.
- If there are no vowels in the string, the answer is `0`.

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string (for a single pass to count vowels).
- **Space Complexity:** `O(1)` (since the number of vowels is constant and we use a fixed-size map).

## Summary
- The approach works because each unique vowel must be selected exactly once, and each selection is independent.
- The total number of distinct strings is the product of the number of ways to pick each vowel and the number of ways to arrange them.
- **Corner case:** If there are no vowels in the string, the answer is `0`.

