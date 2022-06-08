class Solution {
    
    static String[] word = 
        {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    public int solution(String s) {
        String answer = "";
        
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            char c = ch[i];
            
            // 숫자인 경우
            if(c=='0' || c=='1' || c=='2' || c=='3' || c=='4' 
               || c=='5' || c=='6' || c=='7' || c=='8' || c=='9'){
                answer += c+"";
            }
            
            // 영어인 경우
            if(c=='z'){
                answer += 0+"";
                i += 3;
            }else if(c=='o'){
                answer += 1+"";
                i += 2;
            }else if(c=='t'){
                if(ch[i+1]=='w'){
                    answer += 2+"";
                    i += 2;
                }else if(ch[i+1]=='h'){
                    answer += 3+"";
                    i += 4;
                }
            }else if(c=='f'){
                if(ch[i+1]=='o'){
                    answer += 4+"";
                    i += 3;
                }else if(ch[i+1]=='i'){
                    answer += 5+"";
                    i += 3;
                }
            }else if(c=='s'){
                if(ch[i+1]=='i'){
                    answer += 6+"";
                    i += 2;
                }else if(ch[i+1]=='e'){
                    answer += 7+"";
                    i += 4;
                }
            }else if(c=='e'){
                answer += 8+"";
                i += 4;
            }else if(c=='n'){
                answer += 9+"";
                i += 3;
            }
        }
        
        return Integer.parseInt(answer);
    }
}