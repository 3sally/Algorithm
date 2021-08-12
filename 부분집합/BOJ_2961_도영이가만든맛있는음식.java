import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {

	static int N;
	static int[][] FOODS;
	static boolean[] isSelected;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 재료의 개수

		FOODS = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			FOODS[i][0] = Integer.parseInt(st.nextToken()); // 신맛
			FOODS[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
		}

		// 부분집합
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		cook(0);
		System.out.println(min);
	}

	private static void cook(int cnt) {
		if (cnt == N) {
			// 부분집합 완성
			boolean select = false;
			int sour = 1;
			int bitter = 0;

			for (int i = 0; i < N; i++) {
				if (isSelected[i]) {
					sour *= FOODS[i][0];
					bitter += FOODS[i][1];
					select = true;
				}
			}

			if (select)
				min = Math.min(min, Math.abs(sour - bitter));
			return;
		}

		// 현재 원소를 부분집합에 넣기
		isSelected[cnt] = true; // 넣었우
		cook(cnt + 1); // 다음꺼 봐조!

		// 현재 원소를 부분집합에 넣지 않기
		isSelected[cnt] = false; // 안 넣어
		cook(cnt + 1); // 다음꺼 봐조
	}
}
