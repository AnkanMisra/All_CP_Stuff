# Solution Explanation

### Intuition

The problem is to rearrange the numbers in a sum (given as a string with numbers 1, 2, 3 separated by '+') so that the numbers appear in non-decreasing order. This makes it easier for Xenia to calculate the sum.

### Approach

- Split the input string by the '+' character to extract all the numbers.
- Convert the split strings to integers and store them in a list or array.
- Sort the list of numbers in non-decreasing order.
- Join the sorted numbers back into a string, separated by '+'.

### Code

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] parts = s.split("\\+");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) sb.append("+");
            sb.append(nums[i]);
        }
        System.out.println(sb.toString());
    }
}
```

### Complexity

- **Time Complexity:** O(n log n), where n is the number of numbers in the sum (due to sorting).
- **Space Complexity:** O(n), for storing the numbers.

### Summary

- The solution splits the input string, sorts the numbers, and joins them back with '+' to produce the required output.
- This approach is efficient and straightforward for the given constraints.
