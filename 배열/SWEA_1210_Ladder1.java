
import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int ladder[][] = new int[100][100]; // 100 x 100 크기의 2차원 배열로 주어진 사다리

		for (int tc = 0; tc < 10; tc++) { // 테케 열개 주어짐
			int TC = Integer.parseInt(bf.readLine()); // 테케 번호 (1-10)
			sb.append("#").append(TC).append(" ");

			// 100X100 배열 채우기
			for (int i = 0; i < 100; i++) {
				String line = bf.readLine();
				StringTokenizer st = new StringTokenizer(line, " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int col = 0;
			int row = 0; // 위치를 계속 저장하기 위해

			// 사다리 맨 마지막 줄에서 2찾기 -> 여기가 도착점
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) {
					col = 99;
					row = i;
				}
			}

			for (col = 99; col >= 0; col--) {
				// 왼쪽으로 더 이상 1이 아닐때까지 가기
				if (row - 1 >= 0 && ladder[col][row - 1] == 1) {
					while (row - 1 >= 0 && ladder[col][row - 1] == 1) {
						row--;
					}
				}
				// 오른쪽으로 더 이상 1이 아닐때까지 가기
				else if (row + 1 < 100 && ladder[col][row + 1] == 1) {
					while (row + 1 < 100 && ladder[col][row + 1] == 1) {
						row++;
					}
				}
			}

			sb.append(row);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
