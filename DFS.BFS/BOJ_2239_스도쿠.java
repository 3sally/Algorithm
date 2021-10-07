import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2239_스도쿠 {

	static int[][] sudoku;
	static List<Point> zero;
	static boolean finish = false;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		sudoku = new int[9][9];
		zero = new ArrayList<Point>();

		// 스도쿠 입력
		for (int i = 0; i < 9; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = c[j] - '0';
				if (sudoku[i][j] == 0)
					zero.add(new Point(i, j));
			}
		}

		dfs(0);

	}

	private static void dfs(int idx) {
		if (idx == zero.size()) {
			// 결과 출력
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(sudoku[i][j]);
				}
				System.out.println();
			}
			finish = true;
			return;
		}

		if (finish)
			return;

		Point cur = zero.get(idx);
		int x = cur.x;
		int y = cur.y;

		for (int i = 1; i <= 9; i++) {
			int tmp = sudoku[x][y];
			// 가로 확인 , 세로 확인, 3x3 네모 확인
			// 어딘가에 하나라도 겹치는 값이 있으면 다음 값 확인
			if (isX(x, i) || isY(y, i) || isNemo(x, y, i))
				continue;
			// 겹치는 숫자가 어디에도 없으면
			sudoku[x][y] = i;
			// 다음 빈칸 찾으러
			dfs(idx + 1);
			// 갱신,,?
			sudoku[x][y] = tmp;
		}
	}

	// 가로 확인
	private static boolean isX(int x, int val) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[x][i] == val)
				return true;
		}
		return false;
	}

	// 세로 확인
	private static boolean isY(int y, int val) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][y] == val)
				return true;
		}
		return false;
	}

	// 3x3 네모 확인
	private static boolean isNemo(int x, int y, int val) {
		int sx = x / 3 * 3;
		int sy = y / 3 * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[sx + i][sy + j] == val)
					return true;
			}
		}
		return false;
	}
}
