import java.util.*;

class Solution {
    public String solution(String s) {
        Character[] arr = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
             arr[i] = s.charAt(i);
        }
       
        Arrays.sort(arr, new Comparator<Character>(){
            @Override
            public int compare(Character c1, Character c2){
                return c2.compareTo(c1);
            }
        });
        
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
             answer += arr[i];
        }
        
       
        return answer;
    }
}