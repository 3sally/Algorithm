import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1208_Flatten {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) { // 테스트 케이스는 10번
			sb.append("#").append(tc).append(" ");
			int maxDumpCnt = Integer.parseInt(bf.readLine()); // 덤프 횟수
			int[] box = new int[100]; // 100개의 상자의 높이 저장
			StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(box); // 오름차순으로 box 정렬
			for (int i = 0; i < maxDumpCnt; i++) {

				if (box[99] - box[0] <= 1) {
					break;
				}

				box[99]--; // box[99]는 100번째 박스이므로 제일 높이가 높은 박스값
				box[0]++; // 젤 처음에 있는건 제일 낮은 박스
				Arrays.sort(box);
			}

			int result = box[99] - box[0];

			sb.append(result);

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
