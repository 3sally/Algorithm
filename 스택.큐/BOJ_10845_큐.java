import java.io.*;
import java.util.*;

public class BOJ_10845_큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> q = new LinkedList<Integer>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			String order = st.nextToken();
			int num;

			switch (order) {
			case "push":
				num = Integer.parseInt(st.nextToken());
				q.offer(num);
				break;
			case "pop":
				if (q.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				if (q.isEmpty())
					sb.append("1").append("\n");
				else
					sb.append("0").append("\n");
				break;
			case "front":
				if (q.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(q.getFirst()).append("\n");
				break;
			case "back":
				if (q.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(q.getLast()).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
