function solution(clothes) {
    var combination = 1;
    var cloth = {};
    for(var i in clothes){
        cloth[clothes[i][1]] = 0;   
        var type = clothes[i][1];
        for(var i in clothes){
            if(type == clothes[i][1]){
                cloth[clothes[i][1]]++;
            }
        }
    }    // key = 의상의 종류 , value = 종류별 개수
    
    for(var i in Object.values(cloth)){
        combination *= Object.values(cloth)[i]+1;  
        /*상의, 하의, 신발 이렇게 있으면 상의+하의, 하의+신발, 상의+신발 이렇게 입는 경우도 존재하므로 
        각각의 개수에 +1 해서 곱해줌*/
    }

    return combination-1; //아무것도 안 입는 경우는 존재하지 않으므로  -1 해줌
}

var clothes = 	[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]];

console.log(solution(clothes));