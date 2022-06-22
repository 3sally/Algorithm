class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0; // 설치할 기지국 개수 
        int range = w*2 + 1; // 전파 전달 범위
        int check = 1; // 처음부터 확인
        int apartCnt = 0;
        
        for(int station : stations){
            if((station-w) > check){ 
                apartCnt = (station-w)-check;
                if(apartCnt%range==0){
                    answer += apartCnt/range;
                }else{
                    answer += (apartCnt/range)+1;
                }
            }
            check = station + w + 1;
        }
        
        // 마지막까지 전파전달 다 안된 경우
        if(check<=n){
            apartCnt = n-check+1;
            if(apartCnt%range==0){
                answer += apartCnt/range;
            }else{
                answer += (apartCnt/range)+1;
            }
        }
        
        return answer;
    }
}