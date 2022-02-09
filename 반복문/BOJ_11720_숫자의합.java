import java.io.*;

public class BOJ_11720_숫자의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		String str = br.readLine();
		for (int i = 0; i < N; i++) {
			int n = str.toCharArray()[i] - '0';
			sum += n;
		}

		System.out.println(sum);
	}
}
