
```
# Potions (Hard Version)

## Problem Description
You are given `n` potions positioned left-to-right, from potion&nbsp;`1` to potion&nbsp;`n`. Drinking potion&nbsp;`i` changes your health by `a_i`, which can be positive or negative. You start with **0** health and move from the first potion to the last, deciding at each step whether to **drink** or **skip** the current potion. Your health must **never become negative** at any moment.

Determine the **maximum number of potions** you can drink while maintaining non-negative health throughout the journey.

## Input Format
- The first line contains an integer `n` – the number of potions.
- The second line contains `n` integers `a_1, a_2, …, a_n` – the health changes of the potions.

## Output Format
- Print a single integer – the maximum number of potions that can be drunk without your health ever becoming negative.

## Constraints
- `1 ≤ n ≤ 200000`
- `-10^9 ≤ a_i ≤ 10^9`

## Examples

### Example&nbsp;1
**Input:**  

6  
4 ‑4 1 ‑3 1 ‑3<br/>

**Output:**  

5<br/>

### Example&nbsp;2
**Input:**  

4  
-5 6 3 ‑2<br/>

**Output:**  

2<br/>

## Notes
- In Example&nbsp;1 you can drink potions `1, 3, 4, 5, 6`. Attempting to drink all six would drop your health below zero at some point.
- In Example&nbsp;2 the best choice is to drink potions `2` and `3`, keeping your health non-negative at every step while maximising the count.
```

