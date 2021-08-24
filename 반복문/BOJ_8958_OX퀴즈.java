import java.io.*;

public class BOJ_8958_OX퀴즈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int i = 0; i < TC; i++) {
			char res[] = br.readLine().toCharArray();
			int sum = 0;
			int cnt = 0;

			for (int j = 0; j < res.length; j++) {
				if (res[j] == 'O') {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}

			System.out.println(sum);

		}
	}
}
