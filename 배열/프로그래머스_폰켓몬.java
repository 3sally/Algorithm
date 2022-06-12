class Solution {

    public int solution(int[] nums) {
        int[] poketmon = new int[200001];
        int types = 0;
        for(int n : nums){
            if(poketmon[n]==0){
                types++;
            }
            poketmon[n]++;
        }
        
        int getCnt = nums.length/2;
        if(types>=getCnt){
            return getCnt;
        }else{
            return types;
        }
    }
}