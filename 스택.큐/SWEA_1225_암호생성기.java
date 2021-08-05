import java.io.*;
import java.util.*;

public class SWEA_1225_암호생성기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int TC = Integer.parseInt(in.readLine());

			sb.append("#").append(TC).append(" ");

			Queue<Integer> queue = new LinkedList<Integer>();

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int temp;
			boolean turn = true;

			while (turn) {
				for (int i = 1; i <= 5; i++) {
					temp = queue.poll() - i;
					if (temp <= 0) {
						queue.offer(0);
						turn = false;
						break;
					}
					queue.offer(temp);
				}
			}

			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
