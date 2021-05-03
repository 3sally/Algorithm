const time_table = ["12:30", "13:20", "14:13"];
const current_time = "12:40";

function sol(time_table,current_time){
    const rest_time = [];
    
    for(var i in time_table){
        if(time_table[i]<current_time){
            rest_time.push("지나갔습니다");
        }else{
            var t = time_table[i].split(':');
            var c = current_time.split(':');

            console.log(minute);
            if(minute<0){
                minute += 60;
                time -= 1;
            }
            
            if(time.length!=2){
                time = "0" + time;
            }
            
            if(minute.length!=2){
                minute = "0"+minute;
            }
            var str = time + "시간 "+minute+"분";
            rest_time.push(str);
        }
    }
    return rest_time;		
}

console.log(sol(time_table,current_time));