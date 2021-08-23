import java.io.*;
import java.util.*;

public class BOJ_1759_암호만들기 {
	static int L, C;
	static String[] password, alpha;
	static ArrayList<String> pw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		L = Integer.parseInt(st.nextToken()); // 서로 다른 L개의 알파벳 문자로 구성됨
		C = Integer.parseInt(st.nextToken()); // 암호로 사용한 문자의 종류 C가지

		alpha = new String[C];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken();
		}

		Arrays.sort(alpha);
		// System.out.println(Arrays.toString(alpha));

		password = new String[L];
		pw = new ArrayList<String>();
		// 조합
		makePW(0, 0);
		Collections.sort(pw);
		for (int i = 0; i < pw.size(); i++) {
			System.out.println(pw.get(i));
		}
	}

	private static void makePW(int cnt, int start) {
		if (cnt == L) {
			String str = new String();
			int mo = 0;
			int ja = 0;

			for (int i = 0; i < L; i++) {
				if (password[i].equals("a") || password[i].equals("e") || password[i].equals("i")
						|| password[i].equals("o") || password[i].equals("u")) {
					mo++;
				} else {
					ja++;
				}
			}

			if (mo >= 1 && ja >= 2) {
				for (String pw : password) {
					str += pw;
				}
				pw.add(str);
			}
			return;
		}

		for (int i = start; i < C; i++) {
			password[cnt] = alpha[i];
			makePW(cnt + 1, i + 1);
		}
	}
}
