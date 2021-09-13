import java.io.*;
import java.util.Stack;

public class BOJ_10773_제로 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> money = new Stack<Integer>();

		for (int i = 0; i < K; i++) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0) {
				money.pop();
			} else {
				money.push(N);
			}
		}

		int sum = 0;
		while (!money.isEmpty()) {
			sum += money.pop();
		}

		System.out.println(sum);
	}
}
