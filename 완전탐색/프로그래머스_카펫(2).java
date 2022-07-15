class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2]; // 가로, 세로 길이 
        
        int x = 0; // 가로
        int y = 0; // 세로
        
        // 가로 최대 길이는 brown/2보다 항상 작으므로 brown/2부터 시작 
        for(int i = brown/2; i>0; i--){ 
            x = i; 
            y = (brown-2*i)/2 + 2;
            
            if(x*y==brown+yellow){ // 가로*세로가 brown+yellow랑 같으면 조건 만족
                answer[0] = x; 
                answer[1] = y; 
                break;
            }
        }
        return answer;
    }
}