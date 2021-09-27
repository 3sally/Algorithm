import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11050_이항계수1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		System.out.println(sol(N, M) % 1000000007);
	}

	private static int sol(int a, int b) {
		if (b == 0 || a == b)
			return 1;
		return sol(a - 1, b - 1) + sol(a - 1, b);
	}
}
