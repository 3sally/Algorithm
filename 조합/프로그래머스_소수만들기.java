class Solution {
    
    static int[] selected = new int[3];
    static int answer;
    
    public int solution(int[] nums) {
        answer = 0;
        
        comb(0,0,nums);

        return answer;
    }
    
    private void comb(int cnt, int start, int[] nums){
        if(cnt==3){
            int sum = 0;
            for(int i : selected){
                sum += i;
            }
            
            // 소수 check
            boolean isPrime = true; 
            for(int i = 2; i<(sum/2); i++){
                if(sum%i==0){
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime){
                answer++;
            }
            
            return;
        }
        
        for(int i = start; i<nums.length; i++){
            selected[cnt] = nums[i];
            comb(cnt+1, i+1, nums);
        }
    }
}