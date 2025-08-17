
# Solution Explanation

## Intuition
The main idea is to **sort the array elements** based on their **absolute difference** with the given number `x`. Elements with smaller absolute differences should come first in the result.

## Approach
1. **Copy all elements** from the original array to an `ArrayList` for easier manipulation
2. **Sort the ArrayList** using a custom comparator that compares elements based on their absolute difference with `x`
3. **Copy back** the sorted elements from the ArrayList to the original array
4. The custom comparator `(a,b) -> Math.abs(a-x) - Math.abs(b-x)` ensures **stable sorting** - elements with equal absolute differences maintain their original relative order

## Algorithm
1. Create an `ArrayList` and add all array elements to it
2. Use `Collections.sort()` with a custom comparator:
   - For any two elements `a` and `b`, compare `Math.abs(a-x)` with `Math.abs(b-x)`
   - Return the difference to determine ordering
3. Copy the sorted elements back to the original array

## Complexity
- **Time Complexity:** `O(n log n)` where `n` is the length of the array (due to sorting)
- **Space Complexity:** `O(n)` for the additional ArrayList used for sorting

## Summary
This approach works by leveraging **Java's stable sorting algorithm** which automatically handles the requirement that elements with equal absolute differences maintain their original order. The custom comparator ensures elements are ordered by their **distance from x**, and the stable sort property handles the **tie-breaking** requirement mentioned in the problem statement.
```java
class Solution {
    void convert(int[] arr, int n) {

        int[] temp = arr.clone();
        Arrays.sort(temp);
        HashMap<Integer,Integer> hm = new HashMap<>();

        int val=0;
        for(int num : temp) hm.put(num , val++);
        for(int i=0;i<n;i++)    arr[i] = hm.get(arr[i]);
    }
}
```
