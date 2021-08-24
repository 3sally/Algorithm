import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int catchCnt[] = new int[N + 1];
		catchCnt[1] = 1;

		int throwCnt = 0;
		boolean gameOver = false;

		int now = 1;

		while (!gameOver) {
			if (catchCnt[now] % 2 == 1) {
				now = now + L;
				if (now > N)
					now = now - N;
				catchCnt[now]++;
			} else {
				now = now - L;
				if (now <= 0)
					now = N - Math.abs(now);
				catchCnt[now]++;
			}
			throwCnt++;
			for (int i = 1; i <= N; i++) {
				if (catchCnt[i] == M)
					gameOver = true;
			}
		}

		System.out.println(throwCnt);
	}
}
