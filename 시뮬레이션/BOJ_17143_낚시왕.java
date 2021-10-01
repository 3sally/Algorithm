import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17143_낚시왕 {

	static class Shark {
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public String toString() {
			return "shark : " + this.r + ", " + this.c + ", " + this.z;
		}

	}

	static int R, C, M, r, c, s, d, z;
	static Shark[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 상어 수

		map = new Shark[R + 1][C + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken()); // 속력
			d = Integer.parseInt(st.nextToken()); // 이동방향 1:위, 2:아래, 3:오른쪽, 4:왼쪽
			z = Integer.parseInt(st.nextToken()); // 크기
			map[r][c] = new Shark(r, c, s, d, z);
		}

		System.out.println(fishing());
	}

	private static int fishing() {

		// 잡은 상어 크기
		int catchShark = 0;

		// 1. 낚시왕이 오른쪽으로 한칸 이동함
		for (int i = 1; i <= C; i++) {
			// 2. 낚시왕이 있는 열에 있는 상어 중에서 땅과 제일 가까운 상어를 잡음
			for (int j = 1; j <= R; j++) {
				if (map[j][i] != null) { // 상어가 있으면
					catchShark += map[j][i].z; // 잡은 상어 추가
					M--;
					map[j][i] = null; // 상어 사라짐
					break;
				}
			}

			// 3. 상어 이동
			// 이동방향 1:위, 2:아래, 3:오른쪽, 4:왼쪽
			Shark[] sharks = new Shark[M];
			int idx = 0;

			for (int r = 1; r <= R; r++) {
				for (int c = 1; c <= C; c++) {
					if (map[r][c] != null) {
						Shark s = map[r][c];
						if (s.d == 1 || s.d == 2) {
							for (int move = 0; move < s.s; move++) {
								if (s.d == 2)
									s.r++;
								else if (s.d == 1)
									s.r--;

								if (s.r <= 0) {
									s.d = 2;
									s.r += 2;
								} else if (s.r > R) {
									s.d = 1;
									s.r -= 2;
								}
							}
						} else if (s.d == 3 || s.d == 4) {
							for (int move = 0; move < s.s; move++) {
								if (s.d == 3)
									s.c++;
								else if (s.d == 4)
									s.c--;

								if (s.c <= 0) {
									s.d = 3;
									s.c += 2;
								} else if (s.c > C) {
									s.d = 4;
									s.c -= 2;
								}
							}
						}
						map[r][c] = null; // 원래 지도에서 없애주고
						sharks[idx++] = new Shark(s.r, s.c, s.s, s.d, s.z); // 상어 배열에 넣어줌
					}
				}
			}

			for (int j = 0; j < M; j++) {
				if (sharks[j] == null)
					continue;
				int r = sharks[j].r;
				int c = sharks[j].c;
				if (map[r][c] == null)
					map[r][c] = sharks[j];
				else {
					if (map[r][c].z < sharks[j].z) {
						map[r][c] = sharks[j];
					}
				}
			}
		}
		return catchShark;
	}
}
