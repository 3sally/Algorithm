import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		LinkedList<Integer> dq = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			dq.offer(i + 1);
		}

		int cnt = 0;

		for (int i = 0; i < M; i++) {
			int target = dq.indexOf(num[i]);
			int half;
			if (dq.size() % 2 == 0)
				half = dq.size() / 2 - 1;
			else
				half = dq.size() / 2;

			if (target <= half) {
				for (int j = 0; j < target; j++) {
					int tmp = dq.pollFirst();
					dq.offerLast(tmp);
					cnt++;
				}
			} else {
				for (int j = 0; j < dq.size() - target; j++) {
					int tmp = dq.pollLast();
					dq.offerFirst(tmp);
					cnt++;
				}
			}

			dq.pollFirst();
		}

		System.out.println(cnt);
	}
}
