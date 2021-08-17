import java.io.*;

public class SWEA_11315_오목판정 {
	static int[] di = { -1, 0, +1, +1 }; // 우상, 우, 우하, 하
	static int[] dj = { +1, +1, +1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			char map[][] = new char[N][N];

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			boolean isOmok = false;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'o') { // 돌이다!
						if (check(map, i, j))
							isOmok = true;
					}
				}
			}

			if (isOmok)
				sb.append("YES").append("\n");
			else
				sb.append("NO").append("\n");

		}
		System.out.println(sb);
	}

	static boolean check(char[][] map, int i, int j) {
		for (int d = 0; d < 4; d++) { // 4개 방향으로 다 보내서 오목 있나 없나 확인
			int cnt = 1;
			for (int t = 1; t < 5; t++) {
				int ni = i + di[d] * t;
				int nj = j + dj[d] * t;
				if (ni >= 0 && ni < map.length && nj >= 0 && nj < map.length && map[ni][nj] == 'o') {
					cnt++;
				}
			}
			if (cnt == 5)
				return true;
		}
		return false;
	}
}
