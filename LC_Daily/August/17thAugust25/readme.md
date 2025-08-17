
# Problem: New 21 Game

## Problem Description
Alice plays a game loosely based on the card game "21". Alice starts with **0 points** and draws numbers while she has **less than k points**. During each draw, she gains an integer number of points randomly from the range `[1, maxPts]`, where `maxPts` is an integer. Each draw is independent and the outcomes have **equal probabilities**.

Alice **stops drawing numbers when she gets k or more points**.

Return the **probability that Alice has n or fewer points**.

## Input Format

- `n`: Maximum allowed points
- `k`: Points threshold to stop drawing
- `maxPts`: Maximum points per draw

## Output Format

Return the probability as a double. Answers within `10^-5` of the actual answer are considered accepted.

## Examples

### Example 1
**Input:** `n = 10, k = 1, maxPts = 10`<br/>

**Output:** `1.00000`<br/>

**Explanation:** Alice gets a single card, then stops.

### Example 2
**Input:** `n = 6, k = 1, maxPts = 10`<br/>

**Output:** `0.60000`<br/>

**Explanation:** Alice gets a single card, then stops. In 6 out of 10 possibilities, she is at or below 6 points.

### Example 3
**Input:** `n = 21, k = 17, maxPts = 10`<br/>

**Output:** `0.73278`<br/>

## Constraints
- `0 <= k <= n <= 10^4`
- `1 <= maxPts <= 10^4`

