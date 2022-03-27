import java.io.*;
import java.util.Arrays;

public class BOJ_2309_일곱난쟁이 {

	static int height[];
	static int select[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		height = new int[9];
		for (int i = 0; i < 9; i++) {
			height[i] = Integer.parseInt(br.readLine());
		}

		select = new int[7];

		comb(0, 0);
	}

	private static void comb(int cnt, int start) {
		if (cnt == 7) {
			int total = 0;
			for (int height : select) {
				total += height;
			}

			if (total == 100) {
				Arrays.sort(select);
				for (int height : select) {
					System.out.println(height);
				}
				System.exit(0);
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			select[cnt] = height[i];
			comb(cnt + 1, i + 1);
		}

	}
}
