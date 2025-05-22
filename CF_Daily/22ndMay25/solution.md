# Solution Explanation

### Intuition

The elephant can move 1, 2, 3, 4, or 5 positions forward in each step. To minimize the number of steps to reach position `x`, the elephant should take as many steps of length 5 as possible, and only use a smaller step if there is a remainder.

### Approach

- Divide `x` by 5 to get the number of full steps of length 5.
- If there is a remainder (`x % 5 != 0`), add one more step to cover the remaining distance.
- Print the total number of steps.

### Code

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int each_stesp = total / 5;
        if (total % 5 != 0) {
            each_stesp += 1;
        }
        System.out.println(each_stesp);
    }
}
```

### Complexity

- **Time Complexity:** O(1), as only a few arithmetic operations are performed.
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution uses integer division and checks for a remainder to compute the minimum number of steps.
- This approach is efficient and optimal for the given constraints.

