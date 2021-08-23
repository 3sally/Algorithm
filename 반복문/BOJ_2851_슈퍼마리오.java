import java.io.*;

public class BOJ_2851_슈퍼마리오 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] mushroom = new int[10];
		int sum = 0;

		for (int i = 0; i < 10; i++) {
			mushroom[i] = Integer.parseInt(br.readLine());
			sum += mushroom[i];
			if (sum == 100) {
				System.out.println(sum);
				System.exit(0);
			} else if (sum > 100) {
				if ((sum - 100) <= (100 - (sum - mushroom[i])))
					System.out.println(sum);
				else if ((sum - 100) > (100 - (sum - mushroom[i])))
					System.out.println(sum - mushroom[i]);
				System.exit(0);
			}
		}
		System.out.println(sum);
	}
}
