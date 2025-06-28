# Counting Elements in Two Arrays

Given two unsorted arrays, `a[]` and `b[]`, the task is to determine, for each element in `a[]`, how many elements in `b[]` are less than or equal to it. Both arrays may contain duplicate elements.

## Examples

### Example 1:

**Input:**
`a[] = [4, 8, 7, 5, 1]`
`b[] = [4, 48, 3, 0, 1, 1, 5]`

**Output:**
`[5, 6, 6, 6, 3]`

**Explanation:**
- For `a[0] = 4`: Elements in `b` less than or equal to 4 are `[4, 3, 0, 1, 1]`. Count: 5.
- For `a[1] = 8`: Elements in `b` less than or equal to 8 are `[4, 3, 0, 1, 1, 5]`. Count: 6.
- For `a[2] = 7`: Elements in `b` less than or equal to 7 are `[4, 3, 0, 1, 1, 5]`. Count: 6.
- For `a[3] = 5`: Elements in `b` less than or equal to 5 are `[4, 3, 0, 1, 1, 5]`. Count: 6.
- For `a[4] = 1`: Elements in `b` less than or equal to 1 are `[0, 1, 1]`. Count: 3.

### Example 2:

**Input:**
`a[] = [10, 20]`
`b[] = [30, 40, 50]`

**Output:**
`[0, 0]`

**Explanation:**
- For `a[0] = 10`: No elements in `b` are less than or equal to 10. Count: 0.
- For `a[1] = 20`: No elements in `b` are less than or equal to 20. Count: 0.

## Constraints

- `1 <= a.size(), b.size() <= 10^5`
- `0 <= a[i], b[j] <= 10^5`
