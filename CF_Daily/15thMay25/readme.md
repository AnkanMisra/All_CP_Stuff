# 🧮 Problem: Beautiful Matrix

## 📝 Description

You're given a **5×5 matrix** containing **exactly one `1`** and the rest all `0`s.  
You can perform the following **two types of moves**:

1. **Swap two neighboring rows** (i.e., rows `i` and `i+1` for `1 ≤ i < 5`)
2. **Swap two neighboring columns** (i.e., columns `j` and `j+1` for `1 ≤ j < 5`)

A matrix is considered **beautiful** if the `1` is placed **exactly at the center**, i.e., position **(3, 3)** (3rd row, 3rd column using 1-based indexing).

---

## 🎯 Goal

Print the **minimum number of moves** required to make the matrix beautiful.

---

## 🔢 Input Format

- The input consists of **5 lines**, each containing **5 integers** separated by space.
- Each integer is either `0` or `1`.
- The matrix contains **exactly one `1`** and **twenty-four `0`s**.

---

## 📤 Output Format

- Print a **single integer** — the minimum number of moves to make the matrix beautiful.

---

## 📘 Examples

### Example 1

**Input:**
```
0 0 0 0 0
0 0 0 0 1
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
```

**Output:**
```
3
```

**Explanation:**
The `1` is at position (2, 5). To bring it to (3, 3):
- Move it down to row 3: 1 move
- Move it left twice to column 3: 2 moves  
Total = 3 moves.

---

### Example 2

**Input:**
```
0 0 0 0 0
0 0 0 0 0
0 1 0 0 0
0 0 0 0 0
0 0 0 0 0
```

**Output:**
```
1
```

**Explanation:**
The `1` is already in the 3rd row but in column 2.  
We just need to move it 1 step to the right to column 3.

---

## 🔒 Constraints

- Matrix size is always 5×5
- Input contains exactly one `1`
- Time Limit: 2 seconds  
- Memory Limit: 256 MB

---

## ✅ Hint

The minimum number of moves is simply the **Manhattan distance** between the current position of `1` and the center `(3, 3)`:

```
moves = |current_row - 3| + |current_col - 3|
```