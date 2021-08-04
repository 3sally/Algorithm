import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new InputStreamReader(new FileInputStream("input_1873.txt")));

		int TC = Integer.parseInt(in.readLine()); // 테스트케이스 개수
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " "); // 공백을 가지고 다음에 들어온 문장 분류
			int H = Integer.parseInt(st.nextToken()); // 행
			int W = Integer.parseInt(st.nextToken()); // 열

			char[][] map = new char[H][W]; // H X W크기 만큼의 배열 만듬

			// 맵 채우기
			for (int i = 0; i < H; i++) {
				String s = in.readLine();
				map[i] = s.toCharArray();
			}

			// 전차 찾기
			int carCol = 0, carRow = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						carCol = i;
						carRow = j;
					}
				}
			}

			int commandCnt = Integer.parseInt(in.readLine()); // 명령 수
			String command = in.readLine();
			for (int i = 0; i < commandCnt; i++) {
				char com = command.charAt(i);
				// 명령 한개씩 실행

				// U
				if (com == 'U') {
					if (carCol - 1 >= 0 && map[carCol - 1][carRow] == '.') { // 한칸 위가 배열밖이 아니거나 평지인경
						map[carCol][carRow] = '.'; // 원래 위치를 평지로 바꾸고
						carCol--; // 한칸 위로 이동
					}
					map[carCol][carRow] = '^'; // 차 방향 바꾸고
				}
				// D
				if (com == 'D') {
					if (carCol + 1 < H && map[carCol + 1][carRow] == '.') {
						map[carCol][carRow] = '.';
						carCol++;
					}
					map[carCol][carRow] = 'v';
				}
				// L
				if (com == 'L') {
					if (carRow - 1 >= 0 && map[carCol][carRow - 1] == '.') {
						map[carCol][carRow] = '.';
						carRow--;
					}
					map[carCol][carRow] = '<';
				}
				// R
				if (com == 'R') {
					if (carRow + 1 < W && map[carCol][carRow + 1] == '.') {
						map[carCol][carRow] = '.';
						carRow++;
					}
					map[carCol][carRow] = '>';
				}
				// S 포탄 발사
				if (com == 'S') {
					int col = carCol;
					int row = carRow;
					switch (map[col][row]) {
					case '^':
						if (col - 1 >= 0 && map[col - 1][row] != '#') { // 한칸위가 강철벽이 아니고 배열밖도 아니면
							while (col - 1 >= 0 && map[col - 1][row] != '#') { // 강철벽을 만나거나 배열밖으로 나갈때까지
								if (map[col - 1][row] == '-') { // 물이면
									col--; // 한칸 위로 가기
									continue;
								} else if (map[col - 1][row] == '*') {// 벽돌벽이면
									map[col - 1][row] = '.';
									break;
								}
								map[col - 1][row] = '.'; // 위를 평지로 바꿈
								col--; // 그 위도 보기 위해서
							}
						}
						break;

					case 'v':
						if (col + 1 < H && map[col + 1][row] != '#') {
							while (col + 1 < H && map[col + 1][row] != '#') {
								if (map[col + 1][row] == '-') {
									col++;
									continue;
								} else if (map[col + 1][row] == '*') {
									map[col + 1][row] = '.';
									break;
								}
								map[col + 1][row] = '.';
								col++;
							}
						}
						break;

					case '<':
						if (row - 1 >= 0 && map[col][row - 1] != '#') {
							while (row - 1 >= 0 && map[col][row - 1] != '#') {
								if (map[col][row - 1] == '-') {
									row--;
									continue;
								} else if (map[col][row - 1] == '*') {
									map[col][row - 1] = '.';
									break;
								}
								map[col][row - 1] = '.';
								row--;
							}
						}
						break;

					case '>':
						if (row + 1 < W && map[col][row + 1] != '#') {
							while (row + 1 < W && map[col][row + 1] != '#') {
								if (map[col][row + 1] == '-') {
									row++;
									continue;
								} else if (map[col][row + 1] == '*') {
									map[col][row + 1] = '.';
									break;
								}
								map[col][row + 1] = '.';
								row++;
							}
						}
						break;
					}
				}
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
