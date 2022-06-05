import java.util.*;

class Solution {
    
    public String[] solution(String[] strings, int n) {
        
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String nthS1 = s1.charAt(n) + "";
                String nthS2 = s2.charAt(n) + "";
                if(nthS1.equals(nthS2)){
                    return s1.compareTo(s2);
                }
                return nthS1.compareTo(nthS2);
            }
        });
            
            
        return strings;
    }
}