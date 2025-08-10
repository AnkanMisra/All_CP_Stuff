class Solution {
    public double medianOf2(int a[], int b[]) {
        ArrayList<Integer>list = new ArrayList<>();
        for(int i = 0;i<a.length;i++){
            list.add(a[i]);
        }
          for(int i = 0;i<b.length;i++){
            list.add(b[i]);
        }
        Collections.sort(list);
        double median = 0;
        if(list.size()%2==1){
             return list.get(list.size()/2 );
        } else{
            double left = list.get(list.size()/2);
            double right = list.get(list.size()/2-1);
            median = (left+right)/2.0;
        }
        return median;
    }
}

