import java.io.*;
import java.util.Stack;

public class BOJ_1874_스택수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] numArr = new int[N];

		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}

		Stack<Integer> stack = new Stack<Integer>();
		int num = 0;
		for (int i = 0; i < N; i++) {
			if (stack.isEmpty()) {
				do {
					stack.push(++num);
					sb.append("+\n");
				} while (stack.peek() < numArr[i]);
			}

			if (numArr[i] == stack.peek()) {
				stack.pop();
				sb.append("-\n");
			} else {
				if (stack.peek() > numArr[i]) {
					System.out.println("NO");
					return;
				}
				do {
					stack.push(++num);
					sb.append("+\n");
				} while (stack.peek() < numArr[i]);
				i--;
			}
		}
		System.out.println(sb);
	}
}