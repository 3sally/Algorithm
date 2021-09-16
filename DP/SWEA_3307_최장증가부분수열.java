import java.io.*;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int[] LIS = new int[N];

			int max = 0;
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;

				for (int j = 0; j < i; j++) {
					if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1)
						LIS[i] = LIS[j] + 1;
				}

				if (max < LIS[i]) {
					max = LIS[i];
				}
			}
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}
}
