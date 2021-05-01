function solution(brown, yellow) {
    var width; // 가로
    var height; // 세로
    
    var total = brown+yellow;
    
    for(height=1; height<total; height++){
        if(total%height==0){
            width = total/height;
        }
        
        if((width+height-2) == (brown/2)){
            return [width,height];
         }
    }
}  
 
var brown = 24;  
var yellow = 24;   

console.log(solution(brown,yellow)); 