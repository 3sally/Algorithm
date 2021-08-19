import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1247_최적경로 {

	static int N, minDistance;
	static int[][] company, home, customer, order;
	static boolean[] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine()); // 고객의 수

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			company = new int[1][2];
			company[0][0] = Integer.parseInt(st.nextToken());
			company[0][1] = Integer.parseInt(st.nextToken());

			home = new int[1][2];
			home[0][0] = Integer.parseInt(st.nextToken());
			home[0][1] = Integer.parseInt(st.nextToken());

			customer = new int[N][2];
			for (int i = 0; i < N; i++) {
				customer[i][0] = Integer.parseInt(st.nextToken());
				customer[i][1] = Integer.parseInt(st.nextToken());
			}

			// 방문할 순서 순열로
			isVisited = new boolean[N];
			order = new int[N][2];
			minDistance = Integer.MAX_VALUE;
			visit(0);
			sb.append(minDistance).append("\n");
		}
		System.out.println(sb);
	}

	private static void visit(int cnt) {
		if (cnt == N) {
			// 순열 다 만들어지면
			// 이동거리 구하기
			move();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (isVisited[i])
				continue;
			order[cnt][0] = customer[i][0];
			order[cnt][1] = customer[i][1];
			isVisited[i] = true;
			visit(cnt + 1);
			isVisited[i] = false;

		}
	}

	private static void move() {
		int distance = 0;
		for (int i = 0; i < order.length; i++) {
			if (i == 0)
				distance += Math.abs(company[0][0] - order[i][0]) + Math.abs(company[0][1] - order[i][1]);
			else if (i == (order.length - 1)) {
				distance += Math.abs(order[i - 1][0] - order[i][0]) + Math.abs(order[i - 1][1] - order[i][1]);
				distance += Math.abs(order[i][0] - home[0][0]) + Math.abs(order[i][1] - home[0][1]);
			} else
				distance += Math.abs(order[i - 1][0] - order[i][0]) + Math.abs(order[i - 1][1] - order[i][1]);
		}
		minDistance = Math.min(minDistance, distance);
	}
}
