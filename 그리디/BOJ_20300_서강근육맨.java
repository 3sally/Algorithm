import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20300_서강근육맨 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		long[] health = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			health[i] = Long.parseLong(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(health);

		long max = 0;

		if (N % 2 == 0) {
			for (int i = 0; i < N / 2; i++) {
				max = Math.max(max, health[i] + health[N - 1 - i]);
			}
		} else {
			for (int i = 0; i < (N - 1) / 2; i++) {
				max = Math.max(max, health[i] + health[N - 2 - i]);
			}
		}

		System.out.println(max);
	}
}
