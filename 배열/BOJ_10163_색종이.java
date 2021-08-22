import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] board = new int[1001][1001]; // 색종이가 놓이는 평면

		for (int n = 1; n <= N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int sR = Integer.parseInt(st.nextToken());
			int sC = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());

			for (int i = sR; i < sR + width; i++) {
				for (int j = sC; j < sC + height; j++) {
					board[i][j] = n;
				}
			}
		}

		for (int n = 1; n <= N; n++) {
			int cnt = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] == n)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
	}
}
