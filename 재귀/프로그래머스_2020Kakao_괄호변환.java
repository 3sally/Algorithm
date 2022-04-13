import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_2020Kakao_괄호변환 {
	public static void main(String[] args) throws IOException {
		String p = ")(";

		System.out.println(solution(p));
	}

	private static String solution(String p) {
		String answer = "";

		// p가 올바른 문자열인지 검사
		if (isCorrect(p)) {
			// 올바르면
			answer = p;
		} else {
			answer += change(p);
		}

		return answer;
	}

	private static String change(String p) {

		// 빈 문자열인 경우 빈 문자열 반환
		if (p.isEmpty()) {
			return p;
		}

		// 문자열 u, v로 쪼개기
		String u = p.substring(0, split(p));
		String v = p.substring(split(p), p.length());

		// 문자열 u가 올바른 문자열인지 검사
		if (isCorrect(u)) {
			return u + change(v);
		} else {
			String str = "(";
			str += change(v);
			str += ")";

			u = u.substring(1, u.length() - 1);
			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(')
					str += ")";
				else
					str += "(";
			}

			return str;
		}

	}

	private static int split(String p) {
		int open = 0;
		int close = 0;
		int idx = 0;
		for (idx = 0; idx < p.length(); idx++) {
			if (p.charAt(idx) == '(') {
				open++;
			} else {
				close++;
			}
			if (open == close) {
				break;
			}
		}
		return idx + 1;
	}

	private static boolean isCorrect(String p) {
		Queue<Character> q = new LinkedList<Character>();
		char[] arr = p.toCharArray();
		for (char c : arr) {
			q.offer(c);
		}

		Queue<Character> temp = new LinkedList<Character>();

		while (!q.isEmpty()) {
			char c = q.poll();

			if (c == '(') {
				temp.offer(c);
			} else {
				if (temp.isEmpty()) {
					temp.offer(c);
				} else {
					if (temp.peek() == '(') {
						temp.poll();
					}
				}
			}
		}

		if (temp.size() > 0) {
			return false;
		} else {
			return true;
		}
	}
}
