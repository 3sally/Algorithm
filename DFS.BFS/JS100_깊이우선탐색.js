const graph = {
    'E': ['D', 'A'],
    'F': ['D'],
    'A': ['E', 'C', 'B'],
    'B': ['A'],
    'C': ['A'],
    'D': ['E','F']};
/*
dfs는 stack과 방문 여부 확인해서 해결
stack -> LIFO (시간 순서에 따라 자료가 쌓여서 가장 마지막에 삽입된 자료가 가장 먼저 삭제됨)
*/

function dfs(graph, start){ // 깊이 우선 탐색법
var stack = []; // 빈 스택 배열
var visited = []; // 방문 여부를 확인할 빈 배열

stack.push(start); // 먼저 start할 위치를 담아놓고 시작

while(stack.length!=0){ // stack에서 모두 pop 될 때까지 
    var n = stack.pop();
    if(!visited.includes(n)){ // 방문 여부 확인
        visited.push(n); 
        var x = graph[n].filter(x=>!visited.includes(x)); //처음 n에 연결된 노드 중 방문하지 않은 노드 
        for(var i in x){
            stack.push(x[i]); // stack에 push
        }
    }
}
return visited; // E A B C D F
}

console.log(dfs(graph,'E'));
profile
이민정