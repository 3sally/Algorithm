import java.io.*;
import java.util.*;

public class BOJ_5430_AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 0; t < T; t++) {
			char[] p = br.readLine().toCharArray();
			int n = Integer.parseInt(br.readLine());
			Deque<Integer> arr = new ArrayDeque<Integer>();
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");
			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			boolean isReverse = true;
			boolean isEmpty = false;
			for (int i = 0; i < p.length; i++) {
				if (p[i] == 'R') {
					isReverse = !isReverse;
				} else {
					if (isReverse) {
						if (arr.pollFirst() == null) {
							sb.append("error\n");
							isEmpty = true;
							break;
						}
					} else {
						if (arr.pollLast() == null) {
							sb.append("error\n");
							isEmpty = true;
							break;
						}
					}

				}
			}

			if (!isEmpty) {
				sb.append("[");
				if (arr.size() > 0) {
					if (isReverse) {
						while (arr.size() > 1) {
							sb.append(arr.pollFirst()).append(",");
						}
						sb.append(arr.pollFirst());
					} else {
						while (arr.size() > 1) {
							sb.append(arr.pollLast()).append(",");
						}
						sb.append(arr.pollLast());
					}
				}
				sb.append("]").append("\n");
			}

		}
		System.out.println(sb);
	}
}
