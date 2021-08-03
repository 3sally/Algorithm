import java.io.*;

public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(bf.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			int N = Integer.parseInt(bf.readLine());

			int snail[][] = new int[N][N];

			int num = 1; // 1부터 배열에 넣으니깐

			int cnt = 0; // 몇번 넣었는지 N*N 만큼 값 다 넣었으면 끝
			int total = N * N; // 배열에 총 몇칸 있는지

			int col = 0;
			int row = -1;

			while (cnt != total) {
				// 오른쪽부터
				for (int i = 0; i < N; i++) {
					row++;
					snail[col][row] = num;
					num++;
					cnt++;
				}

				// 아래로
				for (int i = 0; i < N - 1; i++) {
					col++;
					snail[col][row] = num;
					num++;
					cnt++;
				}

				// 왼쪽으로
				for (int i = 0; i < N - 1; i++) {
					row--;
					snail[col][row] = num;
					num++;
					cnt++;
				}

				// 위로
				for (int i = 0; i < N - 2; i++) {
					col--;
					snail[col][row] = num;
					num++;
					cnt++;
				}

				N = N - 2;

			}

			System.out.println("#" + tc);

			// 배열 출력
			for (int i = 0; i < snail.length; i++) {
				for (int j = 0; j < snail.length; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
