import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2578_빙고 {
	static int[][] CHULSU;
	static int num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		CHULSU = new int[5][5]; // 철수의 빙고판

		// 철수 빙고판 채우기
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				CHULSU[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 사회자가 숫자 부름
		int callCnt = 0;
		boolean finish = false;
		for (int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				num = Integer.parseInt(st.nextToken());

				check();
				callCnt++;

				if (isBingo()) {
					System.out.println(callCnt);
					finish = true;
					break;
				}

			}
			if (finish)
				break;
		}
	}

	private static boolean isBingo() {
		int bingo = 0;
		int cnt = 0;

		// 첫번째 행 확인
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			if (CHULSU[i][0] == 0) {
				for (int j = 0; j < 5; j++) {
					if (CHULSU[i][j] == 0)
						cnt++;
				}
				if (cnt == 5) {
					bingo++;
				}
			}
		}

		// 첫번째 열 확인
		for (int i = 0; i < 5; i++) {
			cnt = 0;
			if (CHULSU[0][i] == 0) {
				for (int j = 0; j < 5; j++) {
					if (CHULSU[j][i] == 0)
						cnt++;
				}
				if (cnt == 5) {
					bingo++;
				}
			}
		}

		// 대각선 확인
		// \ 방향부터
		int row = 0;
		int col = 0;
		cnt = 0;
		if (CHULSU[row][col] == 0) {
			for (int j = 0; j < 5; j++) {
				if (CHULSU[row++][col++] == 0)
					cnt++;
			}
			if (cnt == 5) {
				bingo++;
			}
		}
		// / 방향
		row = 0;
		col = 4;
		cnt = 0;
		if (CHULSU[row][col] == 0) {
			for (int j = 0; j < 5; j++) {
				if (CHULSU[row++][col--] == 0)
					cnt++;
			}
			if (cnt == 5) {
				bingo++;
			}
		}

		if (bingo >= 3)
			return true;
		else
			return false;

	}

	private static void check() {
		// 철수 빙고판 돌면서 숫자 같은 부분 0으로 바꾸기
		br: for (int n = 0; n < 5; n++) {
			for (int m = 0; m < 5; m++) {
				if (CHULSU[n][m] == num) {
					CHULSU[n][m] = 0;
					break br;
				}
			}

		}
	}
}
