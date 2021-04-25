const month = prompt('월');
	var day = parseInt(prompt('일'));
	
	const m = [31,29,31,30,31,30,31,31,30,31,30,31];
	const d = ['WEN','THU','FRI','SAT','SUN','MON','TUE'];
	
	for(var i=0; i<month-1; i++){
		day += m[i];
	}
	
	date = day%7-1;

	console.log(d[date]);