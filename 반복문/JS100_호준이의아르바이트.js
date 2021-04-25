function candy(score){
    var cnt = {};
    var result = 0;
    
    for(var i in score){
        cnt[score[i]] = 0;
    }
    
    for(var j in score){
        for(var k in Object.keys(cnt)){
            if(score[j] == Object.keys(cnt)[k]){
                cnt[score[j]] += 1;
            }	
        }
    }
    
    //3등까지만
    for(var c = Object.keys(cnt).length; c>Object.keys(cnt).length-3; c--){
        result += cnt[Object.keys(cnt)[c-1]];
    }
    return result;
}

var score = prompt().split(' ');

console.log(candy(score));