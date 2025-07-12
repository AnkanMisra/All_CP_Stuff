
# 1900. The Earliest and Latest Rounds Where Players Compete

## Problem Description
You are given a tournament with **n players** standing in a single row, numbered from `1` to `n` based on their initial position. The tournament consists of multiple rounds (starting from round `1`). In each round:
- The `i`th player from the front competes against the `i`th player from the end of the row.
- The winner advances to the next round.
- If the number of players is **odd**, the player in the middle automatically advances to the next round.
- After each round, the winners are lined up again in their original ascending order.

The players numbered `firstPlayer` and `secondPlayer` are the **best** in the tournament. They can win against any other player before they compete against each other. If any two other players compete, either can win (you may choose the outcome).

Return an array containing **two values**: the earliest possible round number and the latest possible round number in which `firstPlayer` and `secondPlayer` can compete against each other.

## Input Format
- An integer `n` (**2 <= n <= 28**): the number of players.
- An integer `firstPlayer` (**1 <= firstPlayer < secondPlayer <= n**): the number of the first best player.
- An integer `secondPlayer` (**1 <= firstPlayer < secondPlayer <= n**): the number of the second best player.

## Output Format
- An array of two integers: `[earliest_round, latest_round]` representing the earliest and latest possible round numbers in which `firstPlayer` and `secondPlayer` can compete against each other.

## Examples

### Input
`n = 11, firstPlayer = 2, secondPlayer = 4`<br/>

### Output
`[3, 4]`<br/>

**Explanation:**
- One possible scenario for the earliest round:
  - First round: `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11`
  - Second round: `2, 3, 4, 5, 6, 11`
  - Third round: `2, 3, 4` (they compete here)
- One possible scenario for the latest round:
  - First round: `1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11`
  - Second round: `1, 2, 3, 4, 5, 6`
  - Third round: `1, 2, 4`
  - Fourth round: `2, 4` (they compete here)

### Input
`n = 5, firstPlayer = 1, secondPlayer = 5`<br/>

### Output
`[1, 1]`<br/>

**Explanation:**
- The players numbered `1` and `5` compete in the first round. There is no way to make them compete in any other round.

## Constraints
- **2 <= n <= 28**
- **1 <= firstPlayer < secondPlayer <= n**

## Notes
- The outcome of matches between players other than `firstPlayer` and `secondPlayer` can be chosen arbitrarily to maximize or minimize the round in which the two best players meet.

