var n = ["ABCDEF", "BCAD", "ADEFQRX", "BEDFG", "EFGHZ"];
const rule = "ABD";
rule.split('');

const result = [];

for(var i in n){
    var block = n[i].split('');
    var arr = "";
    
    for(var j in block){
        if(rule.includes(block[j])){
            arr += block[j];
        }
    }
    console.log(arr);
    if(arr.length == 0 ||rule.includes(arr)||arr=="AD"){	
        result.push("가능");
    }else{
        result.push("불가능");		
    }
}

console.log(result);