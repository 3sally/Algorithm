function solution(n, computers) {
    var network = 0; //네트워크 수
    var visited = []; //computer에 방문했는지를 확인
    
    for(var computer in computers){
        visited[computer] = false;  //처음엔 다 방문하지 않은 상태이므로 false
    }

    //재귀 방식 사용 (직접 손으로 따라 그려보면서 이해하면 쉬움)
    function DFS(i){
        visited[i] = true; //방문했음으로 변경
        for(var j=0; j<n; j++){
            if(computers[i][j]==1&&!visited[j]){ //네트워크가 연결된 상태이고 방문하지 않은 곳이면
                DFS(j); //그 곳 다시 방문,,? 설명을 어떻게 써야할지 모르겠다
            } 
        }
    }

    for(var i=0; i<n; i++){
        if(!visited[i]){
            DFS(i); //방문하지 않은 상태면 함수 실행
            network++; //네트워크 개수 +1
        }
    }
    return network;
}

//예제
var n = 3;
var computers =[[1, 1, 0], [1, 1, 0], [0, 0, 1]];

console.log(solution(n,computers)); //2가 출력되어야함