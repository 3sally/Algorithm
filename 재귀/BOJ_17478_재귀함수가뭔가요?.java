package 재귀함수가뭔가요;

import java.io.*;

public class BOJ_17478_재귀함수가뭔가요 {
	static String answer[];
	static String underBar = "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 교수님이 출력을 원하는 재귀 횟수

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

		answer = new String[6];

		answer[0] = "\"재귀함수가 뭔가요?\"";
		answer[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		answer[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		answer[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		answer[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		answer[5] = "라고 답변하였지.";

		chatbot(N);
	}

	private static void chatbot(int N) {

		String temp = underBar;

		if (N == 0) {
			System.out.println(temp + answer[0]);
			System.out.println(temp + answer[4]);
			System.out.println(temp + answer[5]);
			return;
		}

		for (int i = 0; i < 4; i++) {
			System.out.println(temp + answer[i]);
		}

		underBar += "____";
		chatbot(N - 1);

		System.out.println(temp + answer[5]);
	}
}
