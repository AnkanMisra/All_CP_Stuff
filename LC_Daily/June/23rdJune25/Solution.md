# Solution Explanation

## Intuition
A k-mirror number is a number that is a palindrome in both base-10 and base-k. The task is to find the sum of the n smallest such numbers. The key insight is that all k-mirror numbers must be palindromic in base-10, so we can generate palindromic numbers in base-10 in increasing order and check if they are also palindromic in base-k.

## Approach
1. **Generate Palindromic Numbers in Base-10:**  
   - Start from 1 and repeatedly generate the next palindromic number greater than or equal to the current number.
   - Use a helper function to generate the next palindrome efficiently.
2. **Check Palindrome in Base-k:**  
   - For each palindromic number in base-10, convert it to base-k and check if it is also a palindrome.
   - If it is, add it to the sum and increment the count.
3. **Repeat Until n k-Mirror Numbers Are Found:**  
   - Continue generating palindromic numbers and checking them until n such numbers are found.
4. **Return the Sum:**  
   - Return the sum of the n smallest k-mirror numbers.

## Complexity
- **Time Complexity:** Efficient for the given constraints (since n ≤ 30 and k ≤ 9), as we only generate and check palindromic numbers.
- **Space Complexity:** O(1) extra space (ignoring the space for string manipulation).

## Summary
**By generating palindromic numbers in base-10 and checking if they are also palindromic in base-k, we can efficiently find the n smallest k-mirror numbers and compute their sum.**  
This approach leverages the properties of palindromes and the small value of n for efficiency.

```java
class Solution {
    public long kMirror(int k, int n) {
        
        long ans = 0, x = 1, c = 0;
        while(true) {
            if(check_base(x, k)) {
                ans+=x;
                c+=1;
                if(c == n) return ans;
            }
            x = next_palin(x);
        }
    }

    public boolean check_base(long n, int k) {

        StringBuilder ans = new StringBuilder();
        while(n > 0) {
            ans.append(n % k);
            n/=k;
        }
        return palin(ans.toString());
    }

    public boolean palin(String s) {

        int l = s.length()-1, f = 0;
        while(f < l) {
            if(s.charAt(f) != s.charAt(l)) return false;
            f++;
            l--;
        }

        return true;
    }

    public long next_palin(long n) {

        int len = (int)(Math.log10(n))+1;
        String s = String.valueOf(n);
        String t = String.valueOf(9).repeat(len);
        if(s.equals(t)) return Long.parseLong(s)+2;

        String half = s.substring(0, (len+1)/2);
        int l = half.length();
        long ans = 0;
        if((len & 1) == 0) {
            ans = Long.parseLong(half + extrac(half, l-1, 0));
        } else ans = Long.parseLong(half + extrac(half, l-2, 0));

        if(ans > n) return ans;
        half = String.valueOf(Integer.parseInt(half) + 1);
        l = half.length();
        if((len & 1) == 0) {
            ans = Long.parseLong(half + extrac(half, l-1, 0));
        } else ans = Long.parseLong(half + extrac(half, l-2, 0));

        return ans;
    }

    public String extrac(String s, int f, int l) {

        StringBuilder str = new StringBuilder();
        for(int i=f;i>=l;i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }
}
