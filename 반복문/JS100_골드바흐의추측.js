var num = prompt();
	
function sol(){
    if(num<=2 && num%2!=0){
        return "-1";	
    }else{
        var arr = [];
        
        for(var i=2;i<=Math.floor(num/2);i++){
            var raw = [];	
            var j = num-i;
            if(j!=1){
                raw.push(i);
                raw.push(j);
                arr.push(raw);
            }
        }	
        result(arr);
    }
}

function result(arr){
    for(var k in arr){
        var i = arr[k][0];
        
        for(var n=2;n<i;n++){
            if(i%n==0){
                delete arr[k];
            }
        }
    }
    
    for(var k in arr){
        var j = arr[k][1];
        
        for(var n=2;n<j;n++){
            if(j%n==0){
                delete arr[k];
            }
        }
    }			

    console.log(arr);
}


sol(num);