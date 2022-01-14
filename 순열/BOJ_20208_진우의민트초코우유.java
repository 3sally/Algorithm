import java.awt.Point;
import java.io.*;
import java.util.*;

public class BOJ_20208_진우의민트초코우유 {

	static int N, M, H;
	static int map[][];
	static boolean drink[];
	static Point[] selected;
	static Point house;
	static List<Point> milk;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int maxMilk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		milk = new LinkedList<Point>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					house = new Point(i, j);
				if (map[i][j] == 2)
					milk.add(new Point(i, j));
			}
		}

		drink = new boolean[milk.size()];
		selected = new Point[milk.size()];
		maxMilk = 0;
		perumutation(0); // 우유 순열
		System.out.println(maxMilk);
	}

	private static void perumutation(int cnt) {
		if (cnt == milk.size()) {
			move();
			return;
		}

		for (int i = 0; i < milk.size(); i++) {
			if (drink[i])
				continue;
			selected[cnt] = milk.get(i);
			drink[i] = true;
			perumutation(cnt + 1);
			drink[i] = false;
		}
	}

	private static void move() {
		Point cur = house;
		int hp = M;
		int cnt = 0;

		for (Point milk : selected) {
			int dist = Math.abs(cur.x - milk.x) + Math.abs(cur.y - milk.y);
			if (dist > hp)
				break;
			else {
				hp -= dist;
				hp += H;
				cnt++;
				cur = new Point(milk.x, milk.y);
				int houseDist = Math.abs(house.x - milk.x) + Math.abs(house.y - milk.y);
				if (houseDist <= hp)
					maxMilk = Math.max(maxMilk, cnt);
			}
		}
	}
}
