import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Stack<Integer> s = new Stack<>();
        for(int num : arr){
            s.push(num);
        }
        
        while(s.size()>1){
            // 뒤에 두개 최소공배수 구함 
            int n1 = s.pop();
            int n2 = s.pop();
            int a = Math.max(n1, n2);
            int b = Math.min(n1, n2);
            while(b!=0){
                int r = a%b;
                a = b; 
                b = r;
            }
            s.push(a*(n1/a)*(n2/a));   
        }
        return s.pop();
    }
}