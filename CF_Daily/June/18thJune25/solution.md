# Solution Explanation

## Intuition
The problem requires processing a string character by character based on whether it's a vowel or a consonant, and then applying specific formatting rules. Vowels are "A", "O", "Y", "E", "U", "I" (case-insensitive). Consonants should be preceded by a dot and converted to lowercase.

## Approach
1.  **Define Vowels**: Create a string or a set containing all uppercase and lowercase vowels for easy lookup.
2.  **Iterate Through String**: Process the input string character by character.
3.  **Check Character Type**: For each character:
    *   If the character is a vowel (case-insensitive check), skip it (delete it).
    *   If the character is a consonant:
        *   Append a `.` to the result string.
        *   Convert the consonant to its lowercase equivalent.
        *   Append the lowercase consonant to the result string.
4.  **Print Result**: After processing all characters, print the accumulated result string.

## Complexity
-   **Time Complexity**: O(N * V) or O(N) depending on vowel check, where N is the length of the input string and V is the number of vowels (constant, 12 in this case for AOYEUI case-insensitive).
    *   `String.indexOf()` takes O(V) time. The total loop is O(N * V). Since V is small (12), this is effectively O(N).
    *   Using a `HashSet` for vowels would make lookup O(1) on average, resulting in O(N) total time.
-   **Space Complexity**: O(N) for storing the `result` string. Using a `StringBuilder` for `result` would still be O(N) but more efficient for string concatenation.

## Summary
The solution directly implements the given rules by iterating through the input string, identifying vowels and consonants, and appending formatted consonants to a new result string. This straightforward approach correctly solves the problem.

```java
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in); // Create a Scanner object for input
    String s = sc.next(); // Read the input string
    String result = ""; // Initialize an empty string to build the result
    String vowels = "AOYEUIaoeyui"; // Define all vowels (uppercase and lowercase) for easy checking

    // Iterate through each character of the input string
    for (char c : s.toCharArray()) {
      // Check if the current character 'c' is NOT a vowel
      // indexOf() returns -1 if the character is not found in the 'vowels' string
      if (vowels.indexOf(c) == -1) {
        result += "."; // If it's a consonant, append a dot
        result += Character.toLowerCase(c); // Append the lowercase version of the consonant
      }
      // If 'c' is a vowel, it is implicitly "deleted" by not being added to 'result'
    }
    System.out.println(result); // Print the final resulting string
  }
}
```
