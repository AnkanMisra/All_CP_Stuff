
# Solution Explanation

## Intuition
The key insight is that the **maximum LCM** of any three numbers less than or equal to `n` is usually achieved by picking the **largest possible numbers**. However, if these numbers are not coprime, their LCM may not be maximized, so we must consider a few of the largest candidates.

## Approach
- If `n < 3`, the answer is simply `n` (since we can't form a triplet).
- For larger `n`, the maximum LCM is generally among the largest three or four numbers less than or equal to `n`.
- If `n` is **odd**, the numbers `n`, `n-1`, and `n-2` are likely to be coprime, so their product gives the maximum LCM.
- If `n` is **even**:
  - If `n` is **divisible by 3**, then `n`, `n-1`, and `n-3` are not all coprime, so the best triplet is `n-1`, `n-2`, and `n-3`.
  - Otherwise, the triplet `n`, `n-1`, and `n-3` gives the maximum LCM.
- This approach works because the LCM of three numbers is maximized when the numbers are as large and as coprime as possible.

## Complexity
- **Time Complexity:** `O(1)` (constant time, as only a few arithmetic operations are performed)
- **Space Complexity:** `O(1)` (no extra space used)

## Summary
- The solution leverages the fact that the **largest numbers** close to `n` usually yield the **maximum LCM**, but checks for divisibility to avoid cases where the numbers are not coprime.
- This approach is efficient and handles all edge cases, including small values of `n` and cases where the largest numbers share common divisors.

