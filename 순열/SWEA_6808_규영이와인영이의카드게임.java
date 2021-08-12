import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_6808_규영이와인영이의카드게임 {

	static int[] cardsIN; // 인영이가 가질 수 있는 카드들
	static int[] IN; // 인영이의 카드 조합
	static ArrayList<Integer> GU; // 규영이의 카드 조합
	static boolean[] isSelected;
	static int winGU, loseGU;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			GU = new ArrayList<Integer>(); // 규영이 카드
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 9; i++) {
				GU.add(Integer.parseInt(st.nextToken()));
			}

			cardsIN = new int[9]; // 인영이 카드
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (!GU.contains(i)) {
					cardsIN[index] = i;
					index++;
				}
			}

			IN = new int[9];
			isSelected = new boolean[9];
			// 인영이 카드 9개를 섞어 나올 수 있는 모든 순열 -> 순서 상관있으니깐 순열로 해결

			winGU = 0;
			loseGU = 0;
			mix(0);

			sb.append(winGU).append(" ").append(loseGU).append("\n");

		}
		System.out.println(sb);
	}

	private static void mix(int cnt) {
		if (cnt == 9) {

			int totalGU = 0, totalIN = 0; // 규영이와 인영이의 총합

			for (int i = 0; i < IN.length; i++) {
				if (GU.get(i) > IN[i])
					totalGU += (GU.get(i) + IN[i]); // 규영이 카드가 더 크면
				else
					totalIN += (GU.get(i) + IN[i]); // 인영이 카드가 더 크면
			}

			if (totalGU > totalIN)
				winGU++; // 규영이 이김 !
			else
				loseGU++; // 규영이 짐 ㅜ

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue; // 카드 사용했으면 다음 카드로
			IN[cnt] = cardsIN[i];
			isSelected[i] = true;
			mix(cnt + 1);
			isSelected[i] = false;
		}
	}
}
