class Solution {
	public int solution(int n, int k) {
		int answer = 0;

		StringBuilder sb = new StringBuilder();

		while (n > k) {
			sb.append(n % k); // 나머지
			n = n / k; // 몫
		}
		sb.append(n);

		sb.reverse();

		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '0') {
				if (temp.length() > 0 && check(temp.toString())) {
					answer++;
				}

				temp = new StringBuilder();
			} else {
				temp.append(sb.charAt(i));
			}
		}

		if (temp.length() > 0 && check(temp.toString())) {
			answer++;
		}

		return answer;
	}

	public boolean check(String temp) {
		long num = Long.parseLong(temp);

		if (num == 1)
			return false;

		for (long i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}