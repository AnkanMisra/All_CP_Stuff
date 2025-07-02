# Solution Explanation

## Intuition
The key insight is to analyze the **modular arithmetic constraint** `a + b ≡ 3 (mod 4)`. The integers from `0` to `n-1` can be **categorized by their remainders** when divided by 4, and only specific pairs can satisfy the constraint. The game outcome depends on whether we can form **complete pairs** or if there are **unpaired numbers** that give Alice an immediate winning move.

## Approach
**Step 1:** Categorize all numbers `0` to `n-1` by their remainder when divided by 4:
- Numbers ≡ 0 (mod 4): 0, 4, 8, ...
- Numbers ≡ 1 (mod 4): 1, 5, 9, ...  
- Numbers ≡ 2 (mod 4): 2, 6, 10, ...
- Numbers ≡ 3 (mod 4): 3, 7, 11, ...

**Step 2:** Determine which pairs satisfy `a + b ≡ 3 (mod 4)`:
- 0 + 3 ≡ 3 (mod 4) ✓
- 1 + 2 ≡ 3 (mod 4) ✓
- Only **(0,3)** and **(1,2)** pairs are valid

**Step 3:** Analyze the distribution based on `n mod 4`:
- If `n ≡ 0 (mod 4)`: **Equal count** of all remainder classes → All numbers can be perfectly paired
- If `n ≢ 0 (mod 4)`: **Unequal count** → At least one remainder class has extra numbers

**Step 4:** Apply optimal strategy:
- If all numbers can be paired: Bob can always respond to Alice's moves until Alice runs out → **Bob wins**
- If there are unpaired numbers: Alice can pick an unpaired number, Bob cannot respond → **Alice wins immediately**

## Algorithm
1. Read the value of `n`
2. Check if `n % 4 == 0`
3. If yes, output **"Bob"**
4. If no, output **"Alice"**

## Complexity
- **Time complexity:** `O(1)` per test case
- **Space complexity:** `O(1)`

## Summary
The solution works because when `n` is **divisible by 4**, we have exactly equal numbers in each remainder class (mod 4), allowing perfect pairing. Bob can always respond to Alice's moves until the board is empty, making Alice the first unable to move. When `n` is **not divisible by 4**, there's always at least one remainder class with extra numbers, giving Alice an immediate winning move by choosing an unpaired number.

