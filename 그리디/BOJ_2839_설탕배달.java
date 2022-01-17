import java.io.*;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 배달해야할 설탕 무게

		if (N == 4 || N == 7) {
			System.out.println(-1);
		} else if (N % 5 == 0) {
			System.out.println(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println(N / 5 + 1);
		} else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println(N / 5 + 2);
		}

	}
}
