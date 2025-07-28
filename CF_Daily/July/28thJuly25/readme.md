
# Problem: Winner

## Problem Description
The winner of the card game **"Berlogging"** is determined by specific rules. If only one player has the **maximum number of points** at the end, they win. However, if **multiple players tie** with the maximum score `m`, the winner is the one who **reached at least `m` points first** during the game.

During each round, players gain or lose points recorded as `"name score"` where:
- `name` is the player's name
- `score` is points gained (negative means points lost)

All players start with **0 points**, and it's guaranteed that at least one player has positive points at the end.

## Input Format

The first line contains integer `n` **(1 ≤ n ≤ 1000)** - the number of rounds.

Next `n` lines contain round information in format `"name score"` in **chronological order**, where:
- `name` is a string of lowercase Latin letters **(length 1-32)**
- `score` is an integer **(-1000 ≤ score ≤ 1000)**

## Output Format

Print the **name of the winner**.

## Examples

### Example 1
**Input:**<br/>
`3`<br/>
`mike 3`<br/>
`andrew 5`<br/>
`mike 2`<br/>

**Output:**<br/>
`andrew`<br/>

### Example 2
**Input:**<br/>
`3`<br/>
`andrew 3`<br/>
`andrew 2`<br/>
`mike 5`<br/>

**Output:**<br/>
`andrew`<br/>

## Constraints
- **1 ≤ n ≤ 1000**
- Player names: **1-32 lowercase Latin letters**
- Score per round: **-1000 ≤ score ≤ 1000**
- At least one player has **positive final score**

## Notes
The key insight is that when multiple players tie with the maximum final score, we need to determine who **reached that score threshold first** during the chronological sequence of rounds.

