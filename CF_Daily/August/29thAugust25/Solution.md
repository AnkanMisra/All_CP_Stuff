
# Solution Explanation

## Intuition
The key insight is to use a **mathematical formula** instead of simulating each increment. We can define a function `f(n)` that represents the **total number of digit changes** needed to count from `0` to `n-1`. Then the answer for range `[l, r]` is simply `f(r) - f(l)`.

When incrementing a number, the **number of digits that change depends on carries**:
- `8 + 1 = 9`: only 1 digit changes
- `9 + 1 = 10`: 2 digits change (carry occurs)
- `99 + 1 = 100`: 3 digits change (multiple carries)
- `999 + 1 = 1000`: 4 digits change

## Approach
1. **Define cumulative function**: `f(n) = n + sum of floor(n/10^k)` for all `k >= 1`
2. **Mathematical insight**: Each term `floor(n/10^k)` counts how many times a carry occurs at the `k`-th decimal place
3. **Range calculation**: The answer for `[l, r]` is `f(r) - f(l)`
4. **Efficient computation**: Calculate `f(n)` by iterating through powers of 10 until they exceed `n`

## Algorithm
1. Define function `calc(n)` that computes `f(n)`:
   - Initialize `res = n` (base digit changes)
   - For each `div = 10, 100, 1000, ...` while `div <= n`:
     - Add `n / div` to `res` (count carries at this decimal place)
   - Return `res`
2. For each test case with range `[l, r]`:
   - Return `calc(r) - calc(l)`

## Complexity
- **Time Complexity**: `O(log r)` - we iterate through powers of 10 up to `r`
- **Space Complexity**: `O(1)` - only using constant extra space

## Summary
This approach works by **recognizing that digit changes follow a mathematical pattern** based on decimal carries. Instead of simulating each increment, we use a closed-form formula that counts all digit changes efficiently. The function `f(n) = n + sum of floor(n/10^k)` captures exactly how many digits change when counting from `0` to `n-1`, making the solution both elegant and optimal for large ranges up to `10^9`.
```java
/*
 * author  : Ankan Misra
 * created : 2025-08-29 at 19:22:41 PM IST
 * editor  : nvim
 * blame the bugs on me, not the editor
 */

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = fr.nextInt();
        while (t-- > 0) {
            long l = fr.nextLong();
            long r = fr.nextLong();
            out.println(calc(r) - calc(l));
        }
        out.flush();
    }
    private static long calc(long n) {
        long res = n;
        for (long div = 10; div <= n; div *= 10) {
            res += n / div;
        }
        return res;
    }

    // Fast input reader
    private static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    }
}
```
