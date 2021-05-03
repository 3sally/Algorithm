function solution(genres, plays) {
    var answer = [];
    var total = {};
    var album = [];

    for(var i in genres){  //중복 제거한 객체 생성해줌 key가 장르 이름
        total[genres[i]] = 0;
    }
    
    var type = Object.keys(total);
 
    for(var i in type){  // 각 장르별 재생횟수 합산
        for(var j in genres){
            if(genres[j]==type[i]){
                total[type[i]] += plays[j];
            }
        }
    }

    for(var i in Object.values(total)){
        var genre = Object.keys(total).find(key => total[key] === Object.values(total).sort((a,b)=>b-a)[i]);  //제일 재생횟수가 많이된 장르부터
        var value = [];
        for(var j in genres){   // 제일 재생횟수가 많이된 장르의 각 재생횟수 확인
            if(genres[j]==genre){
                value.push(plays[j]);
            }
        }
        
        if(value.length == 1){
            album.push(value.shift());
        }else{
            value.sort((a,b)=>b-a);  // 내림차순 정렬
            for(var k=0; k<2; k++){   // 두개만 꺼내기
                album.push(value.shift());
            }
        }
        
    }
    
    for(var i in album){
        for(var j in plays){
            if(album[i]==plays[j]){
                  if(!answer.includes(parseInt(j))){
                    answer.push(parseInt(j));
                }
            }
        }
    }
    return answer;
}

var genres = ["classic", "pop", "classic", "classic", "pop"];
var plays = [500, 600, 800, 800, 2500];

console.log(solution(genres,plays)); //[4,1,3,0]