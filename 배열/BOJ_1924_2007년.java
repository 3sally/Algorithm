import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1924_2007년 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		String[] days = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
		int[] dates = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int totalDate = 0;

		for (int i = 1; i < x; i++) {
			totalDate += dates[i]; // 만약 x가 3이면 2월달까지의 모든 날짜 더함
		}
		totalDate += y; // 그리고 몇일 지났는지 더해주고

		int res = totalDate % 7; // 7로 나누어서 그 나머지를 인덱스로 해서 몇요일인지 구하기
		System.out.println(days[res]);
	}
}
