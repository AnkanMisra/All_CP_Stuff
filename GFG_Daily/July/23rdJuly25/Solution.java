class Solution {
    public int subarraySum(int[] arr)
    {
        int len = arr.length;
        int sum  = 0;
        for(int i=0;i<len;i++)
        {
            sum+=arr[i]*(i+1)*(len-i);
        }
        return sum;
    }
}
