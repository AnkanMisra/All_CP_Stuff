
# Problem: C. Divisibility by Eight

## Problem Description

You are given a non-negative integer `n`, whose decimal representation consists of at most 100 digits and doesn't contain leading zeroes.

Your task is to determine if it is possible to remove some of the digits (possibly not remove any digit at all) so that the result:
- contains at least one digit,
- forms a non-negative integer,
- doesn't have leading zeroes,
- and is divisible by 8.

After removing digits, you are **not allowed to rearrange the digits**.

If a solution exists, you should print it.

## Input Format

- A single line containing a non-negative integer `n` (up to 100 digits, no leading zeroes).

## Output Format

- Print "NO" if there is no such way to remove some digits from number `n`.
- Otherwise, print "YES" in the first line and the resulting number after removing digits from number `n` in the second line. The printed number must be divisible by 8.
- If there are multiple possible answers, you may print any of them.

## Examples

### Example 1

**Input:**  
3454

**Output:**  
YES  
344

### Example 2

**Input:**  
10

**Output:**  
YES  
0

### Example 3

**Input:**  
111111

**Output:**  
NO

## Notes

- In the first example, you can remove the digit '5' to get 344, which is divisible by 8.
- In the second example, you can remove the digit '1' to get 0, which is divisible by 8.
- In the third example, there is no way to remove digits to get a number divisible by 8.