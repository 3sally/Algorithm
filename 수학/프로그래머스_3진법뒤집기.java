class Solution {
    public int solution(int n) {
        StringBuffer sb = new StringBuffer();
        sb.append(Integer.toString(n,3));
        sb.reverse();

        int answer = Integer.parseInt(sb.toString(),3); 
        return answer;
    }
}