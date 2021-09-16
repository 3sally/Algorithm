import java.io.*;
import java.util.*;

public class BOJ_9205_맥주마시면서걸어가기 {

	static class Location {
		int x;
		int y;

		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {

			int N = Integer.parseInt(br.readLine());
			Location[] loc = new Location[N + 2];
			int[] check = new int[N + 2];
			Queue<Location> q = new LinkedList<Location>();
			boolean success = false;

			for (int i = 0; i < N + 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				loc[i] = new Location(x, y);
			}

			// 시작
			Location s = loc[0];
			check[0] = 1;
			// 페스티발
			Location e = loc[N + 1];

			q.offer(s);

			while (!q.isEmpty()) {
				Location cur = q.poll();

				if (cur.equals(e)) {
					success = true;
					break;
				}

				// 방문할 곳들 중에서 거리가 1000안에 도착할 때만 q에 넣기
				for (int i = 1; i < N + 2; i++) {
					if (check[i] == 0 && Math.abs(cur.x - loc[i].x) + Math.abs(cur.y - loc[i].y) <= 1000) {
						q.offer(loc[i]);
						check[i] = 1;
					}
				}

			}

			if (success)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
}
