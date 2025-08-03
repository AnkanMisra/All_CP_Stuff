class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int left = 0, right = 0, n = fruits.length, sum = 0, ans = 0;
        while(right<n){
            sum += fruits[right][1];
            while(left<=right && step(fruits,startPos,left,right)>k){
                sum -= fruits[left][1];
                left++;
            }
            ans = Math.max(ans,sum);
            right++;
        }
        return ans;
    }
    private int step(int[][] fruits,int startPos,int left,int right){
        return (Math.min(Math.abs(startPos-fruits[right][0]),Math.abs(startPos-fruits[left][0]))+
                fruits[right][0]-fruits[left][0]);
    }
}
