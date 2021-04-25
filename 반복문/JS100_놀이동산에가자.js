const limit_weight = prompt('제한 무게');
	const people = prompt('친구들 수');
	const weight = [];
	for(var i = 0; i<people; i++){
		weight[i] = prompt('몸무게');
	}
	
	function riding(weight){
		var n = 0;
		var count = 0;
		
		for(var i in weight){
			count += 1;
			n += parseInt(weight[i]);
	
			if(n>limit_weight){
				return count-1;
			}
		}
	}
	
	console.log(riding(weight));
