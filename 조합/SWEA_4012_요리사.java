import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int N, minusMin, tasteA, tasteB;
	static int[][] food;
	static int[] choosed;
	static ArrayList<Integer> choosedA, choosedB;
	static int[] taste;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			N = Integer.parseInt(br.readLine());

			food = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			choosed = new int[N / 2];
			choosedA = new ArrayList<Integer>();
			choosedB = new ArrayList<Integer>();
			minusMin = Integer.MAX_VALUE;
			// 조합
			choose(0, 0);
			sb.append(minusMin).append("\n");
		}
		System.out.println(sb);
	}

	private static void choose(int cnt, int start) {
		if (cnt == N / 2) {
			for (int i = 0; i < choosed.length; i++) {
				choosedA.add(choosed[i]);
			}

			for (int i = 0; i < N; i++) {
				if (!choosedA.contains(i)) {
					choosedB.add(i);
				}
			}
			cooking();

			choosedA.clear();
			choosedB.clear();

			return;
		}

		for (int i = start; i < N; i++) {
			choosed[cnt] = i;
			choose(cnt + 1, i + 1);
		}

	}

	private static void cooking() {
		taste = new int[2];
		tasteA = 0;
		tasteB = 0;
		cookA(0, 0);
		cookB(0, 0);

		minusMin = Math.min(minusMin, Math.abs(tasteA - tasteB));
	}

	private static void cookA(int cnt, int start) {
		if (cnt == 2) {
			tasteA += food[taste[0]][taste[1]];
			tasteA += food[taste[1]][taste[0]];
			return;
		}

		for (int i = start; i < N / 2; i++) {
			taste[cnt] = choosedA.get(i);
			cookA(cnt + 1, i + 1);
		}

	}

	private static void cookB(int cnt, int start) {
		if (cnt == 2) {
			tasteB += food[taste[0]][taste[1]];
			tasteB += food[taste[1]][taste[0]];
			return;
		}

		for (int i = start; i < N / 2; i++) {
			taste[cnt] = choosedB.get(i);
			cookB(cnt + 1, i + 1);
		}

	}
}
