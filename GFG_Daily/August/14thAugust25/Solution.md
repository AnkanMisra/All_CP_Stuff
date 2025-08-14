
# Solution Explanation

## Intuition
The problem asks us to find pairs `(i, j)` where `i < j` and `arr[i] > 2 * arr[j]`. A **brute force approach** would check all possible pairs, but this would be inefficient for large arrays. The key insight is to use a **divide and conquer approach** similar to merge sort, where we can count reverse pairs while merging sorted subarrays.

## Approach
We can solve this problem using a **modified merge sort algorithm**. The main idea is:

- **Divide:** Split the array into two halves recursively
- **Conquer:** Count reverse pairs in each half separately
- **Combine:** Count reverse pairs where one element is from the left half and another from the right half, then merge the sorted halves

During the merge step, when we find an element in the left half that is greater than `2 * element` in the right half, we know that this element (and all remaining elements in the left half) will form reverse pairs with the current element in the right half.

## Algorithm
1. **Base case:** If array has 1 or 0 elements, return 0
2. **Divide:** Split array into left and right halves
3. **Recursive calls:** Count reverse pairs in left half and right half
4. **Cross counting:** Count reverse pairs where `i` is in left half and `j` is in right half:
   - Use two pointers approach on sorted halves
   - For each element in right half, count how many elements in left half satisfy the condition
5. **Merge:** Merge the two sorted halves
6. **Return:** Sum of counts from left half, right half, and cross pairs

## Complexity
- **Time Complexity:** `O(n log n)` - Similar to merge sort, we divide the array log n times and each merge operation takes O(n) time
- **Space Complexity:** `O(n)` - For the temporary arrays used during merging and recursive call stack

## Summary
This approach efficiently counts reverse pairs by leveraging the **divide and conquer paradigm**. The key insight is that when arrays are sorted, we can count cross-pairs efficiently using a two-pointer technique. This reduces the time complexity from `O(n²)` brute force to `O(n log n)`, making it suitable for the given constraints where array size can be up to `5*10⁴`.
```java
class Solution {
    public int countRevPairs(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        int count = mergeSort(a, l, m) + mergeSort(a, m + 1, r);

        // Count reverse pairs across halves
        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long)a[i] > 2L * (long)a[j]) j++;
            count += (j - (m + 1));
        }

        // Merge the two sorted halves
        merge(a, l, m, r);
        return count;
    }

    private void merge(int[] a, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        System.arraycopy(temp, 0, a, l, temp.length);
    }
}
```

