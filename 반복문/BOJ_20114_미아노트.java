import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20114_미아노트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		char[] origin = new char[N];
		Arrays.fill(origin, '?');

		char[][] water = new char[H][N * W];
		for (int i = 0; i < H; i++) {
			char str[] = br.readLine().toCharArray();
			for (int j = 0; j < N * W; j++) {
				water[i][j] = str[j];
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N * W; j += W) {
				for (int l = 0; l < W; l++) {
					if (water[i][j + l] != '?' && origin[(j + l) / W] == '?') {
						origin[(j + l) / W] = water[i][(j + l)];
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (char c : origin) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
