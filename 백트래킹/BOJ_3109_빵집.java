import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3109_빵집 {
	static int R, C, cnt, pipeRow, result;
	static char[][] map;
	static boolean finish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열

		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		cnt = 0;
		for (int i = 0; i < R; i++) {
			finish = false;
			connect(i, 0);
		}
		System.out.println(cnt);
	}

	private static void connect(int rowNo, int colNo) {

		if (colNo == C - 1) {
			cnt++;
			finish = true;
			return;
		}

		int nextR;
		// 오른쪽위 대각선,오른쪽, 오른쪽 아래 대각선 살펴보기
		int dx[] = { -1, 0, 1 };

		for (int i = 0; i < 3; i++) {
			nextR = rowNo + dx[i];
			if (nextR >= 0 && nextR < R && map[nextR][colNo + 1] == '.') {
				map[nextR][colNo + 1] = 'o';
				connect(nextR, colNo + 1);
				if (finish)
					return;
			}
		}

	}

}
