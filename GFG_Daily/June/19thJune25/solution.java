class Solution {
    public static String caseSort(String s) {

        StringBuilder res=new StringBuilder();
        List<Character> upper=new ArrayList<>();
        List<Character> lower=new ArrayList<>();
        for(char c: s.toCharArray()){
            if(c>='a' && c<='z') lower.add(c);
            else upper.add(c);
        }
        Collections.sort(upper);
        Collections.sort(lower);
        int i=0;
        int n=s.length();
        int j=0;
        int k=0;
        while(i<n){
            char c=s.charAt(i);
            if(c>='A' && c<='Z'){
                res.append(String.valueOf(upper.get(j++)));
            }else res.append(String.valueOf(lower.get(k++)));
            i++;
        }
        return res.toString();
        
    }
}
