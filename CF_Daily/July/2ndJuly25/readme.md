# Problem: Two Buttons

## Problem Description
Vasya has found a strange device. On the front panel of a device there are: **a red button, a blue button and a display showing some positive integer**. After clicking the **red button**, device **multiplies the displayed number by two**. After clicking the **blue button**, device **subtracts one from the number** on the display. If at some point **the number stops being positive, the device breaks down**. The display can show arbitrarily large numbers. Initially, the display shows number `n`.

Bob wants to **get number `m` on the display**. What **minimum number of clicks** he has to make in order to achieve this result?

## Input Format
The first and the only line of the input contains **two distinct integers `n` and `m`** (`1 ≤ n, m ≤ 10^4`), separated by a space.

## Output Format
Print a single number — **the minimum number of times one needs to push the button** required to get the number `m` out of number `n`.

## Examples

### Example 1
**Input:** `4 6`<br/>
**Output:** `2`<br/>

### Example 2
**Input:** `10 1`<br/>
**Output:** `9`<br/>

## Constraints
- `1 ≤ n, m ≤ 10^4`
- `n` and `m` are distinct integers

## Notes
- In the first example you need to push the **blue button once** (4 → 3), and then push the **red button once** (3 → 6).
- In the second example, **doubling the number is unnecessary**, so we need to push the **blue button nine times** (10 → 9 → 8 → 7 → 6 → 5 → 4 → 3 → 2 → 1).
- The device **breaks down if the number becomes non-positive**, so careful planning is required.

