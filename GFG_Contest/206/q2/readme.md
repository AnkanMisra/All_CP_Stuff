# Next Divisible Element

You are given an array of integers `arr[]`. You need to find the **next divisible element** for each element in the array. The next divisible element for an element `arr[i]` is the **first element** `arr[j]` (`j > i`) such that `arr[j] % arr[i] == 0`. If no such element exists, return `-1` for that position.

---

## Examples

**Input:**  
arr[] = [1, 2, 3, 4, 5]  
**Output:**  
2, 4, -1, -1, -1  
**Explanation:**  
- For arr[0] = 1, the next divisible element is arr[1] = 2.  
- For arr[1] = 2, the next divisible element is arr[3] = 4.  
- For arr[2] = 3, there is no next divisible element.  
- For arr[3] = 4, there is no next divisible element.  
- For arr[4] = 5, there is no next divisible element.

---

**Input:**  
arr[] = [11, 5, 25]  
**Output:**  
-1, 25, -1  
**Explanation:**  
- For arr[0] = 11, there is no next divisible element.  
- For arr[1] = 5, the next divisible element is arr[2] = 25.  
- For arr[2] = 25, there is no next divisible element.

---

## Constraints

- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ arr[i] ≤ 10^5
