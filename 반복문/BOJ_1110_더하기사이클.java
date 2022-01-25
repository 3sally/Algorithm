import java.io.*;

public class BOJ_1110_더하기사이클 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int f = N / 10;
		int b = N - f * 10;

		int cnt = 0;
		int newN = -1;

		while (N != newN) {
			newN = b * 10 + ((f + b) - (f + b) / 10 * 10);
			f = newN / 10;
			b = newN - f * 10;
			cnt++;
		}

		System.out.println(cnt);
	}
}
