import java.io.*;

public class BOJ_1316_그룹단어체커 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		check: for (int i = 0; i < N; i++) {
			char[] str = br.readLine().toCharArray();

			boolean[] alpha = new boolean[26];

			// a = 97

			char cur = str[0];
			alpha[cur - '0' - 49] = true;
			for (int j = 1; j < str.length; j++) {
				char prev = cur;
				cur = str[j];

				if (cur == prev) {
					continue;
				} else {
					if (!alpha[cur - '0' - 49]) {
						alpha[cur - '0' - 49] = true;
					} else {
						continue check;
					}
				}
			}

			cnt++;
		}
		System.out.println(cnt);
	}
}
