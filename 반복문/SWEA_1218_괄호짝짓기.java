
import java.io.*;

public class SWEA_1218_괄호짝짓기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		in = new BufferedReader(new InputStreamReader(new FileInputStream("input_1218.txt")));
		StringBuilder sb = new StringBuilder();

		// 테케 10번 지정
		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int LEN = Integer.parseInt(in.readLine()); // 테스트 케이스의 길이
			String STR = in.readLine(); // 테스트 케이스

			char arr[] = new char[LEN];

			for (int i = 0; i < LEN; i++) {
				arr[i] = STR.toCharArray()[i]; // 배열에 한 문자씩 집어넣음
			}

			for (int i = 0; i < LEN; i++) {

				switch (arr[i]) {
				case '{':
					for (int j = i + 1; j < LEN; j++) {
						if (arr[j] == '}') {
							arr[i] = '-';
							arr[j] = '-';
							break;
						}
					}
					break;

				case '(':
					for (int j = i + 1; j < LEN; j++) {
						if (arr[j] == ')') {
							arr[i] = '-';
							arr[j] = '-';
							break;
						}
					}
					break;

				case '<':
					for (int j = i + 1; j < LEN; j++) {
						if (arr[j] == '>') {
							arr[i] = '-';
							arr[j] = '-';
							break;
						}
					}
					break;

				case '[':
					for (int j = i + 1; j < LEN; j++) {
						if (arr[j] == ']') {
							arr[i] = '-';
							arr[j] = '-';
							break;
						}
					}
					break;

				default: // 안 걸리면
					continue;
				}
			}

			int result = 1;

			for (int i = 0; i < LEN; i++) {
				if (arr[i] != '-') {
					result = 0;
					break;
				}
			}
			sb.append(result + "\n");

		}
		System.out.println(sb);
	}
}
