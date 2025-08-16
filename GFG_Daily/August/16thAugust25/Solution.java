class Solution {
    public String findLargest(int[] arr) {
        String[] strarr = new String[arr.length];
        for(int i=0;i<strarr.length;i++) {
            strarr[i]=String.valueOf(arr[i]);
        }
        Arrays.sort(strarr,(a,b)->(b+a).compareTo(a+b));
        if(strarr[0].equals("0"))
            return "0";
        StringBuilder str = new StringBuilder();
        for(String s: strarr) {
            str.append(s);
        }
        return str.toString();
    }
}
