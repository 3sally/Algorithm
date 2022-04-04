import java.io.*;
import java.util.*;

public class BOJ_10866_덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Integer> dq = new ArrayDeque<Integer>();

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			switch (st.nextToken()) {

			case "push_front":
				dq.offerFirst(Integer.parseInt(st.nextToken()));
				break;

			case "push_back":
				dq.offerLast(Integer.parseInt(st.nextToken()));
				break;

			case "pop_front":
				if (!dq.isEmpty())
					sb.append(dq.pollFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "pop_back":
				if (!dq.isEmpty())
					sb.append(dq.pollLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "size":
				sb.append(dq.size()).append("\n");
				break;

			case "empty":
				if (!dq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(1).append("\n");
				break;

			case "front":
				if (!dq.isEmpty())
					sb.append(dq.getFirst()).append("\n");
				else
					sb.append(-1).append("\n");
				break;

			case "back":
				if (!dq.isEmpty())
					sb.append(dq.getLast()).append("\n");
				else
					sb.append(-1).append("\n");
				break;
			}
		}
		System.out.println(sb);
	}
}
