function solution(answers) {
    var answer = [];
    var score = [0,0,0]; 
    var user1 = [1,2,3,4,5];
    var user2 = [2,1,2,3,2,4,2,5];
    var user3 = [3,3,1,1,2,2,4,4,5,5];  
    
    for(var i=0; i<answers.length; i++){  
        if(answers[i] == user1[i%5]){   //i%5 이렇게 하는 이유 answer length보다 user1의 length가 더 작을 수 있으므로 이렇게 순환? 시켜준다 이해하면 될듯!!
            score[0]++;
        }
        if(answers[i] == user2[i%8]){
            score[1]++;
        }
        if(answers[i] == user3[i%10]){
            score[2]++;
        }
    }
    
    let max_correct = Math.max(...score);
    for(var i in score){
        if(score[i]==max_correct){
            answer.push(parseInt(i)+1);
        }
    }
    
    return answer; //오름차순 정렬
}

var answers = [1,2,3,4,5];

console.log(solution(answers));