
# Problem: Spreadsheets

## Problem Description
In popular spreadsheet systems (like Excel), columns are numbered using a specific system. The first column is **A**, the second is **B**, continuing to **Z** for column 26. Then two-letter numbers begin: column 27 is **AA**, 28 is **AB**, and column 52 is **AZ**. After **ZZ**, three-letter numbers follow, and so on.

Rows are marked by **integer numbers starting with 1**. The cell name is the **concatenation of the column and row numbers**. For example, `BC23` represents the cell in column 55, row 23.

Sometimes another numeration system is used: **RXCY format**, where `X` and `Y` are integer numbers showing the **column and row numbers** respectively. For instance, `R23C55` is the cell from the previous example.

Your task is to write a program that reads cell coordinates and **converts each item to the other numeration system**.

## Input Format

**Input:** `n` (number of coordinates), followed by `n` lines of coordinates<br/>

- First line contains integer `n` (`1 ≤ n ≤ 10^5`)
- Next `n` lines contain cell coordinates in either format

## Output Format

**Output:** `n` lines with coordinates converted to the other system<br/>

- Each line contains the cell coordinates in the **opposite numeration system**

## Examples

### Input
```
2
R23C55
BC23
```

### Output
```
BC23
R23C55
```

## Constraints
- `1 ≤ n ≤ 10^5`
- All coordinates are **correct**
- No cells with column and/or row numbers larger than **10^6**

## Notes
- **Excel format:** Letters for columns (A, B, ..., Z, AA, AB, ...), numbers for rows
- **RXCY format:** R followed by row number, C followed by column number
- The program must **detect the input format** and convert to the other format

