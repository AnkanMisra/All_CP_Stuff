
# Solution Explanation

## Intuition
The main idea is that if we sort the folder paths lexicographically, all sub-folders of a folder will appear immediately after their parent folder. This allows us to efficiently identify and skip sub-folders by checking if the current folder starts with the last added folder plus a `/`.

## Approach
- **Sort** the list of folder paths lexicographically. This ensures that any sub-folder will come right after its parent folder.
- **Iterate** through the sorted list:
  - For each folder, check if it is a sub-folder of the last folder added to the result list by verifying if it starts with the last folder plus a `/`.
  - If it is **not** a sub-folder, add it to the result list.
  - If it **is** a sub-folder, skip it.
- **Return** the result list containing only the top-level folders.

## Complexity
- **Time Complexity:** `O(n log n + L)`, where `n` is the number of folders and `L` is the total length of all folder strings. Sorting takes `O(n log n)`, and checking prefixes for all folders takes `O(L)`.
- **Space Complexity:** `O(n + L)`, for storing the result and the sorted folder list.

## Summary
By sorting the folder paths, we can efficiently remove all sub-folders in a single pass. The key insight is that sub-folders will always follow their parent in lexicographical order, so we only need to compare each folder with the last added top-level folder. This approach is both simple and optimal for the problem constraints.

