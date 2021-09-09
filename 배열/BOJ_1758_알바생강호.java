import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758_알바생강호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer[] line = new Integer[N];

		for (int i = 0; i < N; i++) {
			line[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(line, Collections.reverseOrder());

		int tip = 0;
		long totalTip = 0;

		for (int i = 0; i < N; i++) {
			tip = line[i] - i;
			if (tip > 0)
				totalTip += tip;
		}

		System.out.println(totalTip);
	}

}
