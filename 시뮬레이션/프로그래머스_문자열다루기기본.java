class Solution {
    public boolean solution(String s) {
        if(s.length()!=4 && s.length()!=6){
            return false;
        }
        
        for(int i = 0; i<s.length(); i++){
            try{
                Integer.parseInt(s.substring(i, i+1));
                continue;
            }catch(NumberFormatException e){
                return false;
            }
        }
        
        return true;
    }
}