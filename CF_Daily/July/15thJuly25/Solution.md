# Solution Explanation

## Intuition
The game outcome depends only on the prime‐factor structure of the starting number `n`.
Ashishgup (the first player) loses **only** in very specific cases; in every other
situation he can force a win.

## Approach
1. **Trivial cases**
   * `n = 1` – no move possible → **FastestFinger wins**.
   * `n = 2` – subtract 1 → `n = 1` → **Ashishgup wins**.
2. **Odd `n` ( ≥ 3 )**
   * `n` itself is an odd divisor > 1. Ashishgup divides by `n`,
     leaving `1` to the opponent → **Ashishgup wins**.
3. **Even `n` ( ≥ 4 )**  
   Write `n = 2^k · m` where `m` is odd.
   * If `m = 1` (i.e. `n` is a power of two) **FastestFinger wins**.  
     The only legal move is subtracting 1, after which the opponent
     faces an odd number and wins.
   * If `k = 1` (i.e. `n = 2 · m`, exactly one factor 2) **and** `m` is prime,  
     then **FastestFinger wins**.  
     Any division removes the only odd divisor and produces a power of two for
     the opponent, while subtracting 1 hands an odd number to the opponent.
   * **All remaining even numbers** allow Ashishgup to divide by a proper odd
     divisor so that the position handed to FastestFinger is either odd or has
     more than one factor 2, both of which are winning for Ashishgup.

Therefore Ashishgup loses **only when**
* `n = 1`,
* `n` is a power of two (`n = 2^k`, `k ≥ 1`), or
* `n = 2 · p` where `p` is an **odd prime**.
In all other cases he wins.

## Algorithm
For each test case:
1. If `n = 1` → answer `FastestFinger`.
2. Else if `n = 2` → answer `Ashishgup`.
3. Else if `n` is odd → answer `Ashishgup`.
4. Else (`n` is even):
   * If `n` is a power of two → `FastestFinger`.
   * Else if `(n / 2)` is odd **and** prime → `FastestFinger`.
   * Otherwise → `Ashishgup`.

## Complexity
* **Time:** `O(√n)` per test case (only for the primality check of `n / 2`).
* **Space:** `O(1)`.

## Summary
The game boils down to recognising a small set of losing starting positions
for the first player. Checking these conditions is fast, so the solution works
comfortably within the limits. 