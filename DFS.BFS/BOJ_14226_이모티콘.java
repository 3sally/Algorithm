import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_14226_이모티콘 {

	static int S;
	static boolean[][] vistied;

	static class emoji {
		int cnt, sec, clipboard;

		public emoji(int cnt, int sec, int clipboard) {
			super();
			this.cnt = cnt;
			this.sec = sec;
			this.clipboard = clipboard;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());
		vistied = new boolean[2001][2001]; // 이모지개수, 클립보드개수
		emoji();
	}

	private static void emoji() {

		Queue<emoji> q = new LinkedList<emoji>();
		q.offer(new emoji(1, 0, 0));

		while (!q.isEmpty()) {
			emoji cur = q.poll();

			if (cur.cnt == S) {
				System.out.println(cur.sec);
				return;
			}

			if (cur.cnt > 0 && cur.cnt <= 2000) {

				if (!vistied[cur.cnt][cur.cnt]) {
					q.offer(new emoji(cur.cnt, cur.sec + 1, cur.cnt));
					vistied[cur.cnt][cur.cnt] = true;
				}

				if (cur.clipboard > 0 && cur.cnt + cur.clipboard <= 2000
						&& !vistied[cur.cnt + cur.clipboard][cur.clipboard]) {
					q.offer(new emoji(cur.cnt + cur.clipboard, cur.sec + 1, cur.clipboard));
					vistied[cur.cnt + cur.clipboard][cur.clipboard] = true;
				}

				if (!vistied[cur.cnt - 1][cur.clipboard]) {
					q.offer(new emoji(cur.cnt - 1, cur.sec + 1, cur.clipboard));
					vistied[cur.cnt - 1][cur.clipboard] = true;
				}
			}
		}
	}
}
