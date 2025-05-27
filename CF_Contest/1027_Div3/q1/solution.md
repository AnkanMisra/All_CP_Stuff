# Solution Explanation

### Intuition

The task is to determine if a given integer is a perfect square. If it is, print `0` followed by its square root. Otherwise, print `-1`. The problem is repeated for multiple test cases.

The idea is based on the mathematical property that a number `n` is a perfect square if and only if there exists an integer `x` such that `x * x = n`.

### Approach

- Read the number of test cases `b`.
- For each test case:
  - Read the input number as a string `c`.
  - Convert the string to an integer `d`.
  - Compute the integer square root `e = (int) Math.sqrt(d)`.
  - If `e * e` is not equal to `d`, then `d` is **not** a perfect square → print `-1`.
  - Otherwise, print `"0 "` followed by the square root value `e`.

### Code

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        while (b-- > 0) {
            String c = a.next();
            int d = Integer.parseInt(c);
            int e = (int) Math.sqrt(d);
            if (e * e != d) {
                System.out.println(-1);
            } else {
                System.out.println("0 " + e);
            }
        }
    }
}
```

### Complexity

- **Time Complexity:**  
  - `O(1)` per test case for:
    - `Math.sqrt(d)` which is a constant-time operation.
    - Arithmetic and conditional operations.
  - So, for `T` test cases, overall time complexity is **O(T)**.

- **Space Complexity:**  
  - **O(1)** — Only a constant amount of extra space is used (for variables like `c`, `d`, `e`).

### Summary

- The program checks whether an integer is a perfect square using integer square root and multiplication.
- For each test case:
  - If the number is a perfect square, it prints `"0"` and the square root.
  - Otherwise, it prints `-1`.
- The solution is simple, efficient, and well-suited for competitive programming.
- It handles edge cases (like non-square numbers) correctly and uses minimal space.

