import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2789_블랙잭 {
	static int N, M, minDif, result;
	static int[] cards, selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cards = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}

		selected = new int[N];
		minDif = Integer.MAX_VALUE;
		result = 0;
		blackJak(0, 0);
		System.out.println(result);
	}

	private static void blackJak(int cnt, int start) {
		if (cnt == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += selected[i];
			}
			if (sum <= M) {
				minDif = Math.min(minDif, (M - sum));
				if (minDif == (M - sum))
					result = sum;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			selected[cnt] = cards[i];
			blackJak(cnt + 1, i + 1);
		}
	}
}
