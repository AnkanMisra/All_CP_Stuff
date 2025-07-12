
# Solution Explanation

## Intuition
- The problem is a two-player game with different move types: Alice can set any `k` positions (subsequence) to zero, while Bob can set any `k` consecutive positions (substring) to one.
- **Alice wins** if she can turn the entire string to zeroes in a finite number of moves; otherwise, **Bob wins**.
- The key insight is to determine if Alice can always force a win, regardless of Bob's moves, given the initial string and the value of `k`.

## Approach
- **Count the number of ones** in the string (`ones`).
- If `ones <= k`, Alice can select all positions with ones in her first move and win immediately.
- If `2 * k > n`, Alice can always win in at most two moves, because any substring Bob can choose will overlap with Alice's next subsequence, allowing her to reset any ones Bob creates.
- In all other cases, Bob can always prevent Alice from clearing the string, so Bob wins.
- For each test case, check these conditions and print the winner accordingly.

## Complexity
- **Time Complexity:** `O(n)` per test case (where `n` is the length of the string)
- **Space Complexity:** `O(1)` (ignoring input storage)

## Summary
- **Alice wins** if the number of ones is at most `k`, or if `2 * k > n` (her subsequence is longer than half the string).
- **Bob wins** in all other cases, as he can always restore ones faster than Alice can clear them.
- The solution relies on understanding the difference between subsequence and substring operations and the impact of `k` relative to `n`.

