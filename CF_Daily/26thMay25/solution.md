# Solution Explanation

### Intuition

The task is to capitalize the first letter of a given word, leaving the rest of the word unchanged. This is a simple string manipulation problem.

### Approach

- Read the input word.
- If the word is empty, print an empty string and return.
- Otherwise, convert the first character to uppercase and concatenate it with the rest of the word (unchanged).
- Print the result.

### Code

```java
import java.util.*;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        if (word.length() == 0) {
            System.out.println("");
            return;
        }
        String capitalized = word.substring(0, 1).toUpperCase() + word.substring(1);
        System.out.println(capitalized);
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the length of the word (due to string operations).
- **Space Complexity:** O(n), for the new string.

### Summary

- The solution capitalizes only the first letter and leaves the rest unchanged, as required.
- Handles the edge case of an empty string.
