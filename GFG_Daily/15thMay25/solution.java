class Solution {
    public int countSubstring(String s) {
       HashMap<Character,Integer>map=new HashMap<>(26);
        int count=0;
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
           if(map.containsKey(ch)){
               count+=map.get(ch);
           }
        }
        return count;
    }
}