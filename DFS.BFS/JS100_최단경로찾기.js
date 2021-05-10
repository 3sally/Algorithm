const graph = {
    'A': ['B', 'C'],
    'B': ['A', 'D', 'E'],
    'C': ['A', 'F'],
    'D': ['B'],
    'E': ['B', 'F'],
    'F': ['C', 'E']};
/* 
queue를 사용해서 해결해보았음
자식 node로 이동할때마다 부모 node의 cnt+1을 해줌으로써 최단 거리 계산	
*/

function short_length(graph, start, end){ // 깊이 우선 탐색법
var queue = []; // 빈 스택 배열
var visited = []; // 방문 여부를 확인할 빈 배열
var cnt = {}; // 거리 계산된 값 저장하는 map 만듬 key는 부모노드들 value가 거리 count

queue.push(start); // 먼저 start할 위치를 담아놓고 시작
for(var i in Object.keys(graph)){
    cnt[Object.keys(graph)[i]] = 0;
} 
/*cnt = {
    A : 0
    B : 0
    C : 0
    D : 0
    E : 0
    F : 0
*/	
while(queue.length!=0){ // queue에서 모두 shift 될 때까지 
    var n = queue.shift(); // shift -> 배열의 앞에서부터 뽑기 , pop -> 배열의 뒤에서부터 뽑기
    if(n==end){  // 찾고자하는 값이면 cnt value 리턴
        return cnt[n];
    }else{
        if(!visited.includes(n)){ // 방문 여부 확인
            visited.push(n); 
            var x = graph[n].filter(x=>!visited.includes(x)&&!queue.includes(x)); //처음 n에 연결된 노드 중 방문하지 않은 노드 
            for(var i in x){
                queue.push(x[i]); // queue에 push
                cnt[x[i]] = cnt[n] + 1; //부모노드의 value +1
            }
        }	
    }
    
}
}

var test = prompt().split(' ');
var start = test[0];
var end = test[1];

console.log(short_length(graph,start,end));
