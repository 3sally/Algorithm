import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
	int end, value;

	public Edge(int end, int value) {
		super();
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.value, o.value);

	}

}

public class BOJ_1753_최단경로 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수
		int K = Integer.parseInt(br.readLine()); // 시작 정점의 번호

		int[] distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		ArrayList<ArrayList<Edge>> lists = new ArrayList<ArrayList<Edge>>();
		for (int i = 0; i <= V; i++) {
			lists.add(new ArrayList<Edge>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			lists.get(u).add(new Edge(v, w));
		}

		PriorityQueue<Edge> q = new PriorityQueue<Edge>();
		boolean[] visited = new boolean[V + 1];

		q.add(new Edge(K, 0));
		distance[K] = 0;

		while (!q.isEmpty()) {
			// 다음에 방문할 vertex 설정
			Edge current = q.poll();
			int end = current.end;
			// 방문했기 떄문에 true, INF는 아니다.
			visited[end] = true;

			for (Edge next : lists.get(end)) {
				int compare = distance[end] + next.value;

				if (distance[next.end] > compare) {
					distance[next.end] = compare;
					q.add(new Edge(next.end, distance[next.end]));
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}

	}
}
