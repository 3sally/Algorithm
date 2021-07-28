import java.io.*;

public class BOJ_10807_개수세기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine(); // 정수의 개수
		String s = br.readLine(); // 정수가 공백으로 구분되어져서
		String str[] = s.split(" ");
		String v = br.readLine(); // 찾으려고 하는 정수
		int result = 0;

		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(v)) {
				result++;
			}
		}

		System.out.println(result);
	}
}