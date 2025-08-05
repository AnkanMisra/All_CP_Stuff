
# Problem: Hamburgers

## Problem Description
Polycarpus loves hamburgers very much. He especially adores the hamburgers he makes with his own hands. Polycarpus thinks that there are only three decent ingredients to make hamburgers from: **bread**, **sausage** and **cheese**. He writes down the recipe of his favorite "Le Hamburger de Polycarpus" as a string of letters `'B'` (bread), `'S'` (sausage) and `'C'` (cheese). The ingredients in the recipe go from bottom to top, for example, recipe `"BSCBS"` represents the hamburger where the ingredients go from bottom to top as bread, sausage, cheese, bread and sausage again.

Polycarpus has `nb` pieces of bread, `ns` pieces of sausage and `nc` pieces of cheese in the kitchen. Besides, the shop nearby has all three ingredients, the prices are `pb` rubles for a piece of bread, `ps` for a piece of sausage and `pc` for a piece of cheese.

Polycarpus has `r` rubles and he is ready to shop on them. **What maximum number of hamburgers can he cook?** You can assume that Polycarpus cannot break or slice any of the pieces of bread, sausage or cheese. Besides, the shop has an unlimited number of pieces of each ingredient.

## Input Format

The first line of the input contains a **non-empty string** that describes the recipe of "Le Hamburger de Polycarpus". The length of the string doesn't exceed **100**, the string contains only letters `'B'` (uppercase English B), `'S'` (uppercase English S) and `'C'` (uppercase English C).

The second line contains three integers `nb`, `ns`, `nc` (**1 ≤ nb, ns, nc ≤ 100**) — the number of the pieces of bread, sausage and cheese on Polycarpus' kitchen.

The third line contains three integers `pb`, `ps`, `pc` (**1 ≤ pb, ps, pc ≤ 100**) — the price of one piece of bread, sausage and cheese in the shop.

Finally, the fourth line contains integer `r` (**1 ≤ r ≤ 10^12**) — the number of rubles Polycarpus has.

## Output Format

Print the **maximum number of hamburgers** Polycarpus can make. If he can't make any hamburger, print `0`.

## Examples

### Example 1
**Input:**
`BBBSSC`<br/>
`6 4 1`<br/>
`1 2 3`<br/>
`4`<br/>

**Output:**
`2`<br/>

### Example 2
**Input:**
`BBC`<br/>
`1 10 1`<br/>
`1 10 1`<br/>
`21`<br/>

**Output:**
`7`<br/>

### Example 3
**Input:**
`BSC`<br/>
`1 1 1`<br/>
`1 1 3`<br/>
`1000000000000`<br/>

**Output:**
`200000000001`<br/>

## Constraints
- Recipe string length: **1 ≤ length ≤ 100**
- Available ingredients: **1 ≤ nb, ns, nc ≤ 100**
- Ingredient prices: **1 ≤ pb, ps, pc ≤ 100**
- Available money: **1 ≤ r ≤ 10^12**
- Recipe contains only characters `'B'`, `'S'`, and `'C'`

## Notes
- Polycarpus **cannot break or slice** any of the pieces of bread, sausage or cheese
- The shop has an **unlimited number** of pieces of each ingredient
- For C++: Do not use `%lld` specifier for 64-bit integers. Use `cin`, `cout` streams or the `%I64d` specifier instead

