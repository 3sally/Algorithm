const num = prompt();
	
	function sol(num){
		if(num>1){
			for(var i=2; i<num; i++){
				if(num%i == 0){
					console.log("NO");
					return false;
				}
			}
			console.log("YES");
		}else{
			console.log("NO");
		}	
	}
	
 	sol(num);