import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {

			sb.append("#").append(tc).append(" ");

			int LENGTH = Integer.parseInt(br.readLine()); // 원본 암호문의 길이

			LinkedList<Integer> secret = new LinkedList<Integer>(); // 암호문을 저장할 배열
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 원본 암호문 저장
			while (st.hasMoreTokens()) {
				secret.add(Integer.parseInt(st.nextToken()));
			}

			int ORDERCNT = Integer.parseInt(br.readLine()); // 명령어의 개수
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < ORDERCNT; i++) {
				if (st.nextToken().equals("I")) {
					int X = Integer.parseInt(st.nextToken());
					int Y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < Y; j++) {
						int S = Integer.parseInt(st.nextToken());
						secret.add(X, S);
						X++;
					}
				}
			}

			for (int i = 0; i < 10; i++) {
				sb.append(secret.get(i)).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);

	}
}