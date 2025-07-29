
# Solution Explanation

## Intuition
The key insight is to **identify characters that appear multiple times** in the string and then **calculate the ASCII sum of all characters strictly between their first and last occurrences**. We need to track character frequencies and positions to determine which characters qualify for ASCII sum calculation.

## Approach
1. **Count character frequencies** using a `HashMap` to identify characters that appear more than once
2. **For each character with frequency > 1:**
   - Find the **first occurrence** using `indexOf()`
   - Find the **last occurrence** using `lastIndexOf()`
   - **Calculate ASCII sum** of all characters between these positions (exclusive)
   - Add the sum to result list **only if there are characters between first and last occurrence**
3. **Return the list** of all non-zero ASCII sums

## Algorithm
1. Create a frequency map of all characters in the string
2. Initialize an empty result list
3. For each character in the frequency map:
   - If frequency > 1:
     - Get first index and last index of the character
     - If there are characters between first and last index:
       - Calculate sum of ASCII values of characters in between
       - Add sum to result list
4. Return the result list

## Complexity
- **Time Complexity:** `O(n * k)` where `n` is the length of string and `k` is the number of unique characters that appear more than once
- **Space Complexity:** `O(k)` for the frequency map and result list, where `k` is the number of unique characters

## Summary
This approach works by **leveraging character frequency counting** and **position-based range calculation**. The algorithm efficiently identifies qualifying characters and computes ASCII sums for the ranges between their boundary occurrences. **Key consideration:** Only characters with actual content between first and last occurrences contribute to the result, ensuring no zero sums are included.

