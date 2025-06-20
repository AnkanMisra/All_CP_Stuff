# Problem: G. Chimpanzini Bananini

## Problem Description

Chimpanzini Bananini gives you an empty array. You can perform three types of operations on it:

1. **Cyclic Shift:**  
   The array [a1, a2, ..., an] becomes [an, a1, a2, ..., an-1].

2. **Reverse:**  
   The array [a1, a2, ..., an] becomes [an, an-1, ..., a1].

3. **Append:**  
   Append an integer k to the end of the array.

After each operation, you must output the **rizziness** of the array, defined as:  
rizziness = b1*1 + b2*2 + ... + bm*m  
where m is the current length of the array.

All operations are persistent and modify the array for subsequent operations.

### Definitions

- **Cyclic Shift:** Move the last element to the front.
- **Reverse:** Reverse the entire array.
- **Append:** Add a new element to the end of the array.
- **Rizziness:** For an array b of length m, rizziness is b1*1 + b2*2 + ... + bm*m.

## Input Format

- The first line contains a single integer `t` (1 ≤ t ≤ 10⁴): the number of test cases.
- For each test case:
  - The first line contains a single integer `q` (1 ≤ q ≤ 2 × 10⁵): the number of operations.
  - The next `q` lines each contain:
    - An integer `s` (1 ≤ s ≤ 3) — the operation type.
    - If `s = 3`, an additional integer `k` (1 ≤ k ≤ 10⁶) is given.

It is guaranteed that the sum of all `q` across test cases will not exceed 2 × 10⁵.  
The first operation in each test case is always `s = 3`.

## Output Format

- For each test case, output `q` lines, each containing the rizziness of the array after the corresponding operation.

## Example

### Input
1<br />
13<br />
3 1<br />
3 2<br />
3 3<br />
1<br />
3 4<br />
2<br />
3 5<br />
1<br />
3 6<br />
2<br />
3 7<br />
2<br />
1<br />

### Output
1<br />
5<br />
14<br />
11<br />
27<br />
23<br />
48<br />
38<br />
74<br />
73<br />
122<br />
102<br />
88<br />

## Goal

After each operation, output the **rizziness** of the array as defined above.
