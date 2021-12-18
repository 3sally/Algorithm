import java.io.*;
import java.util.*;

public class BOJ_2346_풍선터트리기 {

	static class Node {
		int num, order;

		public Node(int num, int order) {
			super();
			this.num = num;
			this.order = order;
		}

		@Override
		public String toString() {
			return "[num=" + num + ", order=" + order + "]\n";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Deque<Node> q = new ArrayDeque<Node>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			q.offer(new Node(Integer.parseInt(st.nextToken()), i + 1));
		}
		Node start = q.poll(); // 처음은 무조건 1번 풍선
		int num = start.num;

		sb.append(start.order).append(" ");

		while (!q.isEmpty()) {
			if (num > 0) {
				for (int i = 1; i < num; i++) {
					q.add(q.poll());
				}
				Node out = q.poll();
				num = out.num;
				sb.append(out.order).append(" ");
			} else {
				for (int i = 1; i < Math.abs(num); i++) {
					q.addFirst(q.pollLast());
				}
				Node out = q.pollLast();
				num = out.num;
				sb.append(out.order).append(" ");
			}

		}
		System.out.println(sb);
	}
}
