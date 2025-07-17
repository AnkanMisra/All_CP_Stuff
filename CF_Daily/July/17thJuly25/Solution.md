
# Solution Explanation

## Intuition
The core idea is to find two **non-overlapping** occurrences of the substrings `AB` and `BA`. This can happen in two possible orders: `AB` appearing before `BA`, or `BA` appearing before `AB`. We need to check for both scenarios.

## Approach
The approach involves a straightforward search for both required patterns in the specified orders:

1.  **Check for `AB` then `BA`**:
    - First, we search for the **first occurrence** of the substring `AB` in the string.
    - If `AB` is found at index `i`, we then search for the substring `BA` starting from index `i + 2`. The offset of `+2` is crucial to ensure the substrings do not overlap (e.g., to correctly handle cases like `ABA`).
    - If `BA` is also found, we have satisfied the condition, and the answer is **`YES`**.

2.  **Check for `BA` then `AB`**:
    - If the first check fails, we try the reverse order.
    - We search for the **first occurrence** of the substring `BA`.
    - If `BA` is found at index `j`, we then search for `AB` starting from index `j + 2`.
    - If `AB` is found, the condition is met, and the answer is **`YES`**.

3.  **Final Result**:
    - If neither of the two checks succeeds, it means no such non-overlapping pair exists. In this case, the answer is **`NO`**.

## Complexity
- **Time Complexity**: `O(n)`, where `n` is the length of the string. The `indexOf` operation takes linear time, and we perform it a constant number of times.
- **Space Complexity**: `O(1)`, as we only use a few variables to store indices and a boolean flag, which does not depend on the input string size.

## Summary
This approach is both **correct and efficient**. It systematically checks the only two valid configurations (`...AB...BA...` and `...BA...AB...`) while strictly enforcing the non-overlapping constraint. By using an index offset, it correctly distinguishes between overlapping and non-overlapping patterns. The linear time complexity is well within the problem's constraints.

