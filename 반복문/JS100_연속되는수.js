function check(num){
    var arr = [];
    var n = num[0];
    for(var i in num){
        arr[i] = n;
        n++;
    }
    
    if(arr.join() == num.join()){
        return "YES";
    }else{
        return "NO";
    }
}

var num = prompt().split(' ');
num.sort();

console.log(check(num));