const graph = {
    'E': ['D', 'A'],
    'F': ['D'],
    'A': ['E', 'C', 'B'],
    'B': ['A'],
    'C': ['A'],
    'D': ['E','F']};
/*
bfs는 queue과 방문 여부 확인해서 해결
queue -> FIFO (들어온 순서대로 나감)
*/

function bfs(graph, start){ // 깊이 우선 탐색법
var queue = []; // 빈 스택 배열
var visited = []; // 방문 여부를 확인할 빈 배열

queue.push(start); // 먼저 start할 위치를 담아놓고 시작

while(queue.length!=0){ // queue에서 모두 shift 될 때까지 
    var n = queue.shift(); // shift -> 배열의 앞에서부터 뽑기 , pop -> 배열의 뒤에서부터 뽑기
    if(!visited.includes(n)){ // 방문 여부 확인
        visited.push(n); 
        var x = graph[n].filter(x=>!visited.includes(x)); //처음 n에 연결된 노드 중 방문하지 않은 노드 
        for(var i in x){
            queue.push(x[i]); // queue에 push
        }
    }
}
return visited; // E D A F C B
}

console.log(bfs(graph,'E'));