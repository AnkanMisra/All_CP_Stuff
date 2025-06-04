# 3403. Find the Lexicographically Largest String From the Box I

## Problem Statement
You are given a string `word` and an integer `numFriends`.

Alice is organizing a game for her `numFriends` friends. There are multiple rounds in the game, where in each round:
- `word` is split into `numFriends` non-empty strings, such that no previous round has had the exact same split.
- All the split words are put into a box.

Find the **lexicographically largest string** from the box after all the rounds are finished.

## Input Format
- `word`: A string consisting of lowercase English letters (`1 <= word.length <= 5000`).
- `numFriends`: An integer (`1 <= numFriends <= word.length`).

## Output Format
Return the lexicographically largest string from the box.

## Examples

### Example 1
Input:  
word = "dbca", numFriends = 2  

Output:  
"dbc"  

Explanation:  
All possible splits are:  
- "d" and "bca".  
- "db" and "ca".  
- "dbc" and "a".  

The lexicographically largest string is "dbc".

### Example 2
Input:  
word = "gggg", numFriends = 4  

Output:  
"g"  

Explanation:  
The only possible split is: "g", "g", "g", and "g".  
The lexicographically largest string is "g".

## Constraints
- `1 <= word.length <= 5000`
- `word` consists only of lowercase English letters.
- `1 <= numFriends <= word.length`
