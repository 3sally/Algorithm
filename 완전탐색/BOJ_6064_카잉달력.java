import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6064_카잉달력 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int i = 0; i < TC; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			// 나머지값이 0이 나오는 것을 방지하기 위해 -1 (이해 잘 안됨 ㅜ)
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			boolean check = false;

			for (int j = x; j < M * N; j += M) {
				if (j % N == y) {
					sb.append(j + 1).append("\n");
					check = true;
					break;
				}
			}

			if (!check) {
				sb.append(-1).append("\n");
			}
		}
		System.out.println(sb);
	}
}
