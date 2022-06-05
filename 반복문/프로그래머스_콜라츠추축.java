class Solution {
    public int solution(int num) {
        int cnt = 0;
        long n = (long)num;
        
        while(cnt<500){
            if(n==1){
                return cnt;
            }   
            
            if(n%2==0){
                n /= 2;
            }else{
                n *= 3; 
                n += 1;
            }
            
            cnt++;
        }
        return -1;
    }
}