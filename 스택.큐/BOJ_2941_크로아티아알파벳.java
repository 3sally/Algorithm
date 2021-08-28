import java.io.*;
import java.util.Stack;

public class BOJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str = br.readLine().toCharArray();

		// c=, c-, dz=, d-, lj, nj, s=, z=
		Stack<Character> alpha = new Stack<Character>();
		for (char c : str)
			alpha.add(c);

		int cnt = 0;

		while (!alpha.isEmpty()) {
			char c = alpha.pop();
			if (alpha.isEmpty()) {
				cnt++;
				break;
			}
			switch (c) {
			case '=':
				if (alpha.peek() == 'c' || alpha.peek() == 'z' || alpha.peek() == 's') {
					char ch = alpha.pop();
					if (ch == 'z' && !alpha.isEmpty() && alpha.peek() == 'd') {
						alpha.pop();
					}
				}
				cnt++;
				break;
			case '-':
				if (alpha.peek() == 'c' || alpha.peek() == 'd')
					alpha.pop();
				cnt++;
				break;
			case 'j':
				if (alpha.peek() == 'l' || alpha.peek() == 'n')
					alpha.pop();
				cnt++;
				break;
			default:
				cnt++;
				break;
			}
		}
		System.out.println(cnt);
	}
}
