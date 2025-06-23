# Solution Explanation

## Intuition
The problem is to form two numbers from the given digits such that their sum is minimized. The key insight is that, after sorting the digits, distributing them alternately between the two numbers (smallest to largest) will yield the minimum possible sum.

## Approach
1. **Sort the Digits:**  
   - Sort the array in ascending order.
2. **Distribute Alternately:**  
   - Build two numbers by alternately picking digits from the sorted array (first digit to the first number, second to the second, and so on).
3. **Sum the Two Numbers:**  
   - Add the two numbers digit by digit (as strings) to handle large numbers and avoid integer overflow.
   - Remove any leading zeros from the result.
4. **Return the Result:**  
   - Return the sum as a string.

## Complexity
- **Time Complexity:** O(n log n) for sorting, O(n) for building and summing the numbers.
- **Space Complexity:** O(n) for storing the numbers as strings.

## Summary
**By sorting the digits and distributing them alternately, we ensure the two numbers are as small as possible, minimizing their sum.**  
String addition is used to handle large numbers and ensure correctness.

```java
class Solution{
    String minSum(int[] arr) {
        int n = arr.length;
        if(n == 1) return String.valueOf(arr[0]);
        if(n == 2) return String.valueOf(arr[0]+arr[1]);
        
        Arrays.sort(arr);
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        
        for(int i=0; i<n; i++){
            if(i % 2 == 0){
                a.append(arr[i]);
            }
            else b.append(arr[i]);
        }
        return sum(a, b).toString();
    }

    StringBuilder sum(StringBuilder a, StringBuilder b){
        int m = a.length(), n = b.length();
        if(m < n) a.insert(0,0);
        else b.insert(0,0);
        
        int carry = 0;
        a.reverse();
        b.reverse();
        StringBuilder ans = new StringBuilder();
        
        for(int i=0; i<a.length(); i++){
            int val = a.charAt(i)-'0'+b.charAt(i)-'0'+carry;
            ans.append(val%10);
            carry = val/10;
        }
        ans.reverse();
        while(ans.length() > 1 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        return ans;
    }
}
