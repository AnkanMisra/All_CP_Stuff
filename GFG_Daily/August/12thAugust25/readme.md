
# Problem: Shop in Candy Store

## Problem Description
In a candy store, there are different types of candies available and `prices[i]` represent the price of `i`th types of candies. You are now provided with an attractive offer.

For every candy you buy from the store, you can get up to **k other different candies for free**. Find the **minimum and maximum amount of money** needed to buy all the candies.

**Note:** In both cases, you must take the **maximum number of free candies possible** during each purchase.

## Input Format
- `prices[]`: An array representing the price of different types of candies
- `k`: Maximum number of free candies you can get with each purchase

## Output Format
Return an array containing two integers `[minimum_cost, maximum_cost]` representing the minimum and maximum amount needed to buy all candies.

## Examples

### Example 1
**Input:** `prices[] = [3, 2, 1, 4], k = 2`<br/>

**Output:** `[3, 7]`<br/>

**Explanation:** According to the offer, if you buy one candy you can take at most k more for free. For **minimum cost**: buy the candy worth `1` and take candies worth `3` and `4` for free, also buy candy worth `2`. So min cost: `1 + 2 = 3`. For **maximum cost**: buy the candy worth `4` and take candies worth `1` and `2` for free, also buy candy worth `3`. So max cost: `3 + 4 = 7`.

### Example 2
**Input:** `prices[] = [3, 2, 1, 4, 5], k = 4`<br/>

**Output:** `[1, 5]`<br/>

**Explanation:** For **minimum cost**: buy the candy with cost `1` and get all other candies for free. For **maximum cost**: buy the candy with cost `5` and get all other candies for free.

## Constraints
- **1 ≤ prices.size() ≤ 10^5**
- **0 ≤ k ≤ prices.size()**
- **1 ≤ prices[i] ≤ 10^4**

