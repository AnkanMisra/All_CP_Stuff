# Solution Explanation

## Intuition
The problem is to find the median of two sorted arrays. The brute-force approach is to merge both arrays, sort the result, and then find the median. While this works for small arrays, the optimal solution should run in O(log(m+n)) time using binary search. However, the provided code uses the brute-force approach.

## Approach
1. **Merge Both Arrays:**  
   - Add all elements from `nums1` and `nums2` into a single list.
2. **Sort the Merged List:**  
   - Sort the combined list to get all elements in order.
3. **Find the Median:**  
   - If the total number of elements is odd, the median is the middle element.
   - If the total number of elements is even, the median is the average of the two middle elements.

## Complexity
- **Time Complexity:** O((m+n) log(m+n)), where m and n are the lengths of the two arrays (due to sorting).
- **Space Complexity:** O(m+n), for storing the merged list.

## Summary
**The brute-force approach merges and sorts the arrays, then finds the median.**  
While this is not optimal for large arrays, it is simple and works for the given constraints.

```java
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i : nums1)
        {
            lst.add(i);
        }
        for(int i : nums2)
        {
            lst.add(i);
        }
        Collections.sort(lst);

        double res = 0.0000;

        int len = lst.size();
        if(len % 2 == 0)
        {
            res = (lst.get((len / 2) - 1) + lst.get(len / 2)) / 2.0; 
        }
        else
        {
            res = lst.get(len / 2);
        }
        return res;
    }
}
