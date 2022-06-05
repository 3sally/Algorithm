import java.util.*;

class Solution {
    public long solution(long n) {
        String num = n + "";
        int[] arr = new int[num.length()];
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i<num.length(); i++){
            arr[i] = num.charAt(i)-'0';
        }
        
        Arrays.sort(arr);
        
        for(int i : arr){
            sb.append(i);
        }
        
        return Long.parseLong(sb.reverse().toString());
    }
}