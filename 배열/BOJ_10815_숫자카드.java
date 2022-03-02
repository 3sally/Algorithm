import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] cards = new int[20000001];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int card = Integer.parseInt(st.nextToken()) + 10000000;
			cards[card] = 1;
		}

		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken()) + 10000000;
			if (cards[num] == 1)
				sb.append("1 ");
			else
				sb.append("0 ");
		}

		System.out.println(sb);

	}
}
