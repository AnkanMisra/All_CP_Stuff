class Solution {
    public int minMaxDifference(int num) {
        String maxStr = Integer.toString(num);
        String minStr = maxStr;
        int index = 0;
        while (index < maxStr.length() && maxStr.charAt(index) == '9') {
            index++;
        }
        if (index < maxStr.length())
            maxStr = maxStr.replace(maxStr.charAt(index), '9');
        minStr = minStr.replace(minStr.charAt(0), '0');
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}
