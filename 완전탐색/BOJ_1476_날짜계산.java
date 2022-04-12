import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1476_날짜계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int e, s, m;
		e = s = m = 1;

		int year = 1;

		while (true) {
			if (e == E && s == S && m == M) {
				System.out.println(year);
				return;
			}

			if (e == 15)
				e = 1;
			else
				e++;

			if (s == 28)
				s = 1;
			else
				s++;

			if (m == 19)
				m = 1;
			else
				m++;

//			e = e == 15 ? 1 : e++;
//			s = s == 28 ? 1 : s++;
//			m = m == 19 ? 1 : m++;

			year++;

		}
	}
}
