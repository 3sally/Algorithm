class Solution {
    public int solution(String s) {
    
        int minLength = s.length();
        
        // s길이의 절반까지 검사
        for(int i = 1; i<=s.length()/2; i++){ // i => 문자 단위
            StringBuilder sb = new StringBuilder();

            String prev = s.substring(0,i);  // 처음
            int cnt = 1;
            for(int j = i; j<s.length(); j+=i){
                if(j+i>s.length()){
                    sb.append(s.substring(j, s.length()));
                    break;
                }

                String next = s.substring(j, j+i); // 비교 문자열
                if(prev.equals(next)){ // 같으면
                    cnt++;
                }else{
                    if(cnt>1){
                        sb.append(cnt).append(prev);
                    }else{
                        sb.append(prev);
                    }
                    cnt = 1;
                    prev = next;
                }
            }

          if(cnt>1){
                sb.append(cnt).append(prev);
          }else{
                sb.append(prev);
          }

            minLength = Math.min(minLength, sb.length());
        }

        return minLength;       
    }
}