import java.util.*;

//에라토스테네스의 체
class Solution {
    static boolean prime[] = new boolean[1000001];
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
    
    public int solution(int n) {       
        // 소수는 false
        // 1은 소수가 아니므로 제외
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=n; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<=n; j+=i) prime[j]=true;                
            }        
        }    
        
        // 소수 출력
        for(int i=1; i<=n;i++){
        	if(!prime[i]) prime_numbers.add(i);     
        }
        
        return prime_numbers.size();
       
    }
}