import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] chain = new int[5][8];

		for (int i = 1; i <= 4; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j = 0; j < 8; j++) {
				chain[i][j] = ch[j] - '0';
			}
		}

		int K = Integer.parseInt(br.readLine());

		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int chainNum = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());

			int[] move = new int[5];

			move[chainNum] = dir;
			// 회전 톱니 기준 왼쪽
			for (int j = chainNum - 1; j > 0; j--) {
				if (move[j + 1] == 0)
					move[j] = 0;
				else {
					if (chain[j + 1][6] == chain[j][2]) {
						move[j] = 0;
					} else {
						move[j] = move[j + 1] == -1 ? 1 : -1;
					}
				}
			}

			// 회전 톱니 기준 오른쪽
			for (int j = chainNum + 1; j < 5; j++) {
				if (move[j - 1] == 0)
					move[j] = 0;
				else {
					if (chain[j - 1][2] == chain[j][6]) {
						move[j] = 0;
					} else {
						move[j] = move[j - 1] == -1 ? 1 : -1;
					}
				}
			}

			// 회전
			for (int j = 1; j <= 4; j++) {
				if (move[j] == 0)
					continue;
				else if (move[j] == -1) { // 반시계
					int temp = chain[j][0];
					for (int l = 0; l < 7; l++) {
						chain[j][l] = chain[j][l + 1];
					}
					chain[j][7] = temp;
				} else if (move[j] == 1) { // 시계
					int temp = chain[j][7];
					for (int l = 7; l > 0; l--) {
						chain[j][l] = chain[j][l - 1];
					}
					chain[j][0] = temp;
				}
			}
		}

		// 점수 계산
		int score = 0;
		for (int i = 1; i <= 4; i++) {
			if (chain[i][0] == 1) {
				score += Math.pow(2, i - 1);
			}
		}

		System.out.println(score);
	}
}
