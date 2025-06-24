# Solution Explanation

## Intuition
The problem is to remove exactly `k` characters from a string to obtain the lexicographically largest possible string, while maintaining the relative order of the remaining characters. The key insight is to use a greedy approach: always remove the smallest possible character from the left if it helps to make the string larger.

## Approach
1. **Monotonic Stack:**  
   - Use a stack (or deque) to build the result.
   - Iterate through each character in the string:
     - While the stack is not empty, there are still deletions left (`k > 0`), and the last character in the stack is less than the current character, pop the stack (remove the smaller character).
     - Push the current character onto the stack.
2. **Remove Extra Characters:**  
   - If there are still deletions left after the loop, remove characters from the end of the stack.
3. **Build the Result:**  
   - Convert the stack to a string to get the final answer.

## Complexity
- **Time Complexity:** O(n), where n is the length of the string (each character is pushed and popped at most once).
- **Space Complexity:** O(n), for the stack and the result.

## Summary
**By using a greedy monotonic stack approach, we can efficiently remove `k` characters to obtain the lexicographically largest string while maintaining the original order.**  
This method ensures optimality and efficiency for large input sizes.

```java
class Solution {
    public String maxSubseq(String s, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int n = s.length();

        for (char ch : s.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() < ch) {
                stack.removeLast(); 
                k--;
            }
            stack.addLast(ch);
        }

        // Remove extra characters from the end if needed
        while (k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
