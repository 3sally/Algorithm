import java.util.*;

public class 프로그래머스_2021Kakao_메뉴리뉴얼 {
	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };

		System.out.println(solution(orders, course));
	}

	static Map<String, Integer> map;

	private static ArrayList<String> solution(String[] orders, int[] course) {

		ArrayList<String> answer = new ArrayList<>();

		// 문자열 오름차순 정렬
		for (int i = 0; i < orders.length; i++) {
			char[] arr = orders[i].toCharArray();
			Arrays.sort(arr);
			orders[i] = String.valueOf(arr);
		}

		// 코스 길이만큼 조합
		for (int i = 0; i < course.length; i++) {
			map = new HashMap<String, Integer>();
			int maxCnt = Integer.MIN_VALUE;

			for (int j = 0; j < orders.length; j++) {
				StringBuilder sb = new StringBuilder();

				if (course[i] <= orders[j].length()) {
					comb(orders[j], sb, 0, 0, course[i]);
				}
			}

			// 최대 주문 횟수
			for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
				maxCnt = Math.max(maxCnt, entry.getValue());
			}

			// 일치하는 거
			for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
				if (maxCnt >= 2 && entry.getValue() == maxCnt) {
					answer.add(entry.getKey());
				}
			}
		}

		Collections.sort(answer);

		return answer;

	}

	private static void comb(String string, StringBuilder sb, int cnt, int start, int n) {
		if (cnt == n) {
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
			return;
		}

		for (int i = start; i < string.length(); i++) {
			sb.append(string.charAt(i));
			comb(string, sb, cnt + 1, i + 1, n);
			sb.delete(cnt, cnt + 1);
		}

	}

}
