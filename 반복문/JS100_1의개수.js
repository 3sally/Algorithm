var arr = [];
var count = 0;

for(var i=0;i<=1000;i++){
    arr[i] = i;
}

var arr_2 = arr.join('').split('');

for(var i in arr_2){
    if(arr_2[i] == 1){
        count++;
    }
}

console.log(count);