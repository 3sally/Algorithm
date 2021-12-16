import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1072_게임 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		double X = Double.parseDouble(st.nextToken());
		double Y = Double.parseDouble(st.nextToken());

		int Z = (int) (Y * 100 / X);

		if (Z >= 99) {
			System.out.println("-1");
			return;
		}

		int left = 1;
		int right = 1000000000;
		int per;

		while (left + 1 < right) {
			int mid = (left + right) / 2;
			per = (int) ((Y + mid) * 100 / (X + mid));

			if (per > Z)
				right = mid;
			else
				left = mid;
		}

		per = (int) ((Y + left) * 100 / (X + left));
		if (per > Z)
			System.out.println(left);
		else
			System.out.println(right);

	}
}
