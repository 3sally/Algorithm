import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1496_딱지놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 라운드 수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int sizeA = Integer.parseInt(st.nextToken());
			int[] A = new int[sizeA];
			int starA = 0, circleA = 0, squareA = 0, triA = 0;
			for (int idx = 0; idx < A.length; idx++) {
				A[idx] = Integer.parseInt(st.nextToken());
				switch (A[idx]) {
				case 4:
					starA++;
					break;
				case 3:
					circleA++;
					break;
				case 2:
					squareA++;
					break;
				case 1:
					triA++;
					break;
				}
			}
			st = new StringTokenizer(br.readLine());
			int sizeB = Integer.parseInt(st.nextToken());
			int[] B = new int[sizeB];
			int starB = 0, circleB = 0, squareB = 0, triB = 0;
			for (int idx = 0; idx < B.length; idx++) {
				B[idx] = Integer.parseInt(st.nextToken());
				switch (B[idx]) {
				case 4:
					starB++;
					break;
				case 3:
					circleB++;
					break;
				case 2:
					squareB++;
					break;
				case 1:
					triB++;
					break;
				}
			}

			char winner;

			if (starA != starB) {
				winner = starA > starB ? 'A' : 'B';
				System.out.println(winner);
				continue;
			} else if (circleA != circleB) {
				winner = circleA > circleB ? 'A' : 'B';
				System.out.println(winner);
				continue;
			} else if (squareA != squareB) {
				winner = squareA > squareB ? 'A' : 'B';
				System.out.println(winner);
				continue;
			} else if (triA != triB) {
				winner = triA > triB ? 'A' : 'B';
				System.out.println(winner);
				continue;
			} else {
				System.out.println('D');
			}

		}
	}
}
