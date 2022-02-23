import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14400_편의점2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int middleX, middleY;

		int[][] customers = new int[N][2];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			customers[i][0] = Integer.parseInt(st.nextToken());
			customers[i][1] = Integer.parseInt(st.nextToken());
		}

		// x기준으로 정렬
		Arrays.sort(customers, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		middleX = customers[N / 2][0];

		// y기준으로 정렬
		Arrays.sort(customers, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}

		});

		middleY = customers[N / 2][1];

		long sum = 0;

		for (int i = 0; i < N; i++) {
			long dist = Math.abs(customers[i][0] - middleX) + Math.abs(customers[i][1] - middleY);
			sum += dist;
		}

		System.out.println(sum);
	}
}
