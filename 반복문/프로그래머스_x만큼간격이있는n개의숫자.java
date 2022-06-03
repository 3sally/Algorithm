import java.util.*;

class Solution {
    public List<Long> solution(int x, int n) {
        List<Long> answer = new LinkedList<>();
        
        long num = x; 
        for(int i = 0; i<n ;i++){
            answer.add(num);
            num += x;
        }
        return answer;
    }
}