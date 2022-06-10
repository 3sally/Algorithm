import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i<=right; i++){
            int num = i; 
            List<Integer> divides = new LinkedList<>();
            for(int j = 1; j<= num; j++){
                if(num%j==0){
                    if(!divides.contains(j)){
                        divides.add(j);
                    }
                    
                    if(!divides.contains(num/j)){
                        divides.add(num/j);
                    }
                }
            }
            
            if(divides.size()%2==0){
                answer += num;
            }else{
                answer -= num;
            }
        }
        return answer;
    }
}