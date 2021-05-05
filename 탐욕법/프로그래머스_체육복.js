function solution(n, lost, reserve) {
    var answer = 0;
    var student = {};
    
    for(var i=1;i<=n;i++){
        student[i] = 1;
    }
    
    for(var num in lost){
        for(var i in Object.keys(student)){
            if(Object.keys(student)[i]==lost[num]){
                student[parseInt(i)+1] -= 1;
            }
        }
    }
    
    for(var num in reserve){
        for(var i in Object.keys(student)){
            if(Object.keys(student)[i]==reserve[num]){
                student[parseInt(i)+1] += 1;
            }
        }
    }
    var values = Object.values(student);
    for(var clothes in values){
        if(values[clothes]==2 && values[clothes-1]==0){
            student[parseInt(clothes)+1] -= 1;
            student[parseInt(clothes)] += 1;
        }else if(values[clothes]==2 && values[parseInt(clothes)+1]==0){
            student[parseInt(clothes)+1] -= 1;
            student[parseInt(clothes)+2] += 1;
        }
    }
    
    for(var i in student){   
        if(student[i]>=1){
            answer++;
        }
    }
    return answer;
}