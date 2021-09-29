import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_5643_키순서 {

	static int temp;
	static ArrayList<Integer>[] list;
	static int[] cnt;
	static boolean[] isVisited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			int N = Integer.parseInt(br.readLine()); // 학생들의 수
			int M = Integer.parseInt(br.readLine()); // 비교 횟수

			list = new ArrayList[N + 1]; // 1-N까지 저장
			cnt = new int[N + 1]; // 1-N까지 앞뒤 횟수 저장? 저장된값이 n-1이면 나의 순서 알 수 있음

			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
			}

			for (int i = 1; i <= N; i++) {
				temp = 0;
				isVisited = new boolean[N + 1];
				dfs(i);
				cnt[i] += temp;
			}

			int total = 0;
			for (int c : cnt) {
				if (c == N)
					total++;
			}
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {
		temp += 1;
		for (int i = 0; i < list[cur].size(); i++) {
			int next = list[cur].get(i);
			if (isVisited[next])
				continue;
			isVisited[next] = true;
			cnt[next] += 1;
			dfs(next);
		}
	}
}
