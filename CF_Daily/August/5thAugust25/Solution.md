
# Solution Explanation

## Intuition
The number of hamburgers Polycarpus can make is limited by the **available ingredients** and the **money to buy missing pieces**.
For any target count `x`, we can calculate how many pieces of **bread**, **sausage**, and **cheese** are still needed after using the current stock, then check whether buying those pieces costs **≤ r** rubles.
Because the total cost **increases monotonically** with `x`, we can apply **binary search** on `x`.

## Approach
1. **Count recipe requirements**
   Scan the recipe string once to obtain `reqB`, `reqS`, `reqC` — the number of bread, sausage, and cheese pieces needed for **one** hamburger.
2. **Binary search range**
   The answer fits in `[0, 10^{13}]` (large enough because `r ≤ 10^{12}` and prices ≤ 100).
3. **Feasibility check for a candidate `mid`**
   - Need `needB = max(0, reqB·mid − nb)` additional breads, and similarly `needS`, `needC`.
   - Total cost `cost = needB·pb + needS·ps + needC·pc`.
   - If `cost ≤ r`, `mid` hamburgers are possible → search higher; otherwise search lower.
4. **Binary search** until the range collapses; the highest feasible value is the answer.

## Complexity
- **Time:** `O(log A)` where `A` is the upper bound (`≈ 10^{13}`), because each step does `O(1)` calculations.
  Effectively `≈ 60` iterations.
- **Space:** `O(1)` — only constant extra variables.

## Summary
By recognizing the **monotonic** relationship between hamburgers produced and required money, we use **binary search** and simple arithmetic to find the maximum feasible count within the budget and stock constraints.

