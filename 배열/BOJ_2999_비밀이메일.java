import java.io.*;

public class BOJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] msg = br.readLine().toCharArray();
		int N = msg.length;

		int R = 0;
		int C = 0;

		for (int i = 1; i <= N; i++) {
			if (N % i == 0) {
				if (i <= (N / i)) {
					R = Math.max(R, i);
					C = N / R;
				}
			}
		}

		char[][] msgArr = new char[R][C];
		int idx = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				msgArr[j][i] = msg[idx++];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(msgArr[i][j]);
			}
		}

		System.out.println(sb);
	}
}
