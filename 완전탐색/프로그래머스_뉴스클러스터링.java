import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        
        //string -> char 배열로 변경
        char[] str1Arr = str1.toLowerCase().toCharArray();
        char[] str2Arr = str2.toLowerCase().toCharArray();
        
        // 2글자씩 끊어서 리스트에 저장
        List<String> str1List = new LinkedList<>();
        List<String> str2List = new LinkedList<>();
        StringBuilder sb = null;
        
        // 배열 1
        for(int i = 0; i<str1Arr.length-1; i++){
            char c1 = str1Arr[i];
            char c2 = str1Arr[i+1];
            
            // 영문자로 이루어진거만 리스트에 저장
            // 49 - a, 74 - z
            if(c1-'0'>48 && c1-'0'<75 && c2-'0'>48 && c2-'0'<75){
                sb = new StringBuilder();
                sb.append(c1).append(c2);
                str1List.add(sb.toString());
            }
        }
        
        // 배열 2
        for(int i = 0; i<str2Arr.length-1; i++){
            char c1 = str2Arr[i];
            char c2 = str2Arr[i+1];
            
            // 49 - a, 74 - z
            if(c1-'0'>48 && c1-'0'<75 && c2-'0'>48 && c2-'0'<75){
                sb = new StringBuilder();
                sb.append(c1).append(c2);
                str2List.add(sb.toString());
            }
        }
        
        List<String> same = new LinkedList<>(); //교집합
        
        for(String s : str1List){
            if(str2List.contains(s)){ // 겹치는게 있으면 
                same.add(s); // 교집합에 저장 
                str2List.remove(s); // 2번째 배열에서 겹쳤던 문자 제거 (중복체크 방지)
            }
        }
        
        double total = str1List.size()+str2List.size(); // 합집합
        
        if(total!=0){
            answer *= ((double)same.size()/total);
        }
        
        return answer;
    }
}