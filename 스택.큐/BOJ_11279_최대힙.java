import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_11279_최대힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append("\n");
				} else {
					sb.append(pq.poll()).append("\n");
				}
			}

			pq.offer(x);
		}

		System.out.println(sb);
	}
}
