import java.io.*;
import java.util.*;

public class SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			char[] ch = br.readLine().toCharArray();

			Deque<Character> dq = new ArrayDeque<Character>();
			for (int i = 0; i < ch.length; i++) {
				dq.offer(ch[i]);
			}

			List<String> password = new LinkedList<String>();
			List<Integer> numPassword = new LinkedList<Integer>();
			int n = N / 4;

			for (int i = 0; i < n; i++) {
				char pop = dq.pollLast();
				dq.offerFirst(pop);

				for (int j = 0; j < N; j += n) {
					String s = "";
					for (int c = 0; c < n; c++) {
						pop = dq.pollFirst();
						s += pop;
						dq.offerLast(pop);
					}

					if (!password.contains(s)) {
						password.add(s);

						int num = 0;
						int powNum = n - 1;
						for (int l = 0; l < n; l++) {
							num += Integer.parseInt(s.charAt(l) + "", 16) * Math.pow(16, powNum--);
						}

						numPassword.add(num);
					}

				}

			}

			Collections.sort(numPassword);
			Collections.reverse(numPassword);

			sb.append(numPassword.get(K - 1)).append("\n");
		}

		System.out.println(sb);
	}
}
