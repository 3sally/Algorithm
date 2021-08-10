import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2563_색종이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int PAPERS = Integer.parseInt(br.readLine()); // 색종이 수
		int totalArea = 100 * PAPERS; // 색종이의 총 면적
		int overlap = 0;
		int[][] DRAWING = new int[101][101]; // 도화지

		for (int i = 0; i < PAPERS; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int COL = Integer.parseInt(st.nextToken());
			int ROW = Integer.parseInt(st.nextToken());

			for (int c = 0; c < 10; c++) {
				for (int r = 0; r < 10; r++) {
					if (DRAWING[COL + c][ROW + r] == 0) {
						DRAWING[COL + c][ROW + r] = 1;
					} else if (DRAWING[COL + c][ROW + r] == 1) {
						overlap++;
					}
				}
			}

		}

		System.out.println(totalArea - overlap);
	}
}
