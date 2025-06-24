# Problem: A. Boredom

## Problem Description

Alex doesn't like boredom. That's why whenever he gets bored, he comes up with games. One long winter evening he came up with a game and decided to play it.

Given a sequence `a` consisting of `n` integers. The player can make several steps. In a single step, he can choose an element of the sequence (let's denote it `ak`) and delete it. At that, all elements equal to `ak + 1` and `ak - 1` must also be deleted from the sequence. That step brings `ak` points to the player.

Alex is a perfectionist, so he decided to get as many points as possible. Help him.

## Input Format

- The first line contains integer `n` (1 ≤ n ≤ 10^5) — the number of numbers in Alex's sequence.
- The second line contains `n` integers `a1, a2, ..., an` (1 ≤ ai ≤ 10^5).

## Output Format

- Print a single integer — the maximum number of points that Alex can earn.

## Examples

### Example 1

**Input:**  
2  
1 2  

**Output:**  
2  

### Example 2

**Input:**  
3  
1 2 3  

**Output:**  
4  

### Example 3

**Input:**  
9  
1 2 1 3 2 2 2 2 3  

**Output:**  
10  

## Notes

- In the third test example, at the first step we need to choose any element equal to 2. After that step, our sequence looks like this [2, 2, 2, 2]. Then we do 4 steps, on each step we choose any element equal to 2. In total, we earn 10 points.
