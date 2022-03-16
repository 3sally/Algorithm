import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16967_배열복원하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int[][] A = new int[H][W];
		int[][] B = new int[H][W];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < W; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (i < X && j < W)
					A[i][j] = B[i][j];
				else if (i < H && j < Y)
					A[i][j] = B[i][j];
				else if (i >= X && j >= Y && i < H && j < W)
					A[i][j] = B[i][j] - A[i - X][j - Y];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				sb.append(A[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
