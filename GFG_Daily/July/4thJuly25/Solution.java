class Solution {
    public int countAtMostK(int arr[], int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int right=0,left=0,i=0;
        int result=-1;
        int n=arr.length;
        while(right<n){
            map.put(arr[right],map.getOrDefault(arr[right],0)+1);
            
            while(map.size()>k){
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0){
                    map.remove(arr[left]);
                }
                left++;
            }
            result+=right-left+1;
            right++;
        }
        return result+1;
    }
}