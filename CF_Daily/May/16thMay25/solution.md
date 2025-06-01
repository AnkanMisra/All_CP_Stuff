
# Solution Explanation

To cover a rectangle of size `n × m` with square flagstones of size `a × a`, you need to determine how many flagstones are required along each dimension:

- Along the length (`n`), you need `ceil(n / a)` flagstones.
- Along the width (`m`), you need `ceil(m / a)` flagstones.

The total number of flagstones is the product of these two numbers.

Since the numbers can be very large, use integer arithmetic to compute the ceiling:
- `ceil(x / y) = (x + y - 1) / y`

### Steps

1. Read the values of `n`, `m`, and `a`.
2. Compute the number of flagstones needed along each dimension using the formula above.
3. Multiply the two results to get the total number of flagstones.
4. Output the result.

### Complexity

- **Time Complexity:** O(1)
- **Space Complexity:** O(1)

### Java Code

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long a = sc.nextLong();
        long x = (n + a - 1) / a;
        long y = (m + a - 1) / a;
        System.out.println(x * y);
    }
}
```
