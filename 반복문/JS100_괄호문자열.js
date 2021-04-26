function check(sen){
    for(var i in sen){
        if(sen[i]=="("){
            left.push(sen[i]);
        }else if(sen[i]==")"){
            right.push(sen[i]);
        }
    }	
    
    if(left.length == right.length){
        for(var i in sen){
            if(sen[i]=="{"){
                left.push(sen[i]);
            }else if(sen[i]=="}"){
                right.push(sen[i]);
            }
        }	
        
        if(left.length == right.length){
            for(var i in sen){
                if(sen[i]=="["){
                    left.push(sen[i]);
                }else if(sen[i]=="]"){
                    right.push(sen[i]);
                }
            }	
            
        }else{
            return "NO";
        }
        
        
        if(left.length == right.length){
            return "YES"
        }else{
            return "NO"
        }
    }else{
        return "NO";
    }
    
}

var sen = prompt().split('');
var left = [];
var right = [];

console.log(check(sen));
