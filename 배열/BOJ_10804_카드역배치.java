
import java.util.Scanner;

public class BOJ_10804_카드역배치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int []arr = new int[20];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = i+1; //1-20까지 배열에 집어 넣기  
		}
		
		//arr = 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20
		
		for(int i = 0; i<10; i++) {
			int start = sc.nextInt(); // 5
			int end = sc.nextInt(); // 10
			int temp;
			int e = end;
			
			for(int j=start; j<=end; j++) {
				if((j-1)<(e-1)) {					
					temp = arr[j-1];
					arr[j-1] = arr[e-1];
					arr[e-1] = temp;
					e--;
				}
			}
		}
			for(int num : arr) {				
				System.out.print(num + " ");
			}
	}
}
