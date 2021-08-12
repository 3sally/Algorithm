import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int[][] sudoku = new int[9][9];
			int[] isSelected;
			boolean flag = false;

			// 스도쿠 배열 채우기
			for (int i = 0; i < 9; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 9; j++) {
					sudoku[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 행 확인
			for (int i = 0; i < 9; i++) {
				isSelected = new int[9];
				for (int j = 0; j < 9; j++) {
					isSelected[sudoku[i][j] - 1] = 1;
				}
				for (int sel = 0; sel < 9; sel++) {
					if (isSelected[sel] == 0) {
						flag = true;
						break;
					}
				}
			}

			// 열 확인
			for (int i = 0; i < 9; i++) {
				isSelected = new int[9];
				for (int j = 0; j < 9; j++) {
					isSelected[sudoku[j][i] - 1] = 1;
				}
				for (int sel = 0; sel < 9; sel++) {
					if (isSelected[sel] == 0) {
						flag = true;
						break;
					}
				}
			}

			// 3x3으로 나눠서 확인
			isSelected = new int[9];
			for (int i = 0; i <= 6; i += 3) {
				for (int j = 0; j <= 6; j += 3) {
					isSelected = new int[9];
					for (int x = i; x < i + 3; x++) {
						for (int y = j; y < j + 3; y++) {
							isSelected[sudoku[x][y] - 1] = 1;
						}
					}
				}

				for (int sel = 0; sel < 9; sel++) {
					if (isSelected[sel] == 0) {
						flag = true;
						break;
					}
				}
			}
			if (flag)
				sb.append(0).append("\n");
			else
				sb.append(1).append("\n");
		}
		System.out.println(sb);
	}
}
