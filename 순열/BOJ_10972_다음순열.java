import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10972_다음순열 {

	static int N, arr[];
	static String str;
	static boolean visited[];
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] input = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		if (np(input)) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(input[i]).append(" ");
			}
			System.out.println(sb);
		} else {
			System.out.println("-1");
		}

	}

	private static boolean np(int[] input) {
		int i = input.length - 1;
		while (i > 0 && input[i - 1] >= input[i])
			--i;
		if (i <= 0)
			return false;

		int j = input.length - 1;
		while (input[i - 1] >= input[j])
			--j;

		swap(input, i - 1, j);

		int k = input.length - 1; // 맨뒤부터
		while (i < k) {
			swap(input, i++, k--);
		}

		return true;
	}

	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
