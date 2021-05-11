const n = prompt();
	
var arr = "";

for(var i=1;i<=n;i++){
        arr += i+",";
}
var r = arr.split(",");
var count = 0;

for(var i in r){
    if(r[i].includes(3)||r[i].includes(6)||r[i].includes(9)){
        count++;
        if(r[i].includes(0)||r[i].includes(1)||r[i].includes(2)||r[i].includes(4)||r[i].includes(5)||r[i].includes(7)||r[i].includes(8)){
            count--;
        }					
    }
}

console.log(count);