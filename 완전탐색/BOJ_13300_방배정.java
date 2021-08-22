import java.io.*;
import java.util.StringTokenizer;

public class BOJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 수학여행에 참가하는 학생 수
		int K = Integer.parseInt(st.nextToken()); // 한방에 배정 할 수 있는 최대 인원

		int student[][] = new int[N][2]; // 성별과 학년 저장
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			student[n][0] = Integer.parseInt(st.nextToken()); // 성별
			student[n][1] = Integer.parseInt(st.nextToken()); // 학년
		}

		int room = 0;

		for (int i = 1; i <= 6; i++) { // 6학년까지 있으니깐
			int girlCnt = 0;
			int boyCnt = 0;
			for (int n = 0; n < N; n++) { // 전체 탐색이요
				if (student[n][1] == i) {
					if (student[n][0] == 0) {
						girlCnt++;
						if (girlCnt == K) {
							room++;
							girlCnt = 0;
						}
					} else {
						boyCnt++;
						if (boyCnt == K) {
							room++;
							boyCnt = 0;
						}
					}
				}
			}
			if (girlCnt != 0) {
				room++;
			}
			if (boyCnt != 0) {
				room++;
			}
		}
		System.out.println(room);
	}
}
