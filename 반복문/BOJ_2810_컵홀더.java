import java.io.*;

public class BOJ_2810_컵홀더 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 좌석의 수
		int cupHolder = 1; // 맨 처음 하나

		String[] seat = br.readLine().split("");
		int love = 0;

		for (int i = 0; i < N; i++) {

			if (seat[i].equals("S"))
				cupHolder++;
			else if (seat[i].equals("L")) {
				love++;
				if (love == 2) {
					cupHolder++;
					love = 0;
				}
			}
		}

		if (cupHolder >= N) {
			System.out.println(N);
		} else {
			System.out.println(cupHolder);
		}

	}
}
