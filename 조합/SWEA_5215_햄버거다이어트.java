import java.io.*;
import java.util.StringTokenizer;

/*
1
5 1000
100 1001
300 1002
250 1003
500 1004
400 1005
 */
public class SWEA_5215_햄버거다이어트 {
	static int FOOD, R;
	static int LIMITCAL;
	static int totalCal, totalScore, maxScore;
	static int[][] MINKI;
	static int[][] numbers;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine()); // 테케 수

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			FOOD = Integer.parseInt(st.nextToken()); // 재료 개수
			LIMITCAL = Integer.parseInt(st.nextToken()); // 제한 칼로리

			MINKI = new int[FOOD][2]; // 재료 점수와 칼로리 저장할 민기 배열
			for (int i = 0; i < FOOD; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				MINKI[i][0] = Integer.parseInt(st.nextToken()); // 재료 점수
				MINKI[i][1] = Integer.parseInt(st.nextToken()); // 재료 칼로리
			}

//			System.out.println(Arrays.deepToString(MINKI)); // 배열에 잘 들어갔는지

			totalCal = 0;
			totalScore = 0;
			maxScore = 0;
			R = 1;
			for (int i = 0; i < FOOD; i++) {
				numbers = new int[R][2];
				makeBurger(0, 0);
				R++;
			}
			sb.append(maxScore).append("\n");
		}
		System.out.println(sb);
	}

	private static void makeBurger(int cnt, int start) {

		if (cnt == R) {
			// System.out.println("-- arr : " + Arrays.deepToString(numbers) + "--");
			for (int i = 0; i < numbers.length; i++) {
				totalCal += numbers[i][1];
				totalScore += numbers[i][0];
			}
			// System.out.println("--totalCal : " + totalCal + " -- totalScore : " +
			// totalScore);
			if (totalCal <= LIMITCAL) {
				maxScore = totalScore > maxScore ? totalScore : maxScore;
				// System.out.println("maxScore ??? " + maxScore);
			}
			totalCal = 0;
			totalScore = 0;
			return;
		}

		for (int i = start; i < FOOD; i++) {
			numbers[cnt][0] = MINKI[i][0];
			numbers[cnt][1] = MINKI[i][1];
			makeBurger(cnt + 1, i + 1);
		}
	}
}
