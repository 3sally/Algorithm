import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_17413_단어뒤집기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] S = br.readLine().toCharArray();

		Queue<Character> queueS = new LinkedList<Character>();

		for (int i = 0; i < S.length; i++) {
			queueS.offer(S[i]);
		}

		StringBuilder str = new StringBuilder();

		while (!queueS.isEmpty()) {
			if (queueS.peek() == '<') {
				StringBuilder tag = new StringBuilder();
				while (queueS.peek() != '>') {
					tag.append(queueS.poll());
				}
				tag.append(queueS.poll());
				if (str != null) {
					System.out.print(str.reverse());
					str = new StringBuilder();
				}
				System.out.print(tag);
			} else {
				if (queueS.peek() == ' ') {
					queueS.poll();
					System.out.print(str.reverse() + " ");
					str = new StringBuilder();
				} else {
					str.append(queueS.poll());
				}
			}
		}
		if (str != null) {
			System.out.print(str.reverse());
		}
	}
}
