class Solution{
    String minSum(int[] arr) {
    int n = arr.length;
    int sum = 0;
    if(n == 1) return String.valueOf(arr[0]);
    if(n == 2) return String.valueOf(arr[0]+arr[1]);
    
    Arrays.sort(arr);
    StringBuilder a = new StringBuilder();
    StringBuilder b = new StringBuilder();
    
    for(int i=0; i<n; i++){
        if(i % 2 == 0){
            a.append(arr[i]);
        }
        else b.append(arr[i]);
    }
    return sum(a, b).toString();
}

StringBuilder sum(StringBuilder a, StringBuilder b){
    int m = a.length(), n = b.length();
    if(m < n) a.insert(0,0);
    else b.insert(0,0);
    
    int carry = 0;
    a.reverse();
    b.reverse();
    StringBuilder ans = new StringBuilder();
    
    for(int i=0; i<a.length(); i++){
        int val = a.charAt(i)-'0'+b.charAt(i)-'0'+carry;
        ans.append(val%10);
        carry = val/10;
    }
    ans.reverse();
    while(ans.charAt(0) == '0'){
        ans.deleteCharAt(0);
    }
    return ans;
}
}
