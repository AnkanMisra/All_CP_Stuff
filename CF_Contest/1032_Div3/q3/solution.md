# Solution Explanation

## Intuition
We are given a matrix of size n by m, and we can choose any row r and any column c, then decrease all elements in that row and column by one (with the intersection cell only decreased once). The goal is to minimize the maximum value in the matrix after this operation.

The key insight is that the only way to reduce the maximum value in the matrix is to "cover" all occurrences of the maximum value with a single operation. If all the maximum values can be covered by a single row and column, then the maximum value in the matrix can be reduced by one. Otherwise, at least one occurrence of the maximum value will remain, and the answer will be the original maximum value.

Let's break down what it means to "cover" all maximum values:
- If all cells with the maximum value are in a single row or a single column, then choosing that row or column (and any intersecting column or row) will decrease all maximum values.
- If the maximum values are scattered such that no single row or column covers all of them, then at least one maximum value will remain after any operation.

The provided solution efficiently checks whether all occurrences of the maximum value can be covered by a single operation.

## Approach
1. **Find the Maximum Value**: Scan the matrix to determine the maximum value present.
2. **Track Maximum Value Positions**: For each row and column, count how many times the maximum value appears. Also, record the positions (row, column) where the maximum value occurs.
3. **Check Row Coverage**: For each row that contains the maximum value, check if by choosing this row and any column with a maximum value, all maximum values can be covered. This is done by:
    - Counting the number of columns that contain the maximum value.
    - For each column in the current row that contains the maximum value, check if removing this column would leave at most one column with a maximum value.
    - If this is possible, then all maximum values can be covered.
4. **Check Column Coverage**: If not possible by rows, repeat the process for columns.
5. **Determine the Result**: 
    - If it is possible to cover all maximum values with a single operation, the answer is (maximum value - 1).
    - Otherwise, the answer is the maximum value itself.

Let's clarify with an example:
Suppose the maximum value is 5 and it appears in positions (1,2), (2,2), and (3,2). All are in column 2, so choosing column 2 and any row will decrease all 5s. The answer is 4. If the 5s are at (1,1) and (2,2), no single row or column covers both, so the answer is 5.

## Algorithm
1. For each test case:
    1. Read the matrix and determine the maximum value.
    2. For each row and column, count how many times the maximum value appears.
    3. For each row with at least one maximum value:
        - Count the number of columns with maximum values.
        - For each column in this row that contains the maximum value, check if removing this column would leave at most one column with a maximum value.
        - If so, all maximum values can be covered.
    4. If not possible by rows, repeat the process for columns.
    5. If possible, output (maximum value - 1). Otherwise, output the maximum value.

## Complexity
- **Time Complexity**: O(n * m) per test case, where n is the number of rows and m is the number of columns. Each element is processed a constant number of times.
- **Space Complexity**: O(n + m) per test case, for storing row and column counts and lists of positions.

## Summary
The solution efficiently checks whether all occurrences of the maximum value can be covered by a single operation on a row and a column. If so, the maximum value in the matrix can be reduced by one; otherwise, it remains the same. The approach leverages counting and set coverage to ensure correctness and efficiency, and avoids unnecessary brute-force checking of all possible row and column pairs.

```java
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        int testcases = a.nextInt();
        StringBuilder c = new StringBuilder();
        while (testcases-- > 0) {
            int d = a.nextInt();
            int e = a.nextInt();
            int[][] f = new int[d][e];
            int g = 0;
            // Read the matrix and find the maximum value
            for (int h = 0; h < d; h++) {
                for (int i = 0; i < e; i++) {
                    int j = a.nextInt();
                    f[h][i] = j;
                    if (j > g) {
                        g = j;
                    }
                }
            }
            int[] k = new int[d]; // Row counts of max value
            int[] l = new int[e]; // Column counts of max value
            ArrayList<Integer>[] m = new ArrayList[d]; // Columns with max in each row
            ArrayList<Integer>[] n = new ArrayList[e]; // Rows with max in each column
            // Track positions of the maximum value
            for (int h = 0; h < d; h++) {
                for (int i = 0; i < e; i++) {
                    if (f[h][i] == g) {
                        k[h]++;
                        l[i]++;
                        if (m[h] == null) m[h] = new ArrayList<>();
                        m[h].add(i);
                        if (n[i] == null) n[i] = new ArrayList<>();
                        n[i].add(h);
                    }
                }
            }
            int o = 0;
            // Count columns that have at least one max value
            for (int i = 0; i < e; i++) {
                if (l[i] > 0) {
                    o++;
                }
            }
            boolean p = false;
            // Try to cover all max values by picking a row and any column
            for (int h = 0; h < d && !p; h++) {
                if (k[h] == 0) {
                    continue;
                }
                int q = o;
                for (int col : m[h]) {
                    if (l[col] == 1) {
                        q--;
                    }
                }
                if (q <= 1) {
                    p = true;
                }
            }
            // If not possible by rows, try by columns
            if (!p) {
                int r = 0;
                for (int h = 0; h < d; h++) {
                    if (k[h] > 0) {
                        r++;
                    }
                }
                for (int i = 0; i < e && !p; i++) {
                    if (l[i] == 0) {
                        continue;
                    }
                    int q = r;
                    for (int row : n[i]) {
                        if (k[row] == 1) {
                            q--;
                        }
                    }
                    if (q <= 1) {
                        p = true;
                    }
                }
            }
            // Output the result based on whether all max values can be covered
            if (p) {
                int s = g - 1;
                c.append(s).append('\n');
            } else {
                int s = g;
                c.append(s).append('\n');
            }
        }
        String result = c.toString();
        System.out.println(result);
    }
}
