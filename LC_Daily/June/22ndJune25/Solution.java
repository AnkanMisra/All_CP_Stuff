
class Solution {
    public String[] divideString(String s, int k, char fill) {
        // Convert string to character array for iteration
        char[] letters = s.toCharArray();

        // Temporary string builder to store a substring of length k
        StringBuilder subpart = new StringBuilder();

        int index = 0; // Index for result array

        // Calculate the size of the output array (number of groups)
        int length = s.length() % k == 0 ? (s.length() / k) : ((s.length() / k) + 1);
        String[] resultant = new String[length];

        // Iterate through each character in the string
        for (char letter : letters) {
            // When current group reaches size k, store it and reset builder
            if (subpart.length() == k) {
                resultant[index++] = subpart.toString();
                subpart.setLength(0); // Clear the StringBuilder
            }
            subpart.append(letter); // Add current character
        }

        // If there are remaining characters after loop, fill with 'fill' char
        if (!subpart.isEmpty()) {
            while (subpart.length() < k) {
                subpart.append(fill); // Pad with fill character
            }
            resultant[index] = subpart.toString(); // Add last group
        }

        return resultant; // Return the result array
    }
}
