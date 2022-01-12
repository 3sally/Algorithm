import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class BOJ_21756_지우개 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Integer> arr = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			arr.add(i);
		}

		int del = 0;
		while (true) {
			if (arr.size() == 1) {
				System.out.println(arr.get(0));
				break;
			}

			arr.remove(del);
			del++;

			if (del >= arr.size()) {
				del = 0;
			}
		}

	}
}
