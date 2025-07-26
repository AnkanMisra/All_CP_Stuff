
# Solution Explanation

## Intuition
The problem asks us to find all elements that appear more than `floor(n/3)` times in an array. A key insight is that **there can be at most 2 elements** that appear more than `n/3` times in any array, since if there were 3 such elements, their combined frequency would exceed the total array size.

## Approach
We can solve this problem using **Boyer-Moore Majority Vote Algorithm** extended for finding elements with frequency > `n/3`. The algorithm works in two phases:

1. **Candidate Selection Phase:** Use two variables to track potential majority candidates and their counts. Iterate through the array and update candidates based on the voting mechanism.

2. **Verification Phase:** Count the actual frequency of each candidate to confirm they appear more than `floor(n/3)` times.

Alternatively, we can use a **frequency counting approach** with a hash map to count occurrences of each element and then filter elements with frequency > `floor(n/3)`.

## Algorithm

### Method 1: Boyer-Moore Extended Algorithm
1. Initialize two candidate variables and their respective counts to 0
2. **First Pass - Find Candidates:**
   - For each element in the array:
     - If element equals first candidate, increment its count
     - Else if element equals second candidate, increment its count
     - Else if first candidate count is 0, set element as first candidate
     - Else if second candidate count is 0, set element as second candidate
     - Else decrement both counts
3. **Second Pass - Verify Candidates:**
   - Count actual frequency of each candidate
   - Add candidates with frequency > `floor(n/3)` to result
4. **Sort the result** before returning

### Method 2: Frequency Counting
1. Create a hash map to count frequency of each element
2. Iterate through array and update frequency counts
3. Filter elements with frequency > `floor(n/3)`
4. **Sort the result** before returning

## Complexity

### Boyer-Moore Extended Algorithm:
- **Time Complexity:** `O(n)` - Two passes through the array
- **Space Complexity:** `O(1)` - Only using constant extra space for candidates and counts

### Frequency Counting:
- **Time Complexity:** `O(n)` - Single pass through array plus sorting result
- **Space Complexity:** `O(k)` where k is number of unique elements

## Summary
The Boyer-Moore extended algorithm is **more space-efficient** as it uses constant space, while the frequency counting approach is **more intuitive** but uses additional space. Both approaches correctly identify majority elements by leveraging the mathematical constraint that at most 2 elements can have frequency > `n/3`. The key insight is the **two-phase approach**: candidate selection followed by verification, ensuring we don't miss any valid majority elements while maintaining optimal time complexity.
```java
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for (int num : arr) {
            if (num == candidate1) {
                count1++;
            }
            else if (num == candidate2) {
                count2++;
            }
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }
            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int num : arr) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        ArrayList<Integer> result = new ArrayList<>();
        int threshold = arr.length / 3;

        if (count1 > threshold) result.add(candidate1);
        if (count2 > threshold) result.add(candidate2);

        Collections.sort(result);

        return result;
    }
}
```
