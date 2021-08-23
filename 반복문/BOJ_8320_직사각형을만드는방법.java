import java.io.*;

public class BOJ_8320_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 정사각형 n개를 가지고 있음
		int make = 0;

		for (int i = 1; i <= n; i++) {
			for (int j = i; i * j <= n; j++) {
				make++;
			}
		}

		System.out.println(make);
	}
}
