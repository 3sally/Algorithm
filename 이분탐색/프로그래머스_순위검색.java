import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map; 
    
    public int[] solution(String[] infos, String[] query) {
        int[] answer = new int[query.length];
        map = new HashMap<>();
        
        for(String info : infos){
            String[] arr = info.split(" "); // 띄어쓰기 기준으로 구분해서 배열로 만듬
            makeSentence(arr, "", 0);
        }
        
        for(String key : map.keySet()){
            Collections.sort(map.get(key)); // 점수 오름차순 정렬
        }
        
        for(int i = 0; i<query.length; i++){
            query[i] = query[i].replaceAll(" and ", ""); 
            String[] arr = query[i].split(" "); // 조건이랑 점수 구분 
            answer[i] = map.containsKey(arr[0]) ? search(arr[0], Integer.parseInt(arr[1])) : 0;
        }
        return answer;
    }

    private int search(String key, int score){
        List<Integer> scoreList = map.get(key);
        int start = 0; 
        int end = scoreList.size()-1;
        
        while(start<=end){
            int mid = (start + end) /2; 
            if(scoreList.get(mid)<score){
                start = mid +1; 
            }else{
                end = mid -1;
            }
        }
        
        return scoreList.size()-start;
    }
    
    
    // info가 포함될 수 있는 모든 문장 만들기
    private void makeSentence(String[] arr, String str, int cnt){
        if(cnt==4){
            if(!map.containsKey(str)){ // 이미 map에 이 문장이 없으면 새로 추가 
                List<Integer> list = new ArrayList<>();
                map.put(str, list);
            }
            map.get(str).add(Integer.parseInt(arr[4])); // 점수 등록
            return;
        }
        makeSentence(arr, str + "-", cnt+1); 
        makeSentence(arr, str + arr[cnt], cnt+1);
    }
}