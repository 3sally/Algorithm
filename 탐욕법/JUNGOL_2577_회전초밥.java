import java.io.*;
import java.util.StringTokenizer;

public class JUNGOL_2577_회전초밥 {

	static int N, d, k, c, sushis[], visit[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 접시 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

		visit = new int[d + 1];
		sushis = new int[N];
		for (int i = 0; i < N; i++) {
			sushis[i] = Integer.parseInt(br.readLine());
		}

		System.out.println(eat());
	}

	private static int eat() {
		int total = 0, max = 0;

		for (int i = 0; i < k; i++) {
			if (visit[sushis[i]] == 0)
				total++;
			visit[sushis[i]]++;
		}
		max = total;
		for (int i = 1; i < N; i++) {
			if (max <= total) {
				if (visit[c] == 0)
					max = total + 1;
				else
					max = total;
			}
			visit[sushis[i - 1]]--;
			if (visit[sushis[i - 1]] == 0)
				total--;

			if (visit[sushis[(i + k - 1) % N]] == 0)
				total++;
			visit[sushis[(i + k - 1) % N]]++;
		}
		return max;
	}

}
