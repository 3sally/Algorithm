class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int nameLen = name.length();
        
        
        int change = 0; //문자가 바뀌는 횟수
        int move = nameLen-1; //커서가 이동하는 횟수(최대 오른쪽으로 쭉 간 횟수)
        
        for(int i = 0; i<nameLen; i++){
            int nextCnt = name.charAt(i)-'A'; // 다음 알파벳으로 움직이는 경우
            int prevCnt = 'Z'-name.charAt(i)+1; //이전 알파벳으로 움직이는 경우 
            
            change += Math.min(nextCnt, prevCnt); // 두 경우 중 최소인 경우 더함
            
            int idx = i+1;
            while(idx<nameLen && name.charAt(idx)=='A'){
                idx++;
            }

            move = Math.min(move, i*2 + (nameLen-idx)); // 오른쪽으로 이동하다가 왼쪽으로 꺾기
            move = Math.min(move, i + (name.length() - idx) * 2); // 왼쪽으로 이동하다가 오른쪽으로 꺾기
        }
        
        answer = change + move;
        return answer;
    }
}