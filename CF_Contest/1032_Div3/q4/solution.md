
# Solution Explanation

## Intuition
We are given two arrays, a and b, each of length n, containing all integers from 1 to 2n exactly once between them. The goal is to perform a sequence of allowed operations to make both arrays strictly increasing and ensure that a[i] < b[i] for all i.

The key idea is to construct the arrays so that after all operations:
- a = [1, 3, 5, ..., 2n-1] (all odd numbers in increasing order)
- b = [2, 4, 6, ..., 2n] (all even numbers in increasing order)
This guarantees both the strictly increasing property and a[i] < b[i] for all i.

To achieve this, for each position i (from 0 to n-1), we:
1. Find the position of the next required odd number (2i+1) in either a or b, and move it to a[i] (using swaps within a or a swap between a and b).
2. Find the position of the next required even number (2i+2) in either a or b, and move it to b[i] (using swaps within b or a swap between a and b).

## Approach
1. For each position i from 0 to n-1:
    - Find where the next required odd number (2i+1) is (in a or b, from index i onwards).
        - If it's in b, swap a and b at that position.
        - Move it to position i in a using adjacent swaps.
    - Find where the next required even number (2i+2) is (in a or b, from index i onwards).
        - If it's in a, swap a and b at that position.
        - Move it to position i in b using adjacent swaps.
2. Record each operation as specified (type and index).
3. Output the sequence of operations.

## Complexity
- **Time Complexity**: O(n^2) per test case, since for each of the n positions, we may need up to n swaps.
- **Space Complexity**: O(n) for storing the arrays and the list of operations.

## Summary
The solution greedily places the correct odd and even numbers in their target positions in a and b, using the allowed operations. By always moving the next required number to its correct place, we ensure the final arrays are strictly increasing and satisfy a[i] < b[i]. The number of operations is always within the allowed limit due to the small value of n.

```java
import java.util.*;
public class Solution {
    public static void main(String[] x) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        StringBuilder y = new StringBuilder();
        while (testcases-- > 0) {
            int c = a.nextInt();
            int[] d = new int[c]; // array a
            int[] e = new int[c]; // array b
            for (int i = 0; i < c; i++){
                d[i] = a.nextInt();
            }
            for (int i = 0; i < c; i++){
                e[i] = a.nextInt();
            }
            ArrayList<int[]> f = new ArrayList<>(); // list of operations
            for (int i = 0; i < c; i++) {
                int g = 2 * i + 1; // next required odd number
                int h = -1;
                boolean j = true;
                // Find g in a or b (from index i onwards)
                for (int k = i; k < c; k++) {
                    if (d[k] == g) {
                        h = k;
                        j = true;
                        break;
                    }
                    if (e[k] == g) {
                        h = k;
                        j = false;
                        break;
                    }
                }
                // If g is in b, swap a and b at position h
                if (!j) {
                    f.add(new int[]{3, h + 1});
                    int t = d[h];
                    d[h] = e[h];
                    e[h] = t;
                }
                // Move g to position i in a using adjacent swaps
                while (h > i) {
                    f.add(new int[]{1, h});
                    int t = d[h];
                    d[h] = d[h - 1];
                    d[h - 1] = t;
                    h--;
                }
                int l = 2 * (i + 1); // next required even number
                int m = -1;
                boolean n = true;
                // Find l in b or a (from index i onwards)
                for (int k = i; k < c; k++) {
                    if (e[k] == l) {
                        m = k;
                        n = false;
                        break;
                    }
                    if (d[k] == l) {
                        m = k;
                        n = true;
                        break;
                    }
                }
                // If l is in a, swap a and b at position m
                if (n) {
                    f.add(new int[]{3, m + 1});
                    int t = d[m];
                    d[m] = e[m];
                    e[m] = t;
                }
                // Move l to position i in b using adjacent swaps
                while (m > i) {
                    f.add(new int[]{2, m});
                    int t = e[m];
                    e[m] = e[m - 1];
                    e[m - 1] = t;
                    m--;
                }
            }
            y.append(f.size()).append('\n');
            for (int[] q : f){
                y.append(q[0]).append(' ').append(q[1]).append('\n');
            }
        }
        String result = y.toString();
        System.out.println(result);
    }
}
