import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2567_색종이2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 색종이의 개수
		char[][] paper = new char[101][101];
		StringTokenizer st = null;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int startC = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			for (int r = startR; r < startR + 10; r++) {
				for (int c = startC; c < startC + 10; c++) {
					paper[r][c] = 'X';
				}
			}
		}
		int border = 0;
		int dx[] = { 0, 0, -1, 1 };
		int dy[] = { 1, -1, 0, 0 };

		for (int i = 0; i < paper.length; i++) {
			for (int j = 0; j < paper.length; j++) {

				if (paper[i][j] == 'X') {
					int x = 0;
					for (int d = 0; d < 4; d++) {
						if (i + dx[d] >= 0 && i + dx[d] < 101 && j + dy[d] >= 0 && j + dy[d] < 101) {
							if (paper[i + dx[d]][j + dy[d]] == 'X')
								x++;
						}
					}
					if (x != 4) {
						border += (4 - x);
					}
				}
			}
		}
		System.out.println(border);
	}
}
