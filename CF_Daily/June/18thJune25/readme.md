# A. String Task

## Problem Statement

Petya needs to write a program that processes a given string (consisting of uppercase and lowercase Latin letters) according to these rules:
1.  Deletes all vowels.
2.  Inserts a character "." before each consonant.
3.  Replaces all uppercase consonants with corresponding lowercase ones.

Vowels are defined as "A", "O", "Y", "E", "U", "I". All other letters are consonants.
The program's input is a single string, and it should return the processed string.

## Input Format

- The first line contains a string `s` (length from 1 to 100), consisting only of uppercase and lowercase Latin letters.

## Output Format

- Print the resulting string. It is guaranteed that this string is not empty.

## Examples

### Input
tour

### Output
.t.r

---

### Input
Codeforces

### Output
.c.d.f.r.c.s

---

### Input
aBAcAba

### Output
.b.c.b

## Explanation

- In the first example:
    - `t` is consonant, becomes `.t`
    - `o` is vowel, deleted
    - `u` is vowel, deleted
    - `r` is consonant, becomes `.r`
    - Result: `.t.r`

- In the second example:
    - `C` (consonant) -> `.c`
    - `o` (vowel) -> delete
    - `d` (consonant) -> `.d`
    - `e` (vowel) -> delete
    - `f` (consonant) -> `.f`
    - `o` (vowel) -> delete
    - `r` (consonant) -> `.r`
    - `c` (consonant) -> `.c`
    - `e` (vowel) -> delete
    - `s` (consonant) -> `.s`
    - Result: `.c.d.f.r.c.s`
