import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2669_직사각형네개의합집합의면적구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] arr = new int[100][100];

		int size = 0;

		// 네번의 입력
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int ldX = Integer.parseInt(st.nextToken());
			int ldY = Integer.parseInt(st.nextToken());
			int ruX = Integer.parseInt(st.nextToken());
			int ruY = Integer.parseInt(st.nextToken());

			for (int r = ldX; r < ruX; r++) {
				for (int c = ldY; c < ruY; c++) {
					if (arr[r][c] == 0) {
						size++;
						arr[r][c] = 1;
					}
				}
			}
		}

		System.out.println(size);
	}
}
