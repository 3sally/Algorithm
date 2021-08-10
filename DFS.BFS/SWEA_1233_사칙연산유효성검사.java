import java.io.*;
import java.util.StringTokenizer;

public class SWEA_1233_사칙연산유효성검사 {

	static String[] NODES;
	static int NODECNT;
	static int possible;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int TC = 1; TC <= 10; TC++) {
			sb.append("#").append(TC).append(" ");

			NODECNT = Integer.parseInt(br.readLine());

			NODES = new String[NODECNT + 1];

			for (int i = 0; i < NODECNT; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				NODES[Integer.parseInt(st.nextToken())] = st.nextToken();
			}

			// 자식이 있는 부모노드는 연산자여야만 하고
			// 더 이상 자식이 없는 노드는 무조건 숫자여야함
			// 후위순회
			possible = 1;
			dfs(1);
			sb.append(possible).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(int current) {

		boolean hasChild = false; // 자식이 있는지 없는지 확인
		// 왼쪽 자식 노드 방문
		if (current * 2 <= NODECNT) {
			dfs(current * 2);
			hasChild = true;
		}
		// 오른쪽 자식 노드 방문
		if (current * 2 + 1 <= NODECNT)
			dfs(current * 2 + 1);

		// 현재 노드 처리
		if (hasChild) { // 자식이 있으면 무조건 연산자
			if (NODES[current].equals("1") || NODES[current].equals("2") || NODES[current].equals("3")
					|| NODES[current].equals("4") || NODES[current].equals("5") || NODES[current].equals("6")
					|| NODES[current].equals("7") || NODES[current].equals("8") || NODES[current].equals("9"))
				possible = 0;

		} else { // 자식이 없으면 무조건 숫자
			if (NODES[current].equals("+") || NODES[current].equals("*") || NODES[current].equals("/")
					|| NODES[current].equals("-"))
				possible = 0;

		}
		return 1;
	}
}
