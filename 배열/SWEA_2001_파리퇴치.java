import java.io.*;
import java.util.StringTokenizer;

public class SWEA_2001_파리퇴치 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(in.readLine()); // 테스트케이스 개수
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N*N 크기의 방
			int M = Integer.parseInt(st.nextToken()); // M*M 크기의 파리채

			int[][] room = new int[N][N];

			// 배열 각 칸에 파리의 수 입력
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxKill = 0; // 최대 죽인 파리 수
			int kill = 0; // 범위별로 죽인 파리 수

			for (int i = 0; i < N - (M - 1); i++) {
				for (int j = 0; j < N - (M - 1); j++) {
					kill = 0;
					// 파리잡기

					int col = i;
					int row = j;

					for (int n = 0; n < M; n++) {
						for (int m = 0; m < M; m++) {
							kill += room[col + n][row + m];
							System.out.println("[ " + (col + n) + " , " + (row + m) + " ]");
						}
					}

					if (kill > maxKill) {
						maxKill = kill;
					}
				}
			}

			sb.append(maxKill);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
