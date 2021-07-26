import java.util.*;


public class BOJ_2309_일곱난쟁이{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> all = new ArrayList<Integer>();
		int sum = 0;
		
		for(int i=0;i<9;i++) {
			all.add(sc.nextInt());
			sum += all.get(i);
		}
		
		int minusHeight = sum-100;
		
		for(int i=0; i<all.size(); i++) {
			for(int j=i+1; j<all.size(); j++) {
				if(all.get(i)+all.get(j)==minusHeight) {
					all.remove(i);
					all.remove(j-1);
					break;
				}
			}
		}
		
		Collections.sort(all);
		
		for(int i:all) {
			System.out.println(i);
		}
	}
}