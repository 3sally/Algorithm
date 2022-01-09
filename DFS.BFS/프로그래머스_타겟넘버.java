class Solution {
    static int result;
    
    public int solution(int[] numbers, int target) {
        cal(numbers,target,0,0);
        return result;
    }
    
    public void cal(int[] numbers,int target,int idx, int sum){
        if(idx==numbers.length){
            if(sum==target)
                result++;
            return;
        }
        
        cal(numbers,target,idx+1,sum+numbers[idx]);
        cal(numbers,target,idx+1,sum-numbers[idx]);
    }
}