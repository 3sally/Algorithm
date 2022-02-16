import java.io.*;
import java.util.*;

public class BOJ_10818_최소최대 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		PriorityQueue<Long> pq2 = new PriorityQueue<Long>(Collections.reverseOrder());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			long l = Long.parseLong(st.nextToken());
			pq.offer(l);
			pq2.offer(l);
		}

		System.out.println(pq.poll() + " " + pq2.poll());
	}
}
