import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int len = sizes.length;
        
        List<Integer> w = new LinkedList<>();
        List<Integer> h = new LinkedList<>();
        
        for(int i = 0; i<len; i++){
            w.add(Math.max(sizes[i][0], sizes[i][1]));
            h.add(Math.min(sizes[i][0], sizes[i][1]));
        }
        
        Collections.sort(w);
        Collections.sort(h);
        
        int answer = w.get(len-1)* h.get(len-1);
        return answer;
    }
}