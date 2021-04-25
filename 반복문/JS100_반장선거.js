const student = prompt().split(' ');
	const votes = {};
	
	var count;
	for(var n in student){
		votes[student[n]] = count;
	}
	
	
	for(var i in Object.keys(votes)){
		count = 0;
		for(var j in student){  
			if(Object.keys(votes)[i]==student[j]){
				count += 1;
			}
		}
		votes[Object.keys(votes)[i]] = count;
	}
	
	const max_count = Math.max(...Object.values(votes));
	
	const banjang = Object.keys(votes).find(key => votes[key] == max_count);
	
	console.log(`${banjang}(이)가 총 ${max_count}표로 반장이 되었습니다`);