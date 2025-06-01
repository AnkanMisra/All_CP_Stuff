# Solution Explanation

### Intuition

We need to simulate the growth of Limak's and Bob's weights year by year until Limak's weight becomes strictly greater than Bob's. We count the number of years this takes.

### Approach

- Initialize a counter for years to 0.
- While Limak's weight is less than or equal to Bob's weight:
  - Triple Limak's weight.
  - Double Bob's weight.
  - Increment the year counter.
- Return the year counter.

### Code

```java
import java.util.Scanner;

public class solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int years = 0;
        while (a <= b) {
            a *= 3;
            b *= 2;
            years++;
        }
        System.out.println(years);
    }
}
```

### Complexity

- **Time Complexity:** O(log b), since the weights grow exponentially and the loop runs until Limak's weight surpasses Bob's.
- **Space Complexity:** O(1), as only a few variables are used.

### Summary

- The solution simulates the weight changes year by year.
- It stops when Limak's weight is strictly greater than Bob's.
- The approach is efficient for the given constraints.
