

# Problem: Fox And Names

## Problem Description
Fox Ciel wants to determine whether the list of authors on her paper can be considered **lexicographically sorted** after rearranging the order of the Latin alphabet. Two names are compared by scanning from the left until the first differing character. The name whose character comes **earlier in the modified alphabet** is smaller. If one name is a **prefix** of the other, the shorter one is smaller.
Given a list of distinct lowercase names, decide if there exists an **ordering of the 26 lowercase letters** that makes the list sorted. If it exists, output **any** such ordering; otherwise, output `Impossible`.

## Input Format
- An integer **`n`** — the number of names.
- **`n`** lines follow, each containing one name consisting of lowercase Latin letters.

## Output Format
- If a valid alphabet ordering exists, output a **permutation of `a`–`z`** describing that order.
- Otherwise, output the single word `Impossible`.

## Constraints
- **`1 ≤ n ≤ 100`**
- **`1 ≤ |name_i| ≤ 100`**
- All names are distinct.

## Examples

### Example 1
**Input:**
`3`<br/>
`rivest`<br/>
`shamir`<br/>
`adleman`

**Output:**
`bcdefghijklmnopqrsatuvwxyz`

### Example 2
**Input:**
`10`<br/>
`tourist`<br/>
`petr`<br/>
`wjmzbmr`<br/>
`yeputons`<br/>
`vepifanov`<br/>
`scottwu`<br/>
`oooooooooooooooo`<br/>
`subscriber`<br/>
`rowdark`<br/>
`tankengineer`

**Output:**
`Impossible`

## Notes
- Construct a **directed graph** of character precedences derived from adjacent names, then perform a **topological sort** to find an alphabet order.
- If the graph contains a cycle or a name is a prefix of a shorter preceding name, no valid ordering exists.


