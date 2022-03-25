import java.io.*;

public class BOJ_1748_수이어쓰기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int plus = 1;
		int sum = 0;
		int num = 10;

		for (int i = 1; i <= N; i++) {
			if (i % num == 0) {
				plus++;
				num *= 10;
			}
			sum += plus;
		}

		System.out.println(sum);

	}
}
