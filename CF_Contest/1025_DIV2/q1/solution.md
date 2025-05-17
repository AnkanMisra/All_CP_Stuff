# Solution Explanation

### Intuition

Each player reports whether they won at least one duel (1) or none (0). The duels are consecutive, and each duel has exactly one winner and one loser.  
We need to check if the reports can be consistent with the rules of the tournament, or if at least one player must be lying.

This is equivalent to checking if there is a possible sequence of duel outcomes that matches the given reports.

### Approach

- Use two boolean variables:
  - `b`: Is it possible that the previous player has not won any duels up to this point?
  - `c`: Is it possible that the previous player has won at least one duel up to this point?
- Initialize based on the first player's report.
- For each player from the second to the second-last:
  - Update the possible states (`b` and `c`) based on the current player's report and the previous states.
- For the last player, check if the final state matches their report.
- If a consistent sequence exists, print "NO" (no liar). Otherwise, print "YES" (at least one liar).

### Code

```java
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }
            boolean b, c;
            if (a[0] == 0) {
                b = false;
                c = true;
            } else {
                b = true;
                c = false;
            }
            for (int i = 1; i < n - 1 && (b || c); i++) {
                boolean nb = false;
                boolean nc = false;
                if (a[i] == 0) {
                    if (b) {
                        nc = true;
                    }
                } else {
                    if (c) {
                        nb = true;
                        nc = true;
                    }
                    if (b) {
                        nb = true;
                    }
                }
                b = nb;
                c = nc;
            }
            boolean ok = false;
            if (a[n - 1] == 0) {
                if (b) {
                    ok = true;
                }
            } else {
                if (c) {
                    ok = true;
                }
            }
            if (ok) {
                sb.append("NO\n");
            } else {
                sb.append("YES\n");
            }
        }
        System.out.print(sb.toString());
    }
}
```

### Complexity

- **Time Complexity:** O(n) per test case.
- **Space Complexity:** O(n) for storing the reports.

### Summary

- The solution simulates all possible win/loss sequences that match the reports.
- If at least one valid sequence exists, print "NO" (no liar); otherwise, print "YES" (at least one liar).
- This approach efficiently checks the consistency of the reports for each test case.
