import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Queue<Integer> cards = new LinkedList<Integer>();

		for (int i = 1; i <= N; i++) {
			cards.offer(i);
		}

		if (cards.size() == 1) {
			System.out.println(1);
			return;
		}

		while (!cards.isEmpty()) {
			cards.poll();
			if (cards.size() == 1) {
				System.out.println(cards.peek());
				return;
			}
			int card = cards.poll();
			cards.offer(card);
		}
	}
}
