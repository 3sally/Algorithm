import java.io.*;
import java.util.*;

public class BOJ_2303_숫자게임 {

	static int N, MAX;
	static int sel[];
	static List<List<Integer>> cards;
	static List<Integer> maxSum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 전체 사람 수

		cards = new LinkedList<List<Integer>>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			List<Integer> card = new LinkedList<Integer>();
			for (int j = 0; j < 5; j++) {
				card.add(Integer.parseInt(st.nextToken()));
			}
			cards.add(card);
		}

		maxSum = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			maxSum.add(0);
		}

		MAX = 0;

		sel = new int[3];

		comb(0, 0);

		for (int i = N - 1; i >= 0; i--) {
			if (maxSum.get(i) == MAX) {
				System.out.println(i + 1);
				return;
			}
		}
	}

	private static void comb(int cnt, int start) {
		if (cnt == 3) {
			calSum();
			return;
		}

		for (int i = start; i < 5; i++) {
			sel[cnt] = i;
			comb(cnt + 1, i + 1);
		}
	}

	private static void calSum() {
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += cards.get(i).get(sel[j]);
			}
			if (maxSum.get(i) < (sum % 10)) {
				maxSum.set(i, sum % 10);
			}

			MAX = Math.max(MAX, maxSum.get(i));
		}
	}
}
