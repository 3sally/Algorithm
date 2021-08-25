import java.io.*;

public class BOJ_10026_적록색약 {

	static int N;
	static char[][] rbPICTURE;
	static char[][] rgbPICTURE;

	static int[] dx = { 0, 0, 1, -1 }; // 하, 상, 우, 좌
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		rbPICTURE = new char[N][N];
		rgbPICTURE = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				char color = str[j];
				rgbPICTURE[i][j] = color;
				rbPICTURE[i][j] = color;
				if (color == 'G') {
					rbPICTURE[i][j] = 'R';
				}
			}
		}

		int group = 0;
		// 적록색약 X
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (rgbPICTURE[i][j] != 'X') {
					char col = rgbPICTURE[i][j];
					rgbPICTURE[i][j] = 'X';
					grouping(i, j, col, 0);
					group++;
				}
			}
		}
		System.out.print(group + " ");
		group = 0;
		// 적록색약 O
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (rbPICTURE[i][j] != 'X') {
					char col = rbPICTURE[i][j];
					rbPICTURE[i][j] = 'X';
					grouping(i, j, col, 1);
					group++;
				}
			}
		}
		System.out.println(group);
	}

	private static void grouping(int x, int y, char col, int normal) {

		if (normal == 0) {
			for (int i = 0; i < 4; i++) {
				int r = x + dx[i];
				int c = y + dy[i];
				if (r >= 0 && r < N && c >= 0 && c < N) {
					if (rgbPICTURE[r][c] == col) {
						rgbPICTURE[r][c] = 'X';
						grouping(r, c, col, 0);
					}
				}
			}
		} else {
			for (int i = 0; i < 4; i++) {
				int r = x + dx[i];
				int c = y + dy[i];
				if (r >= 0 && r < N && c >= 0 && c < N) {
					if (rbPICTURE[r][c] == col) {
						rbPICTURE[r][c] = 'X';
						grouping(r, c, col, 1);
					}
				}
			}
		}
	}
}
