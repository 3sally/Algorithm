import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13305_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		long[] dist = new long[N - 1];
		long[] cost = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cost[i] = Long.parseLong(st.nextToken());
		}

		long totalCost = 0;
		long minCost = cost[0];

		for (int i = 0; i < N - 1; i++) {
			if (cost[i] < minCost) {
				minCost = cost[i];
			}
			totalCost += minCost * dist[i];
		}

		System.out.println(totalCost);
	}
}
