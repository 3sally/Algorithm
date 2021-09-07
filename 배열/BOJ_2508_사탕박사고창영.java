import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2508_사탕박사고창영 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			String[][] box = new String[R][C];

			for (int r = 0; r < R; r++) {
				String str[] = br.readLine().split("");
				for (int c = 0; c < C; c++) {
					box[r][c] = str[c];
				}
			}

			int candy = 0;

			for (int r = 0; r < R; r++) {
				for (int c = 0; c < C; c++) {
					if (box[r][c].equals(">")) {
						if (c + 1 < C && c + 2 < C) {
							if (box[r][c + 1].equals("o") && box[r][c + 2].equals("<"))
								candy++;
						}
					}
					if (box[r][c].equals("v")) {
						if (r + 1 < R && r + 2 < R) {
							if (box[r + 1][c].equals("o") && box[r + 2][c].equals("^"))
								candy++;
						}
					}
				}
			}

			System.out.println(candy);
		}
	}
}
