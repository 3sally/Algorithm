function solution(citations) {
    var citations = citations.sort((a,b)=>b-a); //내림차순 정렬
    for(var h=citations.length;h>=0;h--){  // h의 후보 -> 0~citations.length
        var cnt = 0;
        for(var j in citations){
            if(h<=citations[j]){  // 인용횟수가 h번 이상이면
                cnt ++;  // h번 이상 인용된 논문 수 증가
            }
        }
        if(cnt>=h){  // h번 이상 인용된 논문 수가 h편 이상이면
            return h;  // h 리턴,,,
        }
    }
}

//예제
var citations = [3, 0, 6, 1, 5];

console.log(solution(citations));