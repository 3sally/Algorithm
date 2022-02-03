import java.io.*;
import java.util.PriorityQueue;

public class BOJ_1927_최소힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			if (x == 0) {
				if (pq.isEmpty())
					sb.append(0).append("\n");
				else
					sb.append(pq.poll()).append("\n");
			} else {
				pq.add(x);
			}

		}
		System.out.println(sb);

	}
}
