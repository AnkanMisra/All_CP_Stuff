
# Make All Zero

Two players are playing a game involving energy stacks. Each stack contains a certain number of energy crystals represented as integers in an array `arr[]`.

Players take turns. On each turn, a player must remove one entire stack (i.e., remove one element from the array). However, there's a special rule:

- If the bitwise XOR of the entire array is 0 before a player's turn, then that player instantly wins.

If it's not zero, they must remove one stack. The game continues until someone wins either due to the XOR rule or because the other player cannot move.

Both players play optimally. You need to determine who will win for each initial array of stacks.

Return `true` if Player 2 wins.

---

## Examples

**Input:**  
arr[] = [1, 2, 3]  
**Output:**  
false  
**Explanation:**  
Since XOR of the entire array is 0 before player 1's turn, player 1 wins.

---

**Input:**  
arr[] = [1, 2, 4]  
**Output:**  
true  
**Explanation:**  
Player 1 removes 1 from arr[] on his turn, then player 2 removes 2 from arr[], then player 1 removes 4 which makes Bitwise XOR of arr[] as 0. Hence player 2 wins.

---

## Constraints

- 1 ≤ arr.size() ≤ 10^5
- 1 ≤ arr[i] ≤ 10^8
