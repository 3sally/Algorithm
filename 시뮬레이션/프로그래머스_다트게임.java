import java.util.*;

class Solution {
    public int solution(String dartResult) {
        List<Integer> scores = new LinkedList<Integer>();
        
        StringTokenizer st = new StringTokenizer(dartResult, "0|1|2|3|4|5|6|7|8|9", true);
        for(int i = 0; i < 3; i++){
            int sc = Integer.parseInt(st.nextToken());
            char[] effects = null;
            String str = st.nextToken();
            if(str.equals("0")){
                sc = 10;
                effects = st.nextToken().toCharArray();
            }else{
                effects = str.toCharArray();
            }
            
            
            for(char effect : effects){
                if(effect=='S'){
                    scores.add(sc);
                }else if(effect=='D'){
                    sc = (int)Math.pow(sc, 2);
                    scores.add(sc);
                }else if(effect=='T'){
                    sc = (int)Math.pow(sc, 3);
                    scores.add(sc);
                }else if(effect=='*'){
                    if(i==0){
                        scores.set(0, scores.get(0)*2);
                    }else{
                        scores.set(i, scores.get(i)*2);
                        scores.set(i-1, scores.get(i-1)*2);
                    }
                }else if(effect=='#'){
                    scores.set(i, scores.get(i)*(-1));
                }
            }
            
        }
        
        int answer = 0;
        for(int score : scores){
            answer += score;
        }
        
        return answer;
    }
}