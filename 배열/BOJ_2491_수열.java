import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2491_수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		int[] ARR = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			ARR[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 1;
		int cntMax = 0;
		char flag = 'f';

		for (int i = 0; i < N - 1; i++) {
			int mark = ARR[i];

			// 주의할 점 같은 연속된 숫자!

			if (ARR[i + 1] > mark) {// 클때 flag가 다르면 작아지다가 커진거니깐 값 비교해주고 초기화
				if (flag != 'u') {
					cntMax = Math.max(cntMax, cnt);
					cnt = 1;
					for (int j = i; j > 0; j--) {
						if (ARR[j - 1] == mark)
							cnt++;
						else
							break;
					}
					flag = 'u';
				}
				cnt++;
			} else if (ARR[i + 1] == mark) {
				cnt++;
			} else if (ARR[i + 1] < mark) {
				if (flag != 'd') {
					cntMax = Math.max(cntMax, cnt);
					cnt = 1;
					for (int j = i; j > 0; j--) {
						if (ARR[j - 1] == mark)
							cnt++;
						else
							break;
					}
					flag = 'd';
				}
				cnt++;
			}
		}
		cntMax = Math.max(cntMax, cnt);

		System.out.println(cntMax);
	}
}
