import java.io.*;

public class SWEA_1289_원재의메모리복구하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine()); // testcase 수

		for (int i = 0; i < T; i++) {

			char[] originMemArr = br.readLine().toCharArray(); // 원래 메모리 열로 전환

			StringBuilder resetMem = new StringBuilder(); // 초기화된 메모리

			// 원래 메모리 크기만큼 0으로 초기화
			for (int j = 0; j < originMemArr.length; j++) {
				resetMem.append('0');
			}

			char[] resetMemArr = resetMem.toString().toCharArray(); // 초기화된 메모리를 배열로 전환

			int fixCnt = 0; // 메모리 고치는 횟수

			int originMemLen = originMemArr.length; // 원래 메모리 길이

			for (int j = 0; j < originMemLen; j++) { // 원래 메모리 길이만큼 배열을 돌면서
				if (originMemArr[j] == resetMemArr[j]) { // 원래 메모리와 초기화된 메모리 부분이 같으면 pass
					continue;
				} else { // 값이 다르다면
					fixCnt++; // 고치는 횟수 +1
					for (int k = j; k < originMemLen; k++) { // 다른 부분부터 끝까지 원래의 메모리 값으로 변경
						resetMemArr[k] = originMemArr[j];
					}
				}
			}

			System.out.print("#" + (i + 1) + " " + fixCnt + "\n");
		}
	}
}
