import java.util.*;

class Solution {
    
    static class Lose{
        int stage;
        double lose;
        
        public Lose(int stage, double lose){
            this.stage = stage;
            this.lose = lose;
        }        
    }
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int totalUser = stages.length;
        Lose[] lose = new Lose[N];
        
        double[] play = new double[N+1];
        for(int n : stages){
            if(n>N)
                continue;
            play[n]++;
        }
        
        int user = 0;
        for(int i=1; i<=N; i++){
            if(play[i]==0){
                lose[i-1] = new Lose(i,0);
                continue;
            }
            lose[i-1] = new Lose(i,play[i]/(double)(totalUser-user));
            user += play[i];
        }
        
        Arrays.sort(lose, ((o1, o2)->Double.compare(o2.lose,o1.lose)));
        
        int idx = 0;
        for(Lose n : lose){
            answer[idx++] = n.stage;
        }
    
        
        return answer;
    }
}