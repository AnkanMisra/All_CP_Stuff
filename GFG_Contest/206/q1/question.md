# Maximum Matching Pair

You are given two arrays, `arr[]` and `brr[]`, of equal length. You can form a matching pair by selecting one element from each array, but only under the following condition:

- One element must be **negative**, the other must be **non-negative**, and the **absolute value of the negative element must be greater than the non-negative element**.
- Each element can be used in **at most one pair**.

Your task is to determine the **maximum number of such valid matching pairs** that can be formed between the two arrays.

---

## Examples

**Input:**  
arr[] = [-1, 2, -3, 4], brr[] = [1, -2, 3, -4]  
**Output:**  
2  
**Explanation:**  
In this case, we can form two valid pairs: (-3, 1) and (2, -4).

---

**Input:**  
arr[] = [1], brr[] = [-1]  
**Output:**  
0  
**Explanation:**  
In this case, we cannot form any valid pairs because the absolute value of the negative element (-1) is not greater than the non-negative element (1).

---

## Constraints

- 1 ≤ arr.size() = brr.size() ≤ 10^5
- -10^9 ≤ arr[i], brr[i] ≤ 10^9
