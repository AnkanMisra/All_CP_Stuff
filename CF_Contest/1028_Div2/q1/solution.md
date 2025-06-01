# Solution Explanation

### Intuition

Both players play optimally. The key is to realize that each player will try to eliminate the opponent's knight as soon as possible, because the knight is the only way to directly attack the other player. The winner is determined by which side can eliminate the other's HP (either the player or their knight) first.

### Approach

- For Gellyfish to win, Gellyfish's knight must survive long enough to either:
  - Reduce Flower's HP to 0 before Flower's knight can reduce Gellyfish's HP to 0, or
  - Eliminate Flower's knight before Flower's knight can eliminate Gellyfish or Gellyfish's knight.
- The minimum of (Gellyfish's HP, Gellyfish's knight's HP) represents the number of rounds Gellyfish can survive.
- The minimum of (Flower's HP, Flower's knight's HP) represents the number of rounds Flower can survive.
- If Gellyfish can survive at least as many rounds as Flower, Gellyfish wins; otherwise, Flower wins.

### Code

```java
import java.util.*;
     
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        while (testcases != 0) {
            testcases--;
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt(), d = sc.nextInt();
            if (Math.min(a, c) >= Math.min(b, d)) {
                System.out.println("Gellyfish");
            } else {
                System.out.println("Flower");
            }
        }
    }
}
```

### Complexity

- **Time Complexity:** O(1) per test case.
- **Space Complexity:** O(1).

### Summary

- The solution compares the minimum survivability of both sides.
- If Gellyfish can survive at least as long as Flower, Gellyfish wins; otherwise, Flower wins.
- This approach is efficient and optimal for the given constraints.
