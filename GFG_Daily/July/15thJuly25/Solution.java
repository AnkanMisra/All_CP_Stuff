class Solution {
    public boolean divby13(String s) {
        int remainder = 0;
        for (int i = 0; i < s.length(); i++) { 
            int digit = s.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % 13;
        }
        return remainder == 0;
    }
}
