
# Solution Explanation

## Intuition
The key insight is to use a **prefix sum approach** with the difference between vowels and consonants. For any contiguous substring to be balanced, the **difference between vowels and consonants must be zero**. We can transform this into finding subarrays where the prefix sum difference returns to the same value.

## Approach
We'll use a **sliding window technique** combined with **prefix sum counting**:

1. **Transform the problem**: For each character, assign `+1` for vowels and `-1` for consonants
2. **Calculate prefix sums**: As we iterate through the concatenated array, maintain a running sum
3. **Count balanced substrings**: Use a hash map to count occurrences of each prefix sum value
4. **Apply the formula**: For each prefix sum that appears `k` times, it contributes `k*(k-1)/2` balanced substrings

## Algorithm
1. Create a function to check if a character is a vowel (`a`, `e`, `i`, `o`, `u`)
2. Initialize a hash map to store prefix sum frequencies
3. Set initial prefix sum to `0` and add it to the map with frequency `1`
4. For each string in the array:
   - For each character in the string:
     - Add `+1` if vowel, `-1` if consonant to the prefix sum
     - If this prefix sum exists in the map, add its frequency to the result
     - Increment the frequency of this prefix sum in the map
5. Return the total count

## Complexity
- **Time Complexity**: `O(N)` where `N` is the total number of characters across all strings
- **Space Complexity**: `O(N)` for the hash map storing prefix sum frequencies

## Summary
This approach works because **two positions with the same prefix sum difference indicate a balanced substring between them**. The hash map efficiently tracks how many times each prefix sum has occurred, allowing us to count all possible balanced substrings in a single pass. **Corner cases** include empty strings (handled by initial prefix sum of 0) and arrays with no balanced substrings (result will be 0).

