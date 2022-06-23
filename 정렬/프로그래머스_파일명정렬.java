import java.util.*;

class Solution {
    static class File implements Comparable<File>{
        String head; 
        String number; 
        String tail;
        
        public File(String head, String number, String tail){
            this.head = head; 
            this.number = number; 
            this.tail = tail;
        }
        
        @Override
		public String toString() {
			return head + number + tail;
		}
        
        @Override
        public int compareTo(File file){
            String head1 = this.head.toLowerCase();
            String head2 = file.head.toLowerCase();
            int number1 = Integer.parseInt(this.number);
            int number2 = Integer.parseInt(file.number);
            
            if(head1.equals(head2)){
                return number1-number2;
            }
            return head1.compareTo(head2);
        }
        
    }
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        List<File> fileList = new LinkedList<>();
        
        for(String file : files){
            String head = "";
            String number = "";
            String tail = "";
            
            char[] ch = file.toCharArray();
            int numIdx = 0;
            
            for(int i = 0; i<ch.length; i++){
                char c = ch[i];
                if(c-'0'>=0 && c-'0'<10){
                    numIdx = i;
                    break;
                }
                head += c;
            }
            
            int tailIdx = numIdx;
            for(int i = numIdx; i<numIdx+5; i++){
                if(i<ch.length){
                    char c = ch[i];
                    if(c-'0'>=0 && c-'0'<10){
                        number += c;
                    }else{
                        tailIdx = i;
                        break;
                    }   
                }
            }
            
            if(tailIdx==numIdx){ // 5개 다 숫자였던 경우 
                tailIdx += 5; 
            }
            
            if(tailIdx<ch.length){
                tail = file.substring(tailIdx, file.length());
            }
            
            fileList.add(new File(head, number, tail));
        }
        Collections.sort(fileList);
        for(int i = 0; i< files.length; i++){
            answer[i] = fileList.get(i).toString();
        }
        return answer;
    }
}