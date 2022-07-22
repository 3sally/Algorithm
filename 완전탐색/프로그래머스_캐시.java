import java.util.*; 

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        List<String> cache = new LinkedList<>(); // 캐시
        
        for(int i = 0; i<cities.length; i++){
            String city = cities[i].toLowerCase(); // 도시 이름 - 대소문자 구분 안함, 다 소문자로 통일
            
            if(cache.contains(city)){ // 도시 포함하고 있으면
                answer += 1; // cache hit
                
                // 최상단으로 이동!!!
                int idx = cache.indexOf(city);
                cache.remove(idx);
                cache.add(city);
            }
            else{ // 도시 포함하고 있지 않으면
                answer += 5; // cache miss
                
                if(cacheSize==0){ // 캐시크기 0인경우 처리
                    continue;
                }
                // cache size 확인 
                if(cache.size()==cacheSize){ // 캐시크기랑 같으면
                    cache.remove(0); // 먼저 넣은거 빼고
                    cache.add(city); // 도시 추가
                }else if(cache.size()<cacheSize){ // 캐시크기보다 작으면
                    cache.add(city); // 바로 넣기
                }
            }
            
        }
        
        return answer;
    }
}