import java.io.*;
import java.util.*;

public class SWEA_1223_계산기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int LEN = Integer.parseInt(br.readLine());
			String TC = br.readLine();

			Queue<String> postfix = new LinkedList<String>(); // 후위표기법
			Stack<String> operator = new Stack<String>(); // 연산자

			for (int i = 0; i < LEN; i++) {
				String ch = TC.split("")[i];

				if (ch.equals("+") || ch.equals("*")) { // 연산자면

					if (ch.equals("+")) { // 더하기면
						if (!operator.isEmpty()) {
							while (!operator.isEmpty()) {
								postfix.offer(operator.pop());
							}
						}
					} else { // 곱하기면
						if (!operator.isEmpty()) {
							if (operator.peek().equals("*")) {
								while (!operator.isEmpty()) {
									if (operator.peek().equals("+"))
										break;
									postfix.offer(operator.pop());
								}
							}
						}
					}
					operator.push(ch);
				} else { // 숫자면
					postfix.offer(ch);
				}
			}

			// 주어진 계산식 다 확인함
			// 연산자 남아있는거 마저 postfix에 넣기
			while (!operator.isEmpty()) {
				postfix.offer(operator.pop());
			}

			Stack<Integer> cal = new Stack<Integer>(); // 계산하기

			for (int i = 0; i < LEN; i++) {
				String ch = postfix.poll();
				if (ch.equals("+")) {
					cal.push(cal.pop() + cal.pop());
				} else if (ch.equals("*")) {
					cal.push(cal.pop() * cal.pop());
				} else { // 숫자면
					cal.push(Integer.parseInt(ch));
				}
			}

			sb.append(cal.pop()).append("\n");
		}
		System.out.println(sb);
	}
}
