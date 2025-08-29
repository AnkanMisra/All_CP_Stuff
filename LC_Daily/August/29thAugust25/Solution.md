
# Solution Explanation

## Intuition
Since **Alice goes first**, she will make moves on turns 1, 3, 5, etc., while Bob makes moves on turns 2, 4, 6, etc. For Alice to win, she must make the **last move**, which means the total number of flowers `x + y` must be **odd**.

## Approach
For `x + y` to be odd, we need **one number to be odd and the other to be even**:
- Count pairs where `x` is odd and `y` is even
- Count pairs where `x` is even and `y` is odd
- Sum these two counts

For a range `[1, k]`:
- **Odd numbers**: `(k + 1) / 2`
- **Even numbers**: `k / 2`

Therefore:
- **Odd x, Even y**: `((n + 1) / 2) * (m / 2)`
- **Even x, Odd y**: `(n / 2) * ((m + 1) / 2)`
- **Total**: `((n + 1) / 2) * (m / 2) + (n / 2) * ((m + 1) / 2)`

This simplifies to: `(long) n * m / 2`

## Complexity
- **Time Complexity**: `O(1)` - constant time calculation
- **Space Complexity**: `O(1)` - no extra space needed

## Summary
The key insight is that Alice wins when the total flowers is odd. By counting odd-even and even-odd pairs systematically, we get a simple formula. The solution handles large inputs efficiently with integer division and avoids overflow by using `long` type.
```java
class Solution {
    public long flowerGame(int n, int m) {
        long oddN = (n + 1) / 2;
        long evenN = n / 2;
        long oddM = (m + 1) / 2;
        long evenM = m / 2;
        return oddN * evenM + evenN * oddM;
    }
}
```
