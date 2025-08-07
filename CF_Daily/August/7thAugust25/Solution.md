
```
# Solution Explanation

## Intuition
We want to drink as many potions as possible while ensuring our health never becomes negative.  
A greedy insight is to **temporarily drink every potion** in order. If our running health drops below `0`, we must undo (skip) *one* of the previously drunk potions. To minimise the impact on the final count, we should remove the potion with the **smallest health gain** (the most negative, or the least positive) among those we have taken so far.

## Approach
1. Initialise `health = 0` and an empty **min-heap** (priority queue) `pq` to store values of all potions we decide to drink.
2. Scan the potions from left to right:
   1. Add the current potion value `a_i` to `health` and push it into `pq`.
   2. If `health < 0`, it means we have exceeded our allowed deficit. Remove the **smallest element** from `pq` (this is the potion that hurts our health the most), and subtract its value from `health`.  
      This effectively *skips* that potion while keeping as many of the others as possible.
3. After processing all potions, the size of `pq` is the maximum count we can keep.

## Algorithm (step-by-step)
1. `health ← 0`, `pq ← {}` (min-heap)
2. For each `i = 1 … n`:
   - `health ← health + a_i`
   - `pq.push(a_i)`
   - **If** `health < 0`:
     - `x ← pq.pop()`   *(removes smallest value)*
     - `health ← health - x`
3. Output `pq.size()`.

## Complexity
- **Time:** `O(n log n)` – each potion is inserted once (`log n`) and possibly removed once (`log n`).
- **Space:** `O(n)` – in the worst case we store all potions in the heap.

## Summary
The greedy removal of the smallest consumed potion whenever health turns negative guarantees the **largest possible set** of potions is retained. The min-heap efficiently tracks the potion to discard in `log n` time, yielding an optimal solution within constraints.
```

