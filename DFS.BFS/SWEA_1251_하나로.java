import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine()); // 섬의 개수
			double[] X = new double[N]; // 각 섬들의 X좌표
			double[] Y = new double[N]; // 각 섬들의 Y좌표

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				X[i] = Double.parseDouble(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				Y[i] = Double.parseDouble(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine());

			double[][] adjMatrix = new double[N][N];
			double[] minEdge = new double[N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					double dist = Math.sqrt(Math.pow((X[i] - X[j]), 2) + Math.pow((Y[i] - Y[j]), 2));

					adjMatrix[i][j] = Math.pow(dist, 2);
				}
				minEdge[i] = Double.MAX_VALUE;
			}

			boolean[] visited = new boolean[N];
			double cost = 0;

			minEdge[0] = 0;

			for (int i = 0; i < N; i++) {
				double min = Double.MAX_VALUE;
				int minVertex = -1;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}

				if (visited[minVertex] == true)
					continue;
				visited[minVertex] = true;
				cost += min * E;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}

			sb.append(Math.round(cost)).append("\n");
		}
		System.out.println(sb);
	}
}
