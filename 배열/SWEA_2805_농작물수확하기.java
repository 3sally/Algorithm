import java.io.*;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(in.readLine()); // 테스트케이스 수

		for (int tc = 1; tc <= TC; tc++) { // 테케 수만큼 돌면서

			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(in.readLine()); // 농장 크기

			int farm[][] = new int[N][N]; // NXN만큼의 농장 배열 생성

			// 농장 배열에 값 넣기
			for (int i = 0; i < farm.length; i++) {
				String str = in.readLine();
				for (int j = 0; j < farm.length; j++) {
					farm[i][j] = Integer.parseInt(str.split("")[j]);
				}
			}

			int money = 0; // 얻을 수 있는 수익

			int mark = N / 2;
			int jumpCnt = 1; // 무조건 처음엔 하나만 수확(?)

			for (int i = 0; i < N; i++) {
				// 배열을 한 행씩 보면서
				if (i < N / 2) { // 중간 전 행
					for (int jump = 0; jump < jumpCnt; jump++) {
						money += farm[i][mark + jump];
					}
					jumpCnt += 2;
					mark--;
				} else if (i == N / 2) { // 중간 행
					for (int jump = 0; jump < jumpCnt; jump++) {
						money += farm[i][mark + jump];
					}
					jumpCnt -= 2;
					mark++;
				} else if (i > N / 2) { // 중간 다음 행들
					for (int jump = 0; jump < jumpCnt; jump++) {
						money += farm[i][mark + jump];
					}
					jumpCnt -= 2;
					mark++;
				}
			}
			sb.append(money).append("\n");
		}
		System.out.println(sb);
	}
}
