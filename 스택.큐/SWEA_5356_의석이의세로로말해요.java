import java.io.*;
import java.util.*;

public class SWEA_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");

			ArrayList<Queue<Character>> words = new ArrayList<Queue<Character>>();

			for (int i = 0; i < 5; i++) {
				String word = br.readLine();
				Queue<Character> q = new LinkedList<Character>();
				words.add(q);
				for (int j = 0; j < word.length(); j++) {
					words.get(i).offer(word.charAt(j));
				}
			}

			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 5; j++) {
					if (!words.get(j).isEmpty())
						sb.append(words.get(j).poll());
				}
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}
}
