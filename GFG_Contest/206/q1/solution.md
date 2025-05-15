# Solution Explanation

## Intuition

- You can only pair a negative with a non-negative, and the absolute value of the negative must be **greater** than the non-negative.
- Each element can be used in at most one pair.

## Approach

1. **Split the arrays** into negatives and non-negatives.
2. **Try to pair**:
   - Negatives from `arr` with non-negatives from `brr`
   - Negatives from `brr` with non-negatives from `arr`
3. For each direction, **sort**:
   - Negatives by their absolute value (ascending)
   - Non-negatives in ascending order
4. Use a **two-pointer approach** to greedily pair the smallest available non-negative with the smallest available negative (by absolute value) that is strictly greater.
5. **Sum the pairs** from both directions for the answer.

## Algorithm

- Separate negatives and non-negatives for both arrays.
- For each direction, sort the lists as described.
- Use two pointers to count the number of valid pairs.
- Return the total number of pairs.

## Code

```java
class Solution {
    public int maxMatching(int[] arr, int[] brr) {
        List<Integer> a = new ArrayList<>(); // negatives from arr
        List<Integer> b = new ArrayList<>(); // non-negatives from arr
        List<Integer> c = new ArrayList<>(); // negatives from brr
        List<Integer> d = new ArrayList<>(); // non-negatives from brr

        for (int e : arr) {
            if (e < 0) a.add(e);
            else b.add(e);
        }
        for (int e : brr) {
            if (e < 0) c.add(e);
            else d.add(e);
        }
        // Try to pair negatives from arr with non-negatives from brr, and vice versa
        return m(a, d) + m(c, b);
    }

    // Helper function to count valid pairs
    public static int m(List<Integer> a, List<Integer> b) {
        Collections.sort(a, (x, y) -> Integer.compare(Math.abs(x), Math.abs(y)));
        Collections.sort(b);
        int e = 0, f = 0, g = 0;
        while (e < a.size() && f < b.size()) {
            if (Math.abs(a.get(e)) > b.get(f)) {
                g++;
                f++;
            }
            e++;
        }
        return g;
    }
}
```

## Complexity

- **Time Complexity:** \(O(n \log n)\) per test case (due to sorting).
- **Space Complexity:** \(O(n)\) for the lists.

---

## Example

For `arr = [-1, 2, -3, 4]`, `brr = [1, -2, 3, -4]`:

- Negatives from `arr`: `[-1, -3]`
- Non-negatives from `arr`: `[2, 4]`
- Negatives from `brr`: `[-2, -4]`
- Non-negatives from `brr`: `[1, 3]`

- Pair `[-3]` from `arr` with `1` from `brr` (since `3 > 1`)
- Pair `2` from `arr` with `[-4]` from `brr` (since `4 > 2`)

Total pairs: `2`
