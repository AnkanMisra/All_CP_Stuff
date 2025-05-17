# Solution Explanation

### Intuition

To compare two strings lexicographically without considering case, convert both strings to lowercase (or uppercase) and use the standard string comparison. This ensures that 'A' and 'a' are treated as equal, and the comparison is straightforward.

### Approach

- Read both input strings.
- Convert both strings to lowercase.
- Use the built-in string comparison method (`compareTo`) to compare them lexicographically.
- Print `-1` if the first string is less, `1` if the first string is greater, or `0` if they are equal.

### Code

```java
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.nextLine().toLowerCase();
    String s2 = sc.nextLine().toLowerCase();
    int cmp = s1.compareTo(s2);
    if (cmp < 0) {
      System.out.println(-1);
    } else if (cmp > 0) {
      System.out.println(1);
    } else {
      System.out.println(0);
    }
    sc.close();
  }
}
```

### Complexity

- **Time Complexity:** O(n), where n is the length of the strings.
- **Space Complexity:** O(n), for storing the lowercase versions of the strings.

### Summary

- Convert both strings to the same case to ignore case differences.
- Use standard string comparison to determine the lexicographical order.
- Output according to the problem's requirements.
