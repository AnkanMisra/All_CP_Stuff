# ✅ Solution: Beautiful Matrix

This Java solution efficiently finds the number of moves required to make a given 5x5 matrix **beautiful** — i.e., moving the single `1` to the center cell `(3, 3)` (which is index `(2, 2)` in 0-based indexing).

---

## 📜 Code

```java
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int oneRow = -1, oneCol = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int value = scanner.nextInt();
                if (value == 1) {
                    oneRow = i;
                    oneCol = j;
                }
            }
        }

        int moves = Math.abs(oneRow - 2) + Math.abs(oneCol - 2);
        System.out.println(moves);
    }
}
```

---

## 🧠 Approach

- **Input Parsing**: The matrix is read using nested loops. For each cell:
  - If the value is `1`, we store its position in `oneRow` and `oneCol`.

- **Compute Distance**:
  - The target cell is at index `(2, 2)` (i.e., third row and column).
  - Calculate the **Manhattan Distance** between the current position of `1` and the center using:
    ```java
    Math.abs(oneRow - 2) + Math.abs(oneCol - 2)
    ```
  - This gives the **minimum number of swaps** required (row + column moves).

- **Output**:
  - Print the computed number of moves.

---

## 🧪 Example

### Input:
```
0 0 0 0 0
0 0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
```

### Output:
```
3
```

---

## ⏱️ Time and Space Complexity

- **Time Complexity**: `O(1)` (only one pass through the 5×5 matrix)
- **Space Complexity**: `O(1)` (constant space used)

---