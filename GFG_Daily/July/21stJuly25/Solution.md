
# Solution Explanation

## Intuition
The key insight is that directly checking all pairs for coprimality is too slow for large arrays. Instead, we use **number theory** and the **Möbius function** to efficiently count the number of coprime pairs using inclusion-exclusion principles.

## Approach
- **Count the frequency** of each number in the array.
- For each integer `d` up to the maximum value in the array, **count how many numbers are divisible by `d`**.
- Use the **Möbius function** to apply the inclusion-exclusion principle: for each `d`, count the number of pairs where both numbers are divisible by `d`, and use the Möbius function to add or subtract these counts appropriately.
- The sum over all `d` gives the total number of coprime pairs.

## Algorithm
1. **Frequency Array:** Build a frequency array for all numbers in the input.
2. **Divisibility Count:** For each `d` from `1` to `MAX`, count how many numbers in the array are divisible by `d`.
3. **Möbius Function:** Compute the Möbius function for all numbers up to `MAX` using a sieve.
4. **Inclusion-Exclusion:** For each `d`, if there are at least two numbers divisible by `d`, count the number of unordered pairs and multiply by the Möbius value for `d`. Sum these for all `d`.
5. **Result:** The final sum is the number of coprime pairs.

## Complexity
- **Time Complexity:** `O(MAX * log MAX)` (where `MAX` is the largest possible value in the array, due to the sieve and divisor counting)
- **Space Complexity:** `O(MAX)`

## Summary
This approach leverages **number theory** and the **Möbius function** to efficiently count coprime pairs without checking every pair directly. The use of inclusion-exclusion ensures that only pairs with `gcd = 1` are counted, making the solution both fast and scalable for large input sizes.

