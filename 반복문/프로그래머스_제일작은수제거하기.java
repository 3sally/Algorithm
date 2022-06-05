import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        
        List<Integer> answer = new LinkedList<>();
        
        if(arr.length==1){
            answer.add(-1);
        }else{푸
            int idx = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++){
                if(arr[i]<min){
                    idx = i; 
                    min = arr[i];
                }
            }
            
            for(int i = 0; i < arr.length; i++){
                if(i==idx){
                    continue;
                }
                answer.add(arr[i]);
            } 
            
        }
        
        return answer;
    }
}