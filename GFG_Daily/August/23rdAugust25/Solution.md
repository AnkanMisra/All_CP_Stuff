
# Solution Explanation

## Intuition
This is a **binary search optimization problem**. We need to find the minimum possible value of the maximum pages assigned to any student. The key insight is that if we can allocate books with a maximum of `X` pages per student, we can also allocate with any value greater than `X`. This **monotonic property** makes binary search applicable.

## Approach
We use **binary search on the answer space**. The search range is:
- **Lower bound**: Maximum single book pages (since each student needs at least one book)
- **Upper bound**: Sum of all pages (worst case: one student gets all books)

For each candidate answer `mid`, we check if allocation is possible using a **greedy approach**: assign books to the current student until adding the next book would exceed `mid` pages, then move to the next student.

## Algorithm
1. **Base case**: If `k > n`, return `-1` (more students than books)
2. **Initialize bounds**: `low = max(arr)`, `high = sum(arr)`
3. **Binary search**:
   - Calculate `mid = (low + high) / 2`
   - Check if allocation is possible with `mid` as maximum pages
   - If possible: update result and search for smaller maximum (`high = mid - 1`)
   - If not possible: search for larger maximum (`low = mid + 1`)
4. **Allocation check**: Use greedy approach to assign books sequentially

## Complexity
- **Time Complexity**: `O(n * log(sum - max))` where `n` is array length
  - Binary search: `O(log(sum - max))`
  - Each allocation check: `O(n)`
- **Space Complexity**: `O(1)` - only using constant extra space

## Summary
The **binary search approach** works because of the monotonic property: if allocation is possible with `X` maximum pages, it's also possible with any value greater than `X`. The **greedy allocation strategy** ensures we use the minimum number of students for any given maximum page limit. Key corner case is when students exceed books, making allocation impossible.
```java
class Solution {
    public int findPages(int[] arr, int k) {
        int n = arr.length;

        if (k > n) {
            return -1;
        }

        int low = getMax(arr);
        int high = getSum(arr);
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canAllocate(int[] arr, int k, int maxPages) {
        int students = 1;
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages <= maxPages) {
                currentPages += pages;
            } else {
                students++;
                currentPages = pages;

                if (students > k) {
                    return false;
                }
            }
        }

        return true;
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}

```
