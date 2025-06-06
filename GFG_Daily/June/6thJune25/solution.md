# Solution Explanation

## Intuition
The Rabin-Karp algorithm is an efficient string searching method that uses hashing to find all occurrences of a pattern in a text. By comparing hash values of the pattern and substrings of the text, we can quickly check for matches and only do a direct comparison when the hashes match, reducing unnecessary checks.

## Approach
- Compute the hash value of the pattern and the hash value of the first window of the text with the same length as the pattern.
- Slide the window over the text one character at a time, updating the hash value efficiently using a rolling hash technique.
- If the hash of the current window matches the pattern's hash, do a direct comparison to confirm the match (to avoid false positives due to hash collisions).
- Record the starting index (1-based) of each match.

## Algorithm
1. Choose a base (e.g., 26 for lowercase letters) and a large prime modulus to minimize hash collisions.
2. Precompute the highest power of the base needed for rolling hash updates.
3. Calculate the hash of the pattern and the initial window in the text.
4. For each position in the text:
   - If the hashes match, compare the actual strings to confirm.
   - Update the hash for the next window using the rolling hash formula.
5. Return the list of all starting positions (1-based) where the pattern occurs.

## Complexity
- Time Complexity: O(n + m), where n is the length of the text and m is the length of the pattern. Hashing and rolling updates are constant time per step.
- Space Complexity: O(1) additional space, not counting the output list.

## Summary
The Rabin-Karp algorithm efficiently finds all occurrences of a pattern in a text by leveraging rolling hashes, making it suitable for large texts and patterns. It reduces the number of direct string comparisons by quickly filtering out non-matching substrings using hash values.
