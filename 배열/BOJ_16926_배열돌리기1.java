import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16926_배열돌리기1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int COL = Integer.parseInt(st.nextToken()); // 행 N
		int ROW = Integer.parseInt(st.nextToken()); // 열 M
		int ROTATION = Integer.parseInt(st.nextToken()); // 회전 횟수

		int[][] ARR = new int[COL][ROW];

		// 배열에 집어넣기
		for (int i = 0; i < COL; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < ROW; j++) {
				ARR[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int nemoCnt = Math.min(COL, ROW) / 2;

		// 4x4
		while (ROTATION-- > 0) {
			for (int i = 0; i < nemoCnt; i++) {
				int temp = ARR[i][i];
				int col = COL - i - 1; // 3
				int row = ROW - i - 1; // 3

				for (int r = i; r < row; r++) {
					ARR[i][r] = ARR[i][r + 1];
				}
				for (int c = i; c < col; c++) {
					ARR[c][row] = ARR[c + 1][row];
				}
				for (int r = row; r > i; r--) {
					ARR[col][r] = ARR[col][r - 1];
				}
				for (int c = col; c > i; c--) {
					ARR[c][i] = ARR[c - 1][i];
				}

				ARR[i + 1][i] = temp;
			}
		}

		// 배열 출력
		for (int i = 0; i < COL; i++) {
			for (int j = 0; j < ROW; j++) {
				System.out.print(ARR[i][j] + " ");
			}
			System.out.println();
		}

	}
}
