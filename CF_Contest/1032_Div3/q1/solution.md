# Solution Explanation

## Intuition
The problem asks for the minimum number of steps to visit all given points `x1, ..., xn` starting from `s` on the X-axis. Since movement is only one step at a time (+1 or -1), the distance between two points is simply their absolute difference. To visit a set of points `x1, ..., xn`, we must cover the entire range from the minimum `min(x_i)` to the maximum `max(x_i)` of these points.

The optimal strategy involves moving from `s` to one end of the required range (either `min(x_i)` or `max(x_i)`) and then traversing the entire range to the other end.

## Approach
1.  **Find Minimum and Maximum Required Points**: Iterate through the given `x_i` points to find the overall minimum point (`min_x`) and maximum point (`max_x`) that must be visited.
2.  **Calculate Total Range Length**: The distance to cover all points `x_i` is simply `max_x - min_x`. This is the span of the segment that *must* be traversed.
3.  **Calculate Initial Travel to Range**: We start at `s`. We need to travel from `s` to either `min_x` or `max_x` to "hook" onto the segment containing all points. The minimum steps to reach either end is `min(abs(s - min_x), abs(s - max_x))`.
4.  **Calculate Total Steps**: The total minimum steps will be the length of the required range plus the minimum steps to reach one end of that range from the starting point `s`.
    *   `Total Steps = (max_x - min_x) + min(abs(s - min_x), abs(s - max_x))`

## Complexity
-   **Time Complexity**: O(N) per test case, where N is the number of points `x_i`, as we iterate through them once to find the minimum and maximum.
-   **Space Complexity**: O(1) per test case, as only a few variables are used.

## Summary
By finding the minimum and maximum points in the required set and calculating the shortest path from the starting point `s` to either extreme, then covering the entire range, the solution correctly determines the minimum total steps required to visit all specified points.

```java
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in); // Use Scanner for input
        
        // Check if there's any input to read. Important for competitive programming to prevent EOF issues.
        if (!a.hasNextInt()) {
            return;
        }
        
        int testcases = a.nextInt(); // Read the number of test cases
        StringBuilder c = new StringBuilder(); // Use StringBuilder for efficient output concatenation
        
        while (testcases-- > 0) { // Loop through each test case
            int d = a.nextInt(); // Read 'n' - number of positions to visit
            int e = a.nextInt(); // Read 's' - starting position
            
            int f = Integer.MAX_VALUE; // 'f' will store the minimum x_i (min_x)
            int g = Integer.MIN_VALUE; // 'g' will store the maximum x_i (max_x)
            
            // Read all x_i points and find min_x and max_x
            for (int h = 0; h < d; h++) {
                int i = a.nextInt(); // Read current x_i
                if (i < f){
                    f = i; // Update min_x
                }
                if (i > g){
                    g = i; // Update max_x
                } 
            }
            
            // Calculate the length of the range that must be covered
            // This is the distance from min_x to max_x
            int j = g - f; 
            
            // Calculate the minimum steps needed to reach one end of the range [min_x, max_x] from 's'
            // We can go from 's' to min_x or from 's' to max_x, choose the shorter path.
            int k = Math.min(Math.abs(e - f), Math.abs(e - g));
            
            // Total minimum steps = (distance to cover the range) + (distance to reach the range from 's')
            int l = j + k;
            
            // Append the result for the current test case to the StringBuilder
            c.append(l).append('\n');
        }
       
       String result = c.toString(); // Convert StringBuilder content to String
       System.out.println(result); // Print the final result for all test cases
    }
}
```
