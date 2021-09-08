import java.io.*;

public class BOJ_20436_ZOAC3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[][] keyboard = { { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' }, // 10
				{ 'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l' }, // 9
				{ 'z', 'x', 'c', 'v', 'b', 'n', 'm' } // 7
		};

		char[] first = br.readLine().toCharArray();
		char sL = first[0]; // 왼손 검지
		int lR = 0, lC = 0; // 왼손 검지 처음 위
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < keyboard[i].length; j++) {
				if (keyboard[i][j] == sL) {
					lR = i;
					lC = j;
				}
			}
		}

		char sR = first[2]; // 오른손 검지
		int rR = 0, rC = 0; // 왼손 검지 처음 위
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < keyboard[i].length; j++) {
				if (keyboard[i][j] == sR) {
					rR = i;
					rC = j;
				}
			}
		}

		char[] str = br.readLine().toCharArray();

		int alphaR = 0, alphaC = 0;
		int time = 0;

		for (int r = 0; r < str.length; r++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < keyboard[i].length; j++) {
					if (keyboard[i][j] == str[r]) {
						alphaR = i;
						alphaC = j;

						if (j >= 5 || (i == 2 && j == 4)) {
							// 오른손으로
							time += Math.abs(rR - alphaR) + Math.abs(rC - alphaC);
							rR = alphaR;
							rC = alphaC;
						} else {
							// 왼손으로
							time += Math.abs(lR - alphaR) + Math.abs(lC - alphaC);
							lR = alphaR;
							lC = alphaC;
						}
					}
				}
			}
			time++;
		}
		System.out.println(time);
	}
}
