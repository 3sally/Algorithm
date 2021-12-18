import java.io.*;

public class BOJ_4097_수익 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;

			int max = Integer.MIN_VALUE;
			int sum = 0;
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(br.readLine());
				sum += n;
				max = Math.max(sum, max);
				if (sum < 0)
					sum = 0;
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
