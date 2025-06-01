# Solution Explanation

### Intuition

The problem asks us to determine the gender of a user based on the number of distinct characters in their username. If the number of distinct characters is even, print `"CHAT WITH HER!"` (female). If odd, print `"IGNORE HIM!"` (male).

### Approach

- Use a boolean array of size 26 to track which lowercase English letters have appeared in the username.
- Iterate through each character in the string, and for each new character, mark it as seen and increment a counter.
- After processing the string, check if the count of distinct characters is even or odd.
- Print the corresponding message based on the parity of the count.

### Code

```java
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        boolean[] seen = new boolean[26];
        int count = 0;
        for (char c : s.toCharArray()) {
            if (!seen[c - 'a']) {
                seen[c - 'a'] = true;
                count++;
            }
        }
        if (count % 2 == 0) {
            System.out.println("CHAT WITH HER!");
        } else {
            System.out.println("IGNORE HIM!");
        }
    }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the length of the username.
- **Space Complexity:** O(1), since the boolean array size is constant (26).

### Summary

- The solution efficiently counts the number of distinct characters in the username.
- It prints the correct message based on whether the count is even or odd.
