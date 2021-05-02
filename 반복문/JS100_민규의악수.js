function sol(n){
    var i = 0;
    var count = 1;
    var result = [];
    
    while(1){
        i += count;
        count ++;
        
        if(n<i){
            result.push(n-(i-(count-1)));
            result.push(count);
            
            break;
        }
    }
    return result;
}

var n = prompt();

console.log(sol(n));