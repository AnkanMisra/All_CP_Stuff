class Solution {
    public void rearrange(int [] arr, int x) {
        ArrayList<Integer>ar=new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        ar.add(arr[i]);
        Collections.sort(ar,(a,b)->{
            return Math.abs(a-x)-Math.abs(b-x);
        });
        for(int i=0;i<arr.length;i++)
        arr[i]=ar.get(i);

    }
}
