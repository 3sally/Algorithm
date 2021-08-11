import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행 N
		int M = Integer.parseInt(st.nextToken()); // 열 M
		int R = Integer.parseInt(st.nextToken()); // 연산의 수

		int[][] arr = new int[N][M];

		// 배열에 집어넣기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int[] ORDER = new int[R];
		for (int i = 0; i < R; i++) {
			ORDER[i] = Integer.parseInt(st.nextToken());
		}

		for (int n = 0; n < R; n++) {
			int r = ORDER[n];
			int col = 0, row = 0, tem = 0;

			int[][] copyArr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					copyArr[i][j] = arr[i][j];
				}
			}

			switch (r) {
			case 1: // 상하반전
			{
//				System.out.println(N + " x " + M);
				int change = N - 1;
				for (int i = 0; i < N / 2; i++) {
					int[] temp = arr[i];
					arr[i] = arr[change];
					arr[change] = temp;
					change--;
				}
				break;
			}

			case 2: // 좌우반전
//				System.out.println(N + " x " + M);
				for (int i = 0; i < N; i++) {
					int change = M - 1;
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][change];
						arr[i][change] = temp;
						change--;
					}
				}
				break;

			case 3: // 오른쪽 90
				tem = N;
				N = M;
				M = tem;
//				System.out.println(N + " x " + M);
				arr = new int[N][M];
				col = M - 1;
				for (int i = 0; i < M; i++) {
					row = 0;
					for (int j = 0; j < N; j++) {
						arr[j][i] = copyArr[col][row];
						row++;
					}
					col--;
				}
				break;

			case 4: // 왼쪽 90
				tem = N;
				N = M;
				M = tem;
//				System.out.println(N + " x " + M);
				arr = new int[N][M];
				col = 0;
				for (int i = 0; i < M; i++) {
					row = N - 1;
					for (int j = 0; j < N; j++) {
						arr[j][i] = copyArr[col][row];
//						System.out.println(j + " " + i + "  :  " + col + " " + row);
						row--;
					}
					col++;
				}
				break;

			case 5:
//				System.out.println(N + " x " + M);
				// 열 절반을 기준으로 바꾸고
				for (int i = 0; i < N; i++) {
					int change = M / 2;
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[i][change];
						arr[i][change] = temp;
						change++;
					}
				}
				// 2랑 4 바꿈
				col = N / 2;
				for (int i = 0; i < N / 2; i++) {
					row = M / 2;
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[col][row];
						arr[col][row] = temp;
						row++;
					}
					col++;
				}
				break;
			case 6:
//				System.out.println(N + " x " + M);
				// 행 절반을 기준으로 바꾸고
				int change = N / 2;
				for (int i = 0; i < N / 2; i++) {
					for (int j = 0; j < M; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[change][j];
						arr[change][j] = temp;
					}
					change++;
				}
				// 2랑 4 바꿈
				int changeCol = N / 2;
				int changeRow;
				for (int i = 0; i < N / 2; i++) {
					changeRow = M / 2;
					for (int j = 0; j < M / 2; j++) {
						int temp = arr[i][j];
						arr[i][j] = arr[changeCol][changeRow];
						arr[changeCol][changeRow] = temp;
						changeRow++;
					}
					changeCol++;
				}
				break;
			}

		}
		// 배열 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
