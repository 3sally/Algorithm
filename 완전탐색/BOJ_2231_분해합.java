import java.io.*;

public class BOJ_2231_분해합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int M = 1;
		while (true) {
			int sum = 0;
			sum += M;

			String s = M + "";
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - '0';
			}

			if (sum == N) {
				System.out.println(M);
				break;
			}

			if (M > N) {
				System.out.println(0);
				break;
			}

			M++;

		}

	}
}
