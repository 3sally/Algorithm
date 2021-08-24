import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3289_서로소집합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] parents = new int[N + 1];

			// 모든 원소를 자산이 대표자가 되도록~!
			make(N, parents);

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int CAL = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				if (CAL == 0) { // union(A,B)
					union(A, B, parents);
				} else if (CAL == 1) { // find(A,B)
					// 각 그룹의 대표자 찾기
					if (find(A, parents) == find(B, parents))
						sb.append("1");
					else
						sb.append("0");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void make(int N, int[] parents) {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a, int[] parents) {
		if (a == parents[a])
			return a;
		return parents[a] = find(parents[a], parents);
	}

	private static void union(int a, int b, int[] parents) {
		int aRoot = find(a, parents);
		int bRoot = find(b, parents);

		if (aRoot == bRoot)
			return;

		parents[bRoot] = aRoot;
		return;
	}
}
