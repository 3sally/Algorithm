function solution(array, commands) {
    var answer = [];
    for(var n=0;n<commands.length;n++){  
        var i = commands[n][0]; 
        var j = commands[n][1]; 
        var k = commands[n][2]; 
        
        /*
        array = [1,2,3,4,5,6,7];
        array.slice(2,5); // 결과 => 2번째 인덱스부터 5번째 인덱스 전까지
        				  // [3,4,5]
        */
        var arr = array.slice(i-1,j); 
        arr.sort(function(a,b){  // 오름차순 정렬
            return a-b;
        });
        answer.push(arr[k-1]);
    }
    return answer;
}

//예제
var array = [1, 5, 2, 6, 3, 7, 4];
var commands = [[2, 5, 3], [4, 4, 1], [1, 7, 3]];

console.log(solution(array,commands));