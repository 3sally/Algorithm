import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2559_수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int maxSum = Integer.MIN_VALUE;

		for (int i = 0; i <= N - K; i++) {
			int sum = 0;
			int idx = i;
			for (int j = 0; j < K; j++) {
				sum += arr[idx++];
			}
			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}
