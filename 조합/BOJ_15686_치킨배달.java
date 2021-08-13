import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

	static int M, houseCnt, chickenCnt;
	static int[][] house, chickenRun, chicken;
	static int chickenDist, cityChickenDist;
	static int minChickenDist, minCityChickenDist;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // NxN배열
		M = Integer.parseInt(st.nextToken()); // 최대 치킨집 수

		chickenRun = new int[M][2];

		int[][] CITY = new int[N + 1][N + 1];
		houseCnt = 0;
		chickenCnt = 0;

		// city 배열에 0,1,2 넣기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				CITY[i][j] = Integer.parseInt(st.nextToken());
				if (CITY[i][j] == 1)
					houseCnt++;
				else if (CITY[i][j] == 2)
					chickenCnt++;
			}
		}

		house = new int[houseCnt][2];
		chicken = new int[chickenCnt][2];
		int houseIdx = 0, chickenIdx = 0;
		// city 배열 돌면서 집,치킨집 위치 각 배열에 따로 저장
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (CITY[i][j] == 1) {
					house[houseIdx][0] = i;
					house[houseIdx][1] = j;
					houseIdx++;
				} else if (CITY[i][j] == 2) {
					chicken[chickenIdx][0] = i;
					chicken[chickenIdx][1] = j;
					chickenIdx++;
				}

			}
		}

		// 치킨집 순서 상관없으니깐 조합으로!!
		minCityChickenDist = Integer.MAX_VALUE;
		chooseChicken(0, 0);
		System.out.println(minCityChickenDist);
	}

	private static void chooseChicken(int cnt, int start) {
		if (cnt == M) { // 최대 치킨집 수만큼 뽑았으면 끝
			calDistance();
			return;
		}

		for (int i = start; i < chickenCnt; i++) {
			chickenRun[cnt][0] = chicken[i][0];
			chickenRun[cnt][1] = chicken[i][1];

			chooseChicken(cnt + 1, i + 1);
		}
	}

	private static void calDistance() {
		int distance = 0;
		int cityDist = 0;

		for (int i = 0; i < houseCnt; i++) {
			minChickenDist = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				distance = Math.abs(house[i][0] - chickenRun[j][0]) + Math.abs(house[i][1] - chickenRun[j][1]);
				minChickenDist = Math.min(distance, minChickenDist);
			}
			cityDist += minChickenDist;
		}
		minCityChickenDist = Math.min(cityDist, minCityChickenDist);
	}
}
