# 2894. Divisible and Non-divisible Sums Difference

You are given positive integers `n` and `m`.

Define two integers as follows:

- `num1`: The sum of all integers in the range `[1, n]` (both inclusive) that are **not divisible by** `m`.
- `num2`: The sum of all integers in the range `[1, n]` (both inclusive) that **are divisible by** `m`.

**Return** the integer `num1 - num2`.

---

## Examples

### Example 1:
Input:  
n = 10, m = 3  
Output:  
19  

Explanation:  
- Integers not divisible by 3: [1,2,4,5,7,8,10] → sum = 37  
- Integers divisible by 3: [3,6,9] → sum = 18  
- Result: 37 - 18 = 19

---

### Example 2:
Input:  
n = 5, m = 6  
Output:  
15  

Explanation:  
- Not divisible: [1,2,3,4,5] → sum = 15  
- Divisible: [] → sum = 0  
- Result: 15 - 0 = 15

---

### Example 3:
Input:  
n = 5, m = 1  
Output:  
-15  

Explanation:  
- Not divisible: [] → sum = 0  
- Divisible: [1,2,3,4,5] → sum = 15  
- Result: 0 - 15 = -15

---

## Constraints
- 1 <= n, m <= 1000
