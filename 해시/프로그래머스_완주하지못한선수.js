function solution(participant, completion) {
    var fail = '';
    participant.sort();
    completion.sort();
    for(var num in participant){
        if(participant[num] != completion[num]){
            fail = participant[num];
            return fail;
        }
    }
}

var participant = ["leo", "kiki", "eden"];
var completion = ["eden", "kiki"];

console.log(solution(participant,completion));