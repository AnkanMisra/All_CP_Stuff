# Solution Explanation

## Intuition

We are given:
- The total sum of the array must be `m`.
- Every segment of length `p` must sum to `q`.

If the array can be divided into **exactly** `n / p` non-overlapping segments of length `p` (i.e., `n % p == 0`), then the sum of the entire array is forced to be `(n / p) * q`.  
If `m` is not equal to this value, it is **impossible** to construct such an array.

If `n % p != 0`, then the segments overlap, and it is always possible to construct such an array (since the system of equations is underdetermined and has integer solutions).

---

## Approach

1. For each test case, read `n`, `m`, `p`, and `q`.
2. If `n % p == 0` and `m != (n / p) * q`, output "NO".
3. Otherwise, output "YES".

---

## Algorithm

1. Read the number of test cases `t`.
2. For each test case:
    - Read `n`, `m`, `p`, `q`.
    - If `n % p == 0` and `m != (n / p) * q`, append "NO" to the output.
    - Otherwise, append "YES" to the output.
3. Print the results.

---

## Code

```java
import java.util.*;
public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    while (t != 0) {
      int n = sc.nextInt();
      int m = sc.nextInt();
      int p = sc.nextInt();
      int q = sc.nextInt();
      if (n % p == 0 && m != (n / p) * q) {
        sb.append("NO\n");
      } else {
        sb.append("YES\n");
      }
      t--;
    }
    System.out.print(sb);
  }
}
```

---

## Complexity Analysis

- **Time Complexity:**  
  \(O(t)\), where \(t\) is the number of test cases. Each test case is processed in constant time.

- **Space Complexity:**  
  \(O(1)\) extra space (excluding input and output storage).

---

## Summary

- If `n` is divisible by `p`, the total sum must be exactly `(n / p) * q`.
- Otherwise, a solution always exists.
- The solution is efficient and works within the given constraints.
