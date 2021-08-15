import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17406_배열돌리기4 {

	static int N, M, K, arrResult;
	static int[][] ARR, copyArr;
	static boolean[] isSelected;
	static int[][] order, spin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 행
		M = Integer.parseInt(st.nextToken()); // 열
		K = Integer.parseInt(st.nextToken()); // 회전연산의 개수

		// 배열 입력 넣기
		ARR = new int[N + 1][M + 1];
		copyArr = new int[N + 1][M + 1];
		for (int n = 1; n < N + 1; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int m = 1; m < M + 1; m++) {
				int num = Integer.parseInt(st.nextToken());
				ARR[n][m] = num;
				copyArr[n][m] = num;
			}
		}

		arrResult = Integer.MAX_VALUE;

		// 회전 R,C,S 배열에 집어 넣음
		spin = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			spin[i][0] = Integer.parseInt(st.nextToken());
			spin[i][1] = Integer.parseInt(st.nextToken());
			spin[i][2] = Integer.parseInt(st.nextToken());
		}

		// 순열 사용해서 회전 순서 임의로 정함 -> 순서 상관 있으니깐 순열 쓰자!!
		isSelected = new boolean[K];
		order = new int[K][3];
		spinOrder(0);
		System.out.println(arrResult);
	}

	// 회전 순서 구하는 순열
	private static void spinOrder(int cnt) {
		if (cnt == K) {
			for (int col = 1; col < N + 1; col++) {
				for (int row = 1; row < M + 1; row++) {
					int num = copyArr[col][row];
					ARR[col][row] = num;
				}
			}
			spinNow();
			checkMin();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (isSelected[i])
				continue;
			order[cnt] = spin[i];
			isSelected[i] = true;
			spinOrder(cnt + 1);
			isSelected[i] = false;
		}

	}

	private static void spinNow() {

		for (int i = 0; i < K; i++) {

			int R = order[i][0];
			int C = order[i][1];
			int S = order[i][2];

			int size = 2 * S + 1;
			int nemoCnt = (size) / 2;
			int startCol = R - S;
			int startRow = C - S;
			int move = size - 1;

			for (int j = 0; j < nemoCnt; j++) {
				int temp = ARR[startCol][startRow];

				for (int c = startCol; c < startCol + move; c++)
					ARR[c][startRow] = ARR[c + 1][startRow];

				for (int r = startRow; r < startRow + move; r++)
					ARR[startCol + move][r] = ARR[startCol + move][r + 1];

				for (int c = startCol + move; c > startCol; c--)
					ARR[c][startRow + move] = ARR[c - 1][startRow + move];

				for (int r = startRow + move; r > startRow; r--)
					ARR[startCol][r] = ARR[startCol][r - 1];

				ARR[startCol][startRow + 1] = temp;
				startCol++;
				startRow++;
				move -= 2;

			}

		}

	}

	// 최소값 확인
	private static void checkMin() {
		int colSum = 0;
		for (int n = 1; n < N + 1; n++) {
			colSum = 0;
			for (int m = 1; m < M + 1; m++) {
				colSum += ARR[n][m];
			}
			arrResult = Math.min(arrResult, colSum);
		}
	}
}
