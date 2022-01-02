import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6236_용돈관리 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] pay = new int[N];
		int left = 0;
		int right = 0;
		for (int i = 0; i < N; i++) {
			pay[i] = Integer.parseInt(br.readLine());
			left = Math.min(left, pay[i]);
			right += pay[i];
		}

		while (left <= right) {
			int mid = (left + right) / 2;

			int cnt = 0;
			int curMoney = 0;
			boolean flag = true;

			for (int i = 0; i < N; i++) {
				// 인출한 돈보다 지출이 클 경우
				if (mid < pay[i]) {
					flag = false;
					break;
				}

				// 가지고 있는 돈이 지출할 돈보다 작을 경우
				if (curMoney < pay[i]) {
					cnt++;
					curMoney = mid; // ?..
					if (cnt > M) {
						flag = false;
						break;
					}
				}

				// 가지고 있는 돈이 지출할 돈보다 많은 경우 그냥 거기서 지출
				curMoney -= pay[i];
			}

			if (flag) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
}
