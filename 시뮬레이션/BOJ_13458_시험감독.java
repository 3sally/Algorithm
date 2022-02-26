import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13458_시험감독 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long[] A = new long[N];
		for (int i = 0; i < N; i++) {
			A[i] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());

		long all = 0;
		long sub = 0;
		for (int i = 0; i < N; i++) {
			all++;

			if (A[i] > B) {
				if ((A[i] - B) % C != 0) {
					sub += ((A[i] - B) / C) + 1;
				} else {
					sub += ((A[i] - B) / C);
				}
			}
		}

		System.out.println(all + sub);

	}
}
