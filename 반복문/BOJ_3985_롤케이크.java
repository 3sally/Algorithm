import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3985_롤케이크 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int L = Integer.parseInt(br.readLine());
		int[] rollcake = new int[L + 1];

		int N = Integer.parseInt(br.readLine());

		int expectMax = 0;
		int realMax = 0;

		int p1 = 0;
		int p2 = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cnt = 0;
			if ((end - start + 1) > expectMax) {
				expectMax = end - start + 1;
				p1 = i;
			}

			for (int j = start; j <= end; j++) {
				if (rollcake[j] == 0) {
					rollcake[j] = i;
					cnt++;
				}
			}

			if (cnt > realMax) {
				realMax = cnt;
				p2 = i;
			}
		}

		System.out.println(p1);
		System.out.println(p2);
	}
}
