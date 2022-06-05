class Solution {
    public long solution(long n) {
        String num = n + "";
        long sum = 0;
        
        for(int i = 0; i<num.length(); i++){
            sum += num.charAt(i)-'0';
        }
        
        return sum;
    }
}