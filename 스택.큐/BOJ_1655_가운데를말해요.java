import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>(); // 작은값 우선순위
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Collections.reverseOrder()); // 큰값 우선순위

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());

			// 두개 큐 크기 같으면 maxpq에 추가 아니면 minpq에 추가
			if (minPQ.size() == maxPQ.size()) {
				maxPQ.offer(x);
			} else {
				minPQ.offer(x);
			}

			// 둘 다 비어져있지 않은 경우에
			// minpq의 최대값이 maxpq의 최솟값보다 작은 경우 스왑
			if (!minPQ.isEmpty() && !maxPQ.isEmpty()) {
				if (minPQ.peek() < maxPQ.peek()) {
					int temp = minPQ.poll();
					minPQ.offer(maxPQ.poll());
					maxPQ.offer(temp);
				}
			}

			sb.append(maxPQ.peek()).append("\n");
		}

		System.out.println(sb);
	}
}
