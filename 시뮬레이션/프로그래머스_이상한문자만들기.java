import java.util.*;

class Solution {
    static StringBuilder sb;
    public String solution(String s) {
        sb = new StringBuilder();
        int blankCnt = 0;
        String word = "";
        
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i)==' '){
                if(!word.equals("")){
                    changeWord(word);
                    word = "";
                }
                blankCnt++;        
            }else{
                if(blankCnt>0){
                    for(int j = 0; j<blankCnt; j++){
                        sb.append(" ");
                    }
                    blankCnt = 0;
                }
                
                word += s.charAt(i) +"";
            }
        }
        
        if(blankCnt>0){
             for(int j = 0; j<blankCnt; j++){
                sb.append(" ");
            }
        }
        
        if(!word.equals("")){
            changeWord(word);
        }
        
        return sb.toString();
    }
    
    private void changeWord(String word){
        
        String newWord = "";
        
        for(int i = 0; i<word.length(); i++){
            if(i%2!=0){
                newWord += Character.toLowerCase(word.charAt(i));
            }else{
                newWord += Character.toUpperCase(word.charAt(i));
            }
        }
        sb.append(newWord);
    }
}