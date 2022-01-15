import java.io.*;
import java.util.*;

public class BOJ_12851_숨바꼭질2 {

	static int N, K;
	static int minSec, cnt;

	static class Point {
		int n, sec;

		public Point(int n, int sec) {
			super();
			this.n = n;
			this.sec = sec;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 수빈이 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		minSec = Integer.MAX_VALUE;
		cnt = 1;

		move();
		System.out.println(minSec);
		System.out.println(cnt);
	}

	private static void move() {
		Queue<Point> q = new LinkedList<Point>();
		boolean visited[] = new boolean[100001];

		q.offer(new Point(N, 0));

		while (!q.isEmpty()) {
			Point cur = q.poll();
			visited[cur.n] = true;

			if (cur.n == K) {
				if (minSec > cur.sec) {
					minSec = cur.sec;
				} else if (minSec == cur.sec) {
					cnt++;
				}
				continue;
			}

			if (cur.n - 1 >= 0 && !visited[cur.n - 1]) {
				q.offer(new Point(cur.n - 1, cur.sec + 1));
			}
			if (cur.n + 1 <= 100000 && !visited[cur.n + 1]) {
				q.offer(new Point(cur.n + 1, cur.sec + 1));
			}
			if (cur.n * 2 <= 100000 && !visited[cur.n * 2]) {
				q.offer(new Point(cur.n * 2, cur.sec + 1));
			}
		}
	}
}
