import java.io.*;

public class BOJ_8393_합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int sum = 0;

		for (int i = 1; i <= N; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
