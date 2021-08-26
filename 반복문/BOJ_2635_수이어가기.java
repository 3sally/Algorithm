import java.io.*;
import java.util.ArrayList;

public class BOJ_2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int maxLen = 0;

		ArrayList<Integer> maxArr = new ArrayList<Integer>();

		for (int i = 0; i <= N; i++) {
			ArrayList<Integer> arr = new ArrayList<Integer>();
			arr.add(N);
			arr.add(i);

			int idx = 0;

			while (true) {
				int var = arr.get(idx) - arr.get(idx + 1);
				if (var >= 0) {
					arr.add(var);
					idx++;
				} else if (var < 0) {
					maxLen = Math.max(maxLen, arr.size());
					if (arr.size() == maxLen) {
						maxArr = arr;
					}
					break;
				}
			}
		}
		System.out.println(maxLen);
		for (int i : maxArr) {
			System.out.print(i + " ");
		}
	}
}
