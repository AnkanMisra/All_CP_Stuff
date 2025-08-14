

# Solution Explanation

## Intuition
The expression is evaluated **left-to-right** while obeying two rules:
1. **`+` / `-` have the same, lowest precedence**.
2. **Parentheses start a sub-expression** that must be evaluated before it contributes to the outer one.

Instead of recursion we keep the state of the outer expression on a **stack** whenever we enter a `(`.
That state is just two integers:
- the partial result that was computed so far
- the sign (`+1` or `-1`) that precedes this parenthesis

With that information the sub-expression can be reduced to a single number and merged into the outer context once we meet the matching `)`.

## Approach
1. **Variables**
   `res` – current accumulated value inside the present level (initially `0`)
   `sign` – sign to apply to the next number (`+1` initially)
   `stack` – holds pairs `(previousResult , previousSign)`

2. **Scan the string** character by character

   | Char | Action |
   |------|--------|
   | digit | build the whole number, add `sign * number` to `res` |
   | `+`   | set `sign = +1` |
   | `-`   | set `sign = ‑1` |
   | `(`   | push `res`, then `sign` onto stack; reset `res = 0`, `sign = +1` |
   | `)`   | pop `prevSign`, `prevRes`; set `res = prevRes + prevSign * res` |
   | space | ignore |

3. After the loop ends `res` already contains the final value.

### Why does it work?
- The stack mimics the call stack of a recursive descent parser but with only O(1) work per parenthesis.
- Whenever we close a parenthesis we have the exact value of the inner expression and its preceding sign, so we can fold it into the outer result.

## Complexity
- **Time:** `O(n)` – every character is processed once.
- **Space:** `O(n)` in the worst case of deep nesting (all characters are `(`).

## Summary
A single linear scan with a stack to remember the outer context evaluates the expression while fully respecting the precedence introduced by parentheses. The algorithm is simple, runs in linear time and uses at most one stack frame per open parenthesis.
```java
class Solution {
    public int calculate(String s) {
        int n = s.length();
        int res = 0;
        int sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                res += sign * (int) num;
                continue;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                res = prevRes + prevSign * res;
            }
            i++;
        }
        return res;
    }
}
```

