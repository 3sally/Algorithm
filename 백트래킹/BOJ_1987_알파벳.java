import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {

	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int R, C, result;
	static char board[][];
	static boolean visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visit = new boolean[26]; // 알파벳 26개에 대한 방문을 체크하기 위해

		for (int i = 0; i < R; i++) {
			board[i] = br.readLine().toCharArray();
		}

		go(0, 0, 1);
		System.out.println(result);
	}

	private static void go(int r, int c, int num) {
		visit[board[r][c] - 'A'] = true; // 시작점 방문했다고 바꾸기
		// 상하좌우 확인
		for (int d = 0; d < 4; d++) {
			int nextR = r + dx[d];
			int nextC = c + dy[d];
			if (nextR < 0 || nextC < 0 || nextC >= C || nextR >= R || visit[board[nextR][nextC] - 'A'])
				continue;
			go(nextR, nextC, num + 1);
		}
		result = Math.max(num, result);
		visit[board[r][c] - 'A'] = false;
	}
}
