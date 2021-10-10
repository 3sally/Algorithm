import java.io.*;
import java.util.*;

public class BOJ_1932_정수삼각형 {

	static int N, dp[];
	static BufferedReader br;
	static ArrayList<Integer> idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 삼각형의 크기
		idx = new ArrayList<Integer>();

		dp = new int[N * 2 + 1];
		Arrays.fill(dp, -1);
		dp[N] = Integer.parseInt(br.readLine());
		idx.add(N);
		DP();
		Arrays.sort(dp);
		System.out.println(dp[N * 2]);
	}

	private static void DP() throws IOException {
		StringTokenizer st = null;
		ArrayList<Integer> nextIdx = new ArrayList<Integer>();

		for (int i = 0; i < N - 1; i++) {

			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < idx.size(); j++) {

				if (!nextIdx.contains(idx.get(j) - 1))
					nextIdx.add(idx.get(j) - 1);
				if (!nextIdx.contains(idx.get(j) + 1))
					nextIdx.add(idx.get(j) + 1);

				if (dp[idx.get(j) - 1] == -1) {
					dp[idx.get(j) - 1] = dp[idx.get(j)] + Integer.parseInt(arr[j]);
				} else {
					dp[idx.get(j) - 1] = Math.max(dp[idx.get(j)] + Integer.parseInt(arr[j]), dp[idx.get(j) - 1]);
				}

				if (dp[idx.get(j) + 1] == -1) {
					dp[idx.get(j) + 1] = dp[idx.get(j)] + Integer.parseInt(arr[j + 1]);
				} else {
					dp[idx.get(j) + 1] = Math.max(dp[idx.get(j)] + Integer.parseInt(arr[j + 1]), dp[idx.get(j) + 1]);
				}
			}
			idx.clear();
			for (int n : nextIdx) {
				idx.add(n);
			}
			nextIdx.clear();
		}
	}
}
