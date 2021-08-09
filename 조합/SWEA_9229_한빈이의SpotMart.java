import java.io.*;
import java.util.StringTokenizer;

public class SWEA_9229_한빈이의SpotMart {
	static int SNACK, LIMIT;
	static int[] HEIGHT;
	static int[] choose;
	static int totalHeight, maxHeight;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			SNACK = Integer.parseInt(st.nextToken());
			LIMIT = Integer.parseInt(st.nextToken());

			HEIGHT = new int[SNACK];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < SNACK; i++) {
				HEIGHT[i] = Integer.parseInt(st.nextToken());
			}

			totalHeight = 0;
			choose = new int[2];
			maxHeight = -1;

			snackHeight(0, 0);
			sb.append(maxHeight).append("\n");
		}
		System.out.println(sb);
	}

	private static void snackHeight(int cnt, int start) {
		if (cnt == 2) {
			for (int i = 0; i < 2; i++) {
				totalHeight += choose[i];
			}

			if (totalHeight <= LIMIT) {
				maxHeight = totalHeight > maxHeight ? totalHeight : maxHeight;
			}

			totalHeight = 0;
			return;
		}

		for (int i = start; i < SNACK; i++) {
			choose[cnt] = HEIGHT[i];
			snackHeight(cnt + 1, i + 1);
		}
	}
}
