
# Problem: Maximum Matching of Players With Trainers

## Problem Description
You are given two 0-indexed integer arrays: `players` and `trainers`. The value `players[i]` represents the ability of the ith player, and `trainers[j]` represents the training capacity of the jth trainer.

A player can be matched with a trainer if the player's ability is **less than or equal to** the trainer's training capacity. Each player can be matched with **at most one trainer**, and each trainer can be matched with **at most one player**.

Your task is to **return the maximum number of matchings** between players and trainers that satisfy these conditions.

## Input Format
- An integer array `players` of length `n`, where `players[i]` is the ability of the ith player.
- An integer array `trainers` of length `m`, where `trainers[j]` is the training capacity of the jth trainer.

## Output Format
- An integer representing the **maximum number of matchings** that can be formed.

## Examples

### Input
players = [4, 7, 9], trainers = [8, 2, 5, 8]<br/>

### Output
2<br/>

### Input
players = [1, 1, 1], trainers = [10]<br/>

### Output
1<br/>

## Constraints
- `1 <= players.length, trainers.length <= 100000`
- `1 <= players[i], trainers[j] <= 1000000000`

## Notes
- Each player and each trainer can be matched at most once.
- This problem is the same as 445: Assign Cookies.

