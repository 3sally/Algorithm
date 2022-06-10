import java.util.*;

class Solution {
    
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        
        int sum = 0;
        for(int i = 0; i<d.length; i++){
            sum += d[i];
            answer++;
            
            if(sum==budget){
                break;
            }
            
            if(sum>budget){
                answer--;
                break;
            }
        }
        
        return answer;
    }
    
   
}