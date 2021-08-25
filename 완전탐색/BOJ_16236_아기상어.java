import java.io.*;
import java.util.*;

class Shark implements Comparable<Shark> {
	int x;
	int y;
	int dist;

	public Shark(int x, int y, int dist) {
		super();
		this.x = x;
		this.y = y;
		this.dist = dist;
	}

	@Override
	public int compareTo(Shark o) {
		if (this.dist == o.dist) {
			if (this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
		return this.dist - o.dist;
	}
}

public class BOJ_16236_아기상어 {
	static int dX[] = { -1, 0, 1, 0 };
	static int dY[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] SPACE = new int[N][N];

		int sharkX = 0, sharkY = 0;
		int sharkSize = 2;

		LinkedList<Shark> q = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				SPACE[i][j] = Integer.parseInt(st.nextToken());
				if (SPACE[i][j] == 9) {
					SPACE[i][j] = 0;
					sharkX = i;
					sharkY = j;
					q.add(new Shark(i, j, sharkSize));
				}
			}
		}

		int eat = 0;
		int time = 0;
		while (true) {
			LinkedList<Shark> fish = new LinkedList<>();
			int[][] dist = new int[N][N];// 거리

			while (!q.isEmpty()) {
				Shark s = q.poll();
				for (int i = 0; i < 4; i++) {
					int nX = s.x + dX[i];
					int nY = s.y + dY[i];

					if (-1 < nX && nX < N && -1 < nY && nY < N && dist[nX][nY] == 0 && SPACE[nX][nY] <= sharkSize) {
						dist[nX][nY] = dist[s.x][s.y] + 1;
						// 먹잇감 포착
						if (1 <= SPACE[nX][nY] && SPACE[nX][nY] <= 6 && SPACE[nX][nY] < sharkSize) {
							fish.add(new Shark(nX, nY, dist[nX][nY]));
							q.add(new Shark(nX, nY, dist[nX][nY]));
							continue;
						}
						// 먹잇감 없음(지나가긴함)
						q.add(new Shark(nX, nY, dist[nX][nY]));
					}
				}
			}

			if (fish.size() == 0) {
				System.out.println(time);
				return;
			}

			Collections.sort(fish);
			Shark eatingFish = fish.get(0);

			time += eatingFish.dist;
			eat++;
			SPACE[eatingFish.x][eatingFish.y] = 0;
			if (eat == sharkSize) {
				sharkSize++;
				eat = 0;
			}
			q.add(new Shark(eatingFish.x, eatingFish.y, sharkSize));

		}

	}
}
