import java.io.*;

public class BOJ_2744_대소문자바꾸기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		String[] arr = new String[str.length()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = str.charAt(i) + "";
		}

		for (String s : arr) {
			if ((s.toUpperCase()).equals(s)) {
				s = s.toLowerCase();
			} else if ((s.toLowerCase()).equals(s)) {
				s = s.toUpperCase();
			}
			sb.append(s);
		}

		System.out.println(sb);
	}
}
