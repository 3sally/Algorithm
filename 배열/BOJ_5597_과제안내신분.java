import java.io.*;

public class BOJ_5597_과제안내신분 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		boolean[] num = new boolean[31];

		int n;

		for (int i = 0; i < 28; i++) {
			n = Integer.parseInt(br.readLine());
			num[n] = true;
		}

		for (int i = 1; i <= 30; i++) {
			if (!num[i])
				sb.append(i).append("\n");
		}

		System.out.println(sb);
	}
}
