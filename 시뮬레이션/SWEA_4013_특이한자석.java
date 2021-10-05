import java.io.*;
import java.util.StringTokenizer;

public class SWEA_4013_특이한자석 {

	static class Spin {
		boolean spin;
		int d;

		public Spin(boolean spin, int d) {
			super();
			this.spin = spin;
			this.d = d;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			int K = Integer.parseInt(br.readLine()); // 자석 회전 횟수

			int[][] magnets = new int[5][8];
			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 화살표 위치는 배열의 0번째 인덱스
			// 맞물리는데는 1번 자석의 2 - 2번 자석의 6
			// 2번 자석의 2 - 3번 자석의 6
			// 3번 자석의 2 - 4번 자석의 6

			// 회전 시작
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int m = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken()); // 1이면 시계 -1이면 반시계

				Spin[] spin = new Spin[5];
				spin[0] = null;
				spin[m] = new Spin(true, d);

				int dir = d;

				// 왼쪽
				for (int l = m; l > 1; l--) {
					if (magnets[l][6] != magnets[l - 1][2]) {
						dir = -dir;
						spin[l - 1] = new Spin(true, dir);
					} else
						break;
				}

				dir = d;
				// 오른쪽
				for (int r = m; r < 4; r++) {
					if (magnets[r][2] != magnets[r + 1][6]) {
						dir = -dir;
						spin[r + 1] = new Spin(true, dir);
					} else
						break;
				}

				for (int i = 1; i < 5; i++) {
					if (spin[i] != null) {
						if (spin[i].spin == true) {
							if (spin[i].d == 1) { // 시계방향
								int temp = magnets[i][7];
								for (int j = 6; j >= 0; j--) {
									magnets[i][j + 1] = magnets[i][j];
								}
								magnets[i][0] = temp;
							} else { // 반시계방향
								int temp = magnets[i][0];
								for (int j = 0; j < 7; j++) {
									magnets[i][j] = magnets[i][j + 1];
								}
								magnets[i][7] = temp;
							}
						}
					}
				}
			}
			int score = 0;

			if (magnets[1][0] == 1)
				score += 1;
			if (magnets[2][0] == 1)
				score += 2;
			if (magnets[3][0] == 1)
				score += 4;
			if (magnets[4][0] == 1)
				score += 8;

			sb.append("#").append(tc).append(" ").append(score).append("\n");
		}
		System.out.println(sb);
	}
}
