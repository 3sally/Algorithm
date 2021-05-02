function count(n){
    var cnt = 0;
    cnt = Math.floor(n/7);
    if((n%7)%3 == 0){
        cnt += (n%7)/3;
    }else{
        return "-1";
    }
    return cnt;
}

var N = prompt();

console.log(count(N));