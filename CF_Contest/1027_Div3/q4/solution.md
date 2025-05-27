# Solution Explanation  : Problem D

# Intuition
You want to destroy all monsters by selecting a minimum-area rectangle after optionally moving one monster once.  
The best rectangle initially covers all monsters. Moving one monster can potentially reduce the rectangle’s area by “pulling in” one edge.

---

# Approach
- Find minimum and maximum x and y coordinates of all monsters.
- Count how many monsters lie exactly on these minimum or maximum boundaries.
- Find the second smallest and second largest x and y to know alternative edges after moving a monster.
- For each monster on a boundary (minimum or maximum x or y), try “moving” it inside by adjusting edges to second smallest/largest coordinates.
- Calculate new rectangle area for each such move and pick the minimum area.
- If only one monster exists, area = 1.
- Output the minimum area found.

---

# Code
```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int b = a.nextInt();
        StringBuilder c = new StringBuilder();
        for (int d = 0; d < b; d++) {
            int e = a.nextInt();
            long[] f = new long[e];
            long[] g = new long[e];
            for (int h = 0; h < e; h++) {
                f[h] = a.nextLong();
                g[h] = a.nextLong();
            }
            if (e == 1) {
                c.append(1);
                c.append('\n');
            } else {
                long i = Long.MAX_VALUE;
                long j = Long.MIN_VALUE;
                for (int h = 0; h < e; h++) {
                    long temp = f[h];
                    if (temp < i) {
                        i = temp;
                    }
                    if (temp > j) {
                        j = temp;
                    }
                }
                int k = 0;
                int l = 0;
                for (int h = 0; h < e; h++) {
                    long temp = f[h];
                    if (temp == i) {
                        k++;
                    }
                    if (temp == j) {
                        l++;
                    }
                }
                long m = Long.MAX_VALUE;
                long o = Long.MIN_VALUE;
                for (int h = 0; h < e; h++) {
                    long temp = f[h];
                    if (temp > i && temp < m) {
                        m = temp;
                    }
                    if (temp < j && temp > o) {
                        o = temp;
                    }
                }
                long q = Long.MAX_VALUE;
                long r = Long.MIN_VALUE;
                for (int h = 0; h < e; h++) {
                    long temp = g[h];
                    if (temp < q) {
                        q = temp;
                    }
                    if (temp > r) {
                        r = temp;
                    }
                }
                int s = 0;
                int t = 0;
                for (int h = 0; h < e; h++) {
                    long temp = g[h];
                    if (temp == q) {
                        s++;
                    }
                    if (temp == r) {
                        t++;
                    }
                }
                long u = Long.MAX_VALUE;
                long v = Long.MIN_VALUE;
                for (int h = 0; h < e; h++) {
                    long temp = g[h];
                    if (temp > q && temp < u) {
                        u = temp;
                    }
                    if (temp < r && temp > v) {
                        v = temp;
                    }
                }
                long w = j - i + 1;
                long x = r - q + 1;
                long y = w * x;
                long z = e - 1;
                long A = y;
                for (int h = 0; h < e; h++) {
                    long C;
                    if (f[h] == i && k == 1) {
                        C = m;
                    } else {
                        C = i;
                    }
                    long D;
                    if (f[h] == j && l == 1) {
                        D = o;
                    } else {
                        D = j;
                    }
                    long E;
                    if (g[h] == q && s == 1) {
                        E = u;
                    } else {
                        E = q;
                    }
                    long F;
                    if (g[h] == r && t == 1) {
                        F = v;
                    } else {
                        F = r;
                    }
                    long G = D - C + 1;
                    long H = F - E + 1;
                    long I = G * H;
                    if (I == z) {
                        long J = Math.min(G, H);
                        I += J;
                    }
                    if (I < A) {
                        A = I;
                    }
                }
                c.append(A);
                c.append('\n');
            }
        }
        System.out.print(c.toString());
    }
}
```
---

# Complexity
- Time: O(n) per test case (single pass for min/max and counts).  
- Space: O(n) for storing coordinates.

---

# Summary
The solution finds the smallest rectangle containing all monsters, then attempts to reduce area by virtually “moving” one monster from a boundary inside the rectangle, adjusting the boundaries accordingly. This method efficiently explores all possible minimal areas after one move.
