
# Solution Explanation

## Intuition
The key insight is to **maximize the number of matchings** by always pairing the weakest available player with the weakest available trainer who can train them. This way, stronger trainers are reserved for stronger players, ensuring that as many players as possible are matched.

## Approach
- **Sort** both the `players` and `trainers` arrays in non-decreasing order.
- Use two pointers: one for `players` and one for `trainers`.
- Iterate through both arrays:
  - If the current player's ability is **less than or equal to** the current trainer's capacity, match them and move both pointers forward.
  - If the current player's ability is **greater** than the current trainer's capacity, move only the trainer pointer forward to find a suitable trainer.
- Continue until either all players or all trainers have been considered.
- The total number of successful matches is the answer.

## Complexity
- Time Complexity: `O(n log n + m log m)` where `n` is the number of players and `m` is the number of trainers (for sorting both arrays).
- Space Complexity: `O(1)` (ignoring the space used for sorting, if in-place).

## Summary
- **Sorting** both arrays allows for efficient matching using a two-pointer technique.
- This approach ensures that each player is matched with the least capable trainer who can still train them, maximizing the total number of matches.
- The method is efficient and works well within the given constraints.

