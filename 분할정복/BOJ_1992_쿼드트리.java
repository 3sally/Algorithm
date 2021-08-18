import java.io.*;

public class BOJ_1992_쿼드트리 {
	static int movie[][];
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		movie = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				movie[i][j] = Integer.parseInt(str.split("")[j]);
			}
		}

		divide(0, 0, N);
		System.out.println(sb);

	}

	private static void divide(int i, int j, int size) {
		boolean same = true;

		// 배열 돌면서 처음 배열의 원소를 기준으로 같지 않은게 있는지 검사
		// 같지 않은게 있으면 same을 false로 바꾸고 반복문 멈춰~!
		bp: for (int n = i; n < i + size; n++) {
			for (int m = j; m < j + size; m++) {
				if (movie[n][m] != movie[i][j]) {
					sb.append("(");
					same = false;
					break bp;
				}
			}
		}

		// 만약 다 돌았는데 같으면 처음 기준으로 했던 원소에 따라서 0아님 1 붙힘
		if (same) {
			if (movie[i][j] == 0) {
				sb.append("0");
			} else {
				sb.append("1");
			}
			return;
		}

		// 다른게 있다면 여기까지 내려오고
		size /= 2; // 반 잘라서 확인해야돼! 4분면 확인
		divide(i, j, size); // 왼쪽 위
		divide(i, j + size, size); // 오른쪽 위
		divide(i + size, j, size); // 왼쪽 아래
		divide(i + size, j + size, size); // 오른쪽 아래

		sb.append(")");
	}
}
