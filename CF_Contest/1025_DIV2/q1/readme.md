# It's Time To Duel

Mouf is organizing a Yu-Gi-Oh! tournament with `n` players arranged in a line, numbered from 1 to n. The tournament consists of `n-1` consecutive duels: for each `i` from 1 to `n-1`, player `i` faces player `i+1`, producing one winner and one loser per match. Afterward, each player reports a value `a_i` (0 ≤ a_i ≤ 1):

- 0: indicating they won no duels
- 1: indicating they won at least one duel

Some players may lie about their results. Mouf will cancel the tournament if he can prove any report to be false.

Given the array `a`, determine whether at least one player must be lying.

---

## Input

Each test contains multiple test cases.  
The first line contains the number of test cases `t` (1 ≤ t ≤ 100).  
The description of the test cases follows.

The first line of each test case contains one integer `n` (2 ≤ n ≤ 100) — the number of players in the tournament.

The second line of each test case contains `n` integers `a_1, a_2, ..., a_n` (0 ≤ a_i ≤ 1) — denoting the report of the i-th player.

---

## Output

For each test case, print "YES" if there is at least one liar among the players, and "NO" otherwise.

You can output the answer in any case (for example, "yEs", "yes", "Yes", and "YES" will all be recognized as positive responses).

---

## Example

Input

6  
3  
0 1 0  
2  
0 0  
2  
1 1  
4  
0 1 1 1  
4  
1 0 0 1  
7  
0 1 0 1 0 1 0  

Output

NO  
YES  
YES  
NO  
YES  
NO  

---

## Note

- In the first test case, it is consistent if player 2 defeats both players 1 and 3, so nobody's report is necessarily false.
- In the second test case, in the only match between players 1 and 2, one must win — but both claimed zero wins, so someone must be lying.
- In the third test case, the tournament consists of exactly one duel between players 1 and 2 — but it's impossible for both to win, concluding that at least one report is false.
- In the fourth test case, a possible scenario is that player 2 won against player 1, then 3 won against 2, and then 4 won against 3. All reports align, so there is no evidence that someone lied.
