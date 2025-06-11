
class Solution {
    public int findLength(int[] color, int[] radius) {
        Stack<int[]> st = new Stack<>();
        
        for(int i = 0 ; i < color.length ; i++){
            boolean flag = false;
            while(!st.isEmpty()){
                int[] top = st.peek();
                if(top[0] == color[i] && top[1] == radius[i]){
                    st.pop();
                    flag = true;
                }
                else
                break;
            }
         if(flag)
          {
             continue;
          }
          else
          st.push(new int[]{color[i],radius[i]});
            
        }
        return st.size();
    }
}
