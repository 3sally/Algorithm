import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1244_스위치켜고끄기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int switchCnt = Integer.parseInt(bf.readLine()); // 스위치 개수
		StringTokenizer st = new StringTokenizer(bf.readLine(), " "); // 스위치 상태 한줄을 space로 구분해서 token화
		int[] switchState = new int[switchCnt];

		for (int i = 0; i < switchCnt; i++) {
			switchState[i] = Integer.parseInt(st.nextToken());
		}

		int student = Integer.parseInt(bf.readLine()); // 학생 수

		for (int i = 0; i < student; i++) {
			StringTokenizer st2 = new StringTokenizer(bf.readLine(), " ");
			int gender = Integer.parseInt(st2.nextToken());
			int switchNum = Integer.parseInt(st2.nextToken());

			if (gender == 1) { // 남자
				for (int j = switchNum; j <= switchCnt; j++) {
					if (j % switchNum == 0) {
						if (switchState[j - 1] == 1)
							switchState[j - 1] = 0;
						else
							switchState[j - 1] = 1;
					}
				}
			} else if (gender == 2) { // 여자

				switchNum = switchNum - 1;

				// 자기 자신 바꾸기
				if (switchState[switchNum] == 1)
					switchState[switchNum] = 0;
				else
					switchState[switchNum] = 1;

				int n = 1;
				// 양옆보기
				while (true) {
					if ((switchNum - n) >= 0 && (switchNum + n) < switchCnt) {
						if (switchState[switchNum - n] == switchState[switchNum + n]) {
							if (switchState[switchNum - n] == 1) {
								switchState[switchNum - n] = 0;
								switchState[switchNum + n] = 0;
							} else {
								switchState[switchNum - n] = 1;
								switchState[switchNum + n] = 1;
							}
							n++;
						} else
							break;
					} else {
						break;
					}
				}

			}
		}

		for (int i = 0; i < switchState.length; i++) {
			System.out.print(switchState[i] + " ");
			if ((i + 1) % 20 == 0)
				System.out.println();
		}
	}
}
