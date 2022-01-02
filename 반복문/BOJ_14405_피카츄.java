import java.io.*;

public class BOJ_14405_피카츄 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();

		boolean flag = true;

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == 'p') {
				if (i == S.length() - 1 || S.charAt(i + 1) != 'i') {
					flag = false;
					break;
				}
				i++;
			} else if (c == 'k') {
				if (i == S.length() - 1 || S.charAt(i + 1) != 'a') {
					flag = false;
					break;
				}
				i++;
			} else if (c == 'c') {
				if (i >= S.length() - 2 || S.charAt(i + 1) != 'h' || S.charAt(i + 2) != 'u') {
					flag = false;
					break;
				}
				i += 2;
			} else {
				flag = false;
				break;
			}
		}

		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}
