class Solution {
    public int totalElements(int[] arr) {
        int n=arr.length;
        int start=0;
        int maxLength=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.size()>2){
                map.put(arr[start],map.get(arr[start])-1);
                if(map.get(arr[start])==0){
                    map.remove(arr[start]);
                }
                start++;
            }
            maxLength=Math.max(maxLength,i-start+1);
        }
        return maxLength;
    }
}