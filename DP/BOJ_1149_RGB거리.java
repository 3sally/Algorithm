package hwalgo18_서울_07반_이민정;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1149_RGB거리 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());

		int[][] costs = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다
		for (int i = 1; i < N; i++) {
			costs[i][0] += Math.min(costs[i - 1][1], costs[i - 1][2]);
			costs[i][1] += Math.min(costs[i - 1][0], costs[i - 1][2]);
			costs[i][2] += Math.min(costs[i - 1][1], costs[i - 1][0]);
		}

		System.out.println(Math.min(Math.min(costs[N - 1][0], costs[N - 1][1]), costs[N - 1][2]));
	}
}
