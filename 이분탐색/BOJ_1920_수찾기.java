import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

	static int N, A[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		// 오름차순 정렬
		Arrays.sort(A);

		long mid = A[N / 2];

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (binarySearch(num)) {
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb);
	}

	private static boolean binarySearch(int num) {
		int left = 0;
		int right = N - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (num < A[mid]) {
				right = mid - 1;
			} else if (num > A[mid]) {
				left = mid + 1;
			} else if (num == A[mid]) {
				return true;
			}
		}
		return false;

	}
}
