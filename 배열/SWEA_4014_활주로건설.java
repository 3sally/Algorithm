import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4014_활주로건설 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		StringTokenizer st = null;

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken()); // 활주로 밑면

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int airstrip = 0; // 가능한 활주로 갯수
			int temp, cnt, zero;
			boolean canBuild;
			boolean[] build;
			// 가로
			for (int i = 0; i < N; i++) {
				canBuild = false;
				zero = 0;
				build = new boolean[N];
				sec: for (int j = 0; j < N - 1; j++) {
					if (map[i][j] - map[i][j + 1] == 1) {
						temp = map[i][j + 1];
						cnt = 0;
						for (int k = j + 1; k < N; k++) {
							if (map[i][k] != temp)
								break;
							cnt++;
						}
						if (cnt < X) {
							canBuild = false;
							break;
						} else {
							int idx = j + 1;
							for (int c = 0; c < X; c++) {
								if (build[idx]) {
									canBuild = false;
									break sec;
								}
								idx++;
							}
							idx = j + 1;
							canBuild = true;
							for (int c = 0; c < X; c++) {
								build[idx++] = true;
							}
						}
					} else if (map[i][j] - map[i][j + 1] == -1) {
						temp = map[i][j];
						cnt = 0;
						for (int k = j; k >= 0; k--) {
							if (map[i][k] != temp)
								break;
							cnt++;
						}
						if (cnt < X) {
							canBuild = false;
							break;
						} else {
							int idx = j;
							for (int c = 0; c < X; c++) {
								if (build[idx]) {
									canBuild = false;
									break sec;
								}
								idx--;
							}
							idx = j;
							canBuild = true;
							for (int c = 0; c < X; c++) {
								build[idx--] = true;
							}
						}
					} else if (map[i][j] - map[i][j + 1] == 0) {
						zero++;
					} else if (map[i][j] - map[i][j + 1] == 2 || map[i][j] - map[i][j + 1] == -2) {
						canBuild = false;
						break;
					}
				}

				if (canBuild || zero == N - 1) {
					airstrip++;
				}

			}

			// 세로
			for (int i = 0; i < N; i++) {
				canBuild = false;
				zero = 0;
				build = new boolean[N];

				sec: for (int j = 0; j < N - 1; j++) {
					if (map[j][i] - map[j + 1][i] == 1) {
						temp = map[j + 1][i];
						cnt = 0;
						for (int k = j + 1; k < N; k++) {
							if (map[k][i] != temp)
								break;
							cnt++;
						}
						if (cnt < X) {
							canBuild = false;
							break;
						} else {
							int idx = j + 1;
							for (int c = 0; c < X; c++) {
								if (build[idx]) {
									canBuild = false;
									break sec;
								}
								idx++;
							}
							idx = j + 1;
							canBuild = true;
							for (int c = 0; c < X; c++) {
								build[idx++] = true;
							}
						}
					} else if (map[j][i] - map[j + 1][i] == -1) {
						temp = map[j][i];
						cnt = 0;
						for (int k = j; k >= 0; k--) {
							if (map[j][i] != temp)
								break;
							cnt++;
						}
						if (cnt < X) {
							canBuild = false;
							break;
						} else {
							int idx = j;
							for (int c = 0; c < X; c++) {
								if (build[idx]) {
									canBuild = false;
									break sec;
								}
								idx--;
							}
							idx = j;
							canBuild = true;
							for (int c = 0; c < X; c++) {
								build[idx--] = true;
							}
						}
					} else if (map[j][i] - map[j + 1][i] == 0) {
						zero++;
					} else if (map[j][i] - map[j + 1][i] == 2 || map[j][i] - map[j + 1][i] == -2) {
						canBuild = false;
						break;
					}
				}

				if (canBuild || zero == N - 1) {
					airstrip++;
				}
			}
			sb.append("#").append(tc).append(" ").append(airstrip).append("\n");
		}
		System.out.println(sb);
	}
}
