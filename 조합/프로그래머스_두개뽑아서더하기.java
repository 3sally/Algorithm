import java.util.*;

class Solution {
    
    static int[] selected = new int[2];
    static boolean[] num = new boolean[200];
    
    public List<Integer> solution(int[] numbers) {
        comb(0,0, numbers);
        
        List<Integer> answer = new LinkedList<>();
        
        for(int i = 0; i<200; i++){
            if(num[i]){
                answer.add(i);
            }
        }
        return answer;
    }
    
    private void comb(int cnt, int start, int[] numbers){
        if(cnt==2){
            num[selected[0] + selected[1]] = true;
            return;        
        }
        
        for(int i = start; i<numbers.length; i++){
            selected[cnt] = numbers[i]; 
            comb(cnt+1, i+1, numbers);
        }
    }
}