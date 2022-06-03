class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        boolean[] numbers = new boolean[46];
        for(int num : win_nums){
            numbers[num] = true;
        }
        
        int maxRank = 0;
        int minRank = 0;
        
        int zeroCnt = 0;
        int matchCnt = 0;
        
        for(int i = 0; i<6; i++){
            if(lottos[i]==0){
                zeroCnt++;
                continue;
            }
            
            if(numbers[lottos[i]]){
                matchCnt++;
            }
            
        }
        
        //최고 순위 
        answer[0] = (7-(matchCnt+zeroCnt))>=6?6:(7-(matchCnt+zeroCnt));
        //최저 순위
        answer[1] = (7-matchCnt)>=6?6:(7-matchCnt);
          
        return answer;
    }
}