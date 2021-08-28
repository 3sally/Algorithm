import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4698_테네스의특별한소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());

		// 에라토스테네스의 체
		boolean[] prime = new boolean[1000001];
		// 소수는 false
		prime[0] = prime[1] = true;

		for (int i = 2; i * i <= 1000000; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= 1000000; j += i)
					prime[j] = true;
			}
		}

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine(), " ");
			String D = st.nextToken();
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int sosu = 0;

			for (int i = A; i <= B; i++) {

				if (!prime[i] && Integer.toString(i).contains(D)) {
					sosu++;
				}
			}
			sb.append(sosu).append("\n");
		}
		System.out.println(sb);
	}
}
