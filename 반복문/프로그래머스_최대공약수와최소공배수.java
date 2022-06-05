class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        boolean canDivide = true;
        int maxDivide = 1; 
        int minMultiple = 1;
       
        while(canDivide){
            canDivide = false;
            
            int small = Math.min(n,m);
            
            for(int i = 2; i<=small; i++){
                if(n%i==0 && m%i==0){
                    canDivide = true;
                    maxDivide *= i;
                    n /= i; 
                    m /= i; 
                    break;
                }
            }
        }
        minMultiple = maxDivide * n * m; 
        
        answer[0] = maxDivide;
        answer[1] = minMultiple;
        
        return answer;
    }
}