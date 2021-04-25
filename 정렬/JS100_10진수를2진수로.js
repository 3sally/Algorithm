const num = prompt();
	const arr = [];
	var i;
	function change(num){
		while(num>2){
			i = num%2;
			arr.unshift(i);
			num = Math.floor(num/2);
		}
		arr.unshift(10);
		
		return arr.join('');
	}
	
	console.log(change(num));