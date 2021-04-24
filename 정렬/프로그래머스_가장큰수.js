function solution(numbers) {
	var answer = '';
	numbers = numbers.map((v)=>v+"").sort((a,b)=>(b+a)-(a+b)); 
    //map((v)=>v+"") => 각 숫자들을 문자로 변환(1->"1")
    //sort((a,b)=>(b+a)-(a+b)) => 문자로 변환된 숫자를 연결하여 비교정렬 ('3','30' => ('303')-('330'))
	numbers[0]==='0'?answer+=0:answer=numbers.join(""); //만약 배열이 0으로만 구성되어 있으면 0만 출력
	return answer;
}


//예제
var numbers = [3, 30, 34, 5, 9];

console.log(solution(numbers));  //9534330