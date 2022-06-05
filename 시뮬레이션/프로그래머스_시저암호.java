class Solution {
    
    public String solution(String s, int n){
        String answer = "";
        char[] ch = s.toCharArray();
        
        for(int i = 0; i<ch.length; i++){
            int num = ch[i]-'0'+48; 
            if(num==32){
                answer += " ";
                continue;
            }
            for(int j = 0; j<n; j++){
                if(num==90){
                    num=65;
                }else if(num==122){
                    num=97;
                }else{
                    num++;
                }
            }
            answer += (char)num;
        }
        
        
        return answer;
    }
}