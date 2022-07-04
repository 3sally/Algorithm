import java.util.*;

class Solution {
    public List<String> solution(String[] records) {
        List<String> answer = new LinkedList<>();
        List<String[]> history = new LinkedList<>();
        
        HashMap<String, String> users = new HashMap<>();
        StringTokenizer st = null;
        for(String record : records){
            st = new StringTokenizer(record, " ");
            String order = st.nextToken();
            String id = st.nextToken();
            
            if(order.equals("Enter")){
                String name = st.nextToken();
                users.put(id, name); // 유저 추가 
                history.add(new String[]{id,"님이 들어왔습니다."});
            }else if(order.equals("Leave")){
                history.add(new String[]{id,"님이 나갔습니다."});
            }else{
                // change일 경우 
                String name = st.nextToken();
                users.put(id, name); // 유저 네임 변경
            }
        }
        
        
        for(String[] h : history){
            String str = users.get(h[0]) + h[1];
            answer.add(str);
        }
        return answer;
    }
}