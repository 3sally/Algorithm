import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

	static int minTime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] P = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(P);

		int time = 0;
		int totalTime = 0;

		for (int i = 0; i < N; i++) {
			time += P[i];
			totalTime += time;
		}
		System.out.println(totalTime);

	}
}
