
# Problem: Remove Sub-Folders from the Filesystem

## Problem Description
Given a list of **folders** `folder`, return the folders after **removing all sub-folders** in those folders. You may return the answer in any order.

If a `folder[i]` is located within another `folder[j]`, it is called a **sub-folder** of it. A sub-folder of `folder[j]` must start with `folder[j]`, followed by a `/`. For example, `"/a/b"` is a sub-folder of `"/a"`, but `"/b"` is not a sub-folder of `"/a/b/c"`.

The format of a path is one or more concatenated strings of the form: `/` followed by one or more lowercase English letters.
- For example, `"/leetcode"` and `"/leetcode/problems"` are valid paths while an empty string and `/` are not.

## Input Format
- **Input:** A list of unique folder paths `folder` where each path starts with `/` and contains only lowercase letters and `/`.

## Output Format
- **Output:** The list of folders after removing all sub-folders. The answer can be in any order.

## Examples

### Input
`folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]`<br/>

### Output
`["/a","/c/d","/c/f"]`<br/>

**Explanation:** Folders `"/a/b"` is a subfolder of `"/a"` and `"/c/d/e"` is inside of folder `"/c/d"` in our filesystem.

### Input
`folder = ["/a","/a/b/c","/a/b/d"]`<br/>

### Output
`["/a"]`<br/>

**Explanation:** Folders `"/a/b/c"` and `"/a/b/d"` will be removed because they are subfolders of `"/a"`.

### Input
`folder = ["/a/b/c","/a/b/ca","/a/b/d"]`<br/>

### Output
`["/a/b/c","/a/b/ca","/a/b/d"]`<br/>

## Constraints
- **1 <= folder.length <= 4 * 10^4**
- **2 <= folder[i].length <= 100**
- Each `folder[i]` contains only lowercase letters and `/`.
- Each `folder[i]` always starts with the character `/`.
- **Each folder name is unique.**

