import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        List<Integer> nums = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(s, " ");
        while(st.hasMoreTokens()){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(nums);
        answer.append(nums.get(0)).append(" ").append(nums.get(nums.size()-1));
        return answer.toString();
    }
}