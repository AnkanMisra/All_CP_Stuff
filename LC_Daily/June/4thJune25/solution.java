class Solution {

    public String answerString(String word, int numFriends) {
        if (numFriends == 1)
            return word;

        String answer = "";
        int n = word.length();
        char maxChar = word.charAt(0);
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) > maxChar)
                maxChar = word.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == maxChar) {
                int trimFromLast = Math.max(0, numFriends - i - 1);
                String temp = word.substring(i, n - trimFromLast);
                if (temp.compareTo(answer) > 0)
                    answer = temp;
            }
        }

        return answer;
    }
}
