class Solution {
    public String solution(String new_id) {
        System.out.println(new_id);
        //1단계
        String id_1 = new_id.toLowerCase();
        
        //2단계
        String id_2 = "";
        for(int i = 0; i<id_1.length(); i++){
            if(id_1.charAt(i)-'0'>48 && id_1.charAt(i)-'0'<75){
                id_2 += id_1.charAt(i);
            }
            
            if(id_1.charAt(i)-'0'>=0 && id_1.charAt(i)-'0'<10){
                id_2 += id_1.charAt(i);
            }
            
            if(id_1.charAt(i)=='-' || id_1.charAt(i)=='_' || id_1.charAt(i)=='.'){
                id_2 += id_1.charAt(i);
            }
        }
        
        //3단계
        String id_3 = "";
        boolean isStop = false;
        for(int i = 0; i<id_2.length(); i++){
            if(id_2.charAt(i)=='.'){
                if(!isStop){
                    id_3 += id_2.charAt(i);
                    isStop = true;
                }
            }else{
                id_3 += id_2.charAt(i);
                isStop = false;
            }
        }
        
        //4단계 
        if(id_3.length()>0 && id_3.charAt(0)=='.'){
            id_3 = id_3.substring(1,id_3.length());
        }
        
        if(id_3.length()>0 && id_3.charAt(id_3.length()-1)=='.'){
            id_3 = id_3.substring(0,id_3.length()-1);
        }
        String id_4 = id_3;
        
        
        //5단계
        String id_5= id_4;
        if(id_4.length()==0){
            id_5 += "a";
        }
        
        //6단계
        String id_6 = id_5;
        if(id_6.length()>=16){
            id_6 = id_6.substring(0,15);
            if(id_6.charAt(id_6.length()-1)=='.'){
                id_6 = id_6.substring(0,id_6.length()-1);
            }
        }
        
        //7단계
        String id_7 = id_6;
        if(id_7.length()<=2){
            while(id_7.length()<3){
                id_7 += id_6.charAt(id_6.length()-1);
            }
        }
        
        return id_7;
    }
}