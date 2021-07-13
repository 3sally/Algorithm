import java.util.*;


public class BackJoon_2576_홀수{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> oddNum = new ArrayList<Integer>();
	
		int arr[] = new int [7];
		int sum = 0;
		int j = 0;

		for(int i=0; i<7; i++) {
			arr[i] = sc.nextInt();
			
			if(arr[i]%2==1) {
				oddNum.add(arr[i]);
				sum += arr[i];
			}
		}
		
		if(oddNum.size()<1) {
			System.out.println("-1");
		}else {
			Collections.sort(oddNum);
			System.out.println(sum);
			System.out.println(oddNum.get(0));
			
		}
	}
}