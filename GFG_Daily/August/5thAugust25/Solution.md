
# Solution Explanation

## Intuition
The key insight is to use a **two-pointer approach** to check if the string is a palindrome without actually creating a new processed string. We can skip non-alphanumeric characters and compare characters from both ends while converting them to lowercase on the fly.

## Approach
Use two pointers, one starting from the **beginning** (`l`) and one from the **end** (`r`) of the string:

1. **Skip non-alphanumeric characters** from the left pointer by moving it forward until we find a valid character or it meets the right pointer
2. **Skip non-alphanumeric characters** from the right pointer by moving it backward until we find a valid character or it meets the left pointer
3. **Compare the characters** at both pointers after converting them to lowercase
4. If characters don't match, return `false`
5. **Move both pointers** inward and repeat until they meet
6. If we successfully compare all valid characters, return `true`

## Complexity
- **Time Complexity:** `O(n)` where `n` is the length of the string, as we visit each character at most once
- **Space Complexity:** `O(1)` as we only use two pointer variables

## Summary
This approach efficiently checks for palindrome by **avoiding extra space** for string processing and using the two-pointer technique. The algorithm handles **mixed case letters, spaces, and special characters** by skipping invalid characters and normalizing case during comparison. The key advantage is that it works **in-place** without creating additional strings.

