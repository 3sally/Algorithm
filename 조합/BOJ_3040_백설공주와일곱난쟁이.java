import java.io.*;

public class BOJ_3040_백설공주와일곱난쟁이 {

	static int[] smuff;
	static int[] real;
	static int TOTAL = 100;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		smuff = new int[9];
		for (int i = 0; i < 9; i++) {
			smuff[i] = Integer.parseInt(br.readLine());
		}

		real = new int[7];
		findSmuff(0, 0);
	}

	private static void findSmuff(int cnt, int start) {
		if (cnt == 7) {
			isReal();
			return;
		}

		for (int i = start; i < 9; i++) {
			real[cnt] = smuff[i];
			findSmuff(cnt + 1, i + 1);
		}
	}

	private static void isReal() {
		int sum = 0;
		for (int i = 0; i < 7; i++) {
			sum += real[i];
		}

		if (sum == TOTAL) {
			for (int num : real)
				System.out.println(num);
		}
	}
}
