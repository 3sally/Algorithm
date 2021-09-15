import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_최소스패닝트리 {

	static class Edge implements Comparable<Edge> {
		int start, end;
		long weight;

		public Edge(int start, int end, long weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

	}

	static int[] parents;

	private static void make() {
		parents = new int[V + 1];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}
	}

	// a가 속한 집합의 대표자 찾기
	private static int find(int a) {
		if (a == parents[a])
			return a; // 자신이 대표자.
		return parents[a] = find(parents[a]); // 자신이 속한 집합의 대표자를 자신의부모로 : path compression
	}

	// 두 원소를 하나의 집합으로 합치기 (대표자를 이용해서 합침)
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false; // 이미 같은 집합으로 합치지 않음

		parents[bRoot] = aRoot;
		return true;
	}

	static int V, E;
	static Edge[] edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				long weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start, end, weight);
			}

			Arrays.sort(edgeList); // 간선 오름차순 정렬

			make();

			int cnt = 0;
			long result = 0;
			for (Edge edge : edgeList) {
				if (union(edge.start, edge.end)) {
					result += edge.weight;
					if (++cnt == V) {
						break;
					}
				}
			}

			sb.append(result).append("\n");
		}
		System.out.println(sb);
	}
}
