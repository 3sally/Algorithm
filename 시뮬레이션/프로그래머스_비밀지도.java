class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[] answer = new String[n];
        
        for(int i = 0; i<n; i++){
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);
            
            if(binary1.length()<n){
                StringBuffer sb = new StringBuffer();
                sb.append(binary1);
                
                int left = n-binary1.length(); 
                for(int j = 0; j<left; j++){
                    sb.insert(0, "0");
                }
                binary1 = sb.toString();
            }
            
            if(binary2.length()<n){
                StringBuffer sb = new StringBuffer();
                sb.append(binary2);
                
                int left = n-binary2.length(); 
                for(int j = 0; j<left; j++){
                    sb.insert(0, "0");
                }
                binary2 = sb.toString();
            }
            
            String overlap = "";
            
            for(int j = 0; j<n; j++){
                int num = (binary1.charAt(j)-'0') + (binary2.charAt(j)-'0');
                if(num>0){
                    overlap += "#";
                }else{
                    overlap += " ";
                }
            }
            answer[i] = overlap;
        }
        
        return answer;
    }
}