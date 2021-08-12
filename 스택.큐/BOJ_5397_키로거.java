import java.io.*;
import java.util.*;

public class BOJ_5397_키로거 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int i = 0; i < TC; i++) {
			char[] inputs = br.readLine().toCharArray();

			Queue<Character> keyQ = new LinkedList<Character>();

			for (int j = 0; j < inputs.length; j++) {
				keyQ.offer(inputs[j]);
			}

			Stack<Character> password = new Stack<Character>();
			Stack<Character> temp = new Stack<Character>();

			StringBuilder pw = new StringBuilder();

			while (!keyQ.isEmpty()) {

				char currentKey = keyQ.poll();
				switch (currentKey) {
				case '-':
					if (!password.isEmpty())
						password.pop();
					break;

				case '<':
					if (!password.isEmpty())
						temp.push(password.pop());
					break;

				case '>':
					if (!temp.isEmpty())
						password.push(temp.pop());
					break;

				default:
					password.push(currentKey);
					break;
				}
			}

			while (!temp.isEmpty()) {
				password.push(temp.pop());
			}

			while (!password.isEmpty()) {
				pw.append(password.pop());
			}

			pw.reverse();
			System.out.println(pw);
		}
	}
}
