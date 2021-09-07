import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2776_암기왕 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<Integer, Boolean> note1 = new HashMap<Integer, Boolean>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				note1.put(Integer.parseInt(st.nextToken()), true);
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				if (note1.containsKey(Integer.parseInt(st.nextToken()))) {
					bw.write("1\n");
				} else
					bw.write("0\n");
			}
			bw.flush();
		}
	}
}
