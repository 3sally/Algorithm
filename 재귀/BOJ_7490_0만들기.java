import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.script.*;

//백준 런타임 에러 -> 아마도 javax 를 인식 못해서 인가,, 

public class BOJ_7490_0만들기 {

	static int N, num[];
	static StringBuilder sb;
	static ScriptEngine engine;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		ScriptEngineManager s = new ScriptEngineManager();
		engine = s.getEngineByName("JavaScript");

		int TC = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < TC; tc++) {
			N = Integer.parseInt(br.readLine());

			String str = "";
			make(1, str);

		}
		System.out.println(sb);
	}

	private static void make(int i, String str) throws ScriptException {
		if (i == N) {
			str += i;
			cal(str.replace(" ", ""));
			return;
		}

		make(i + 1, str + i + " ");
		make(i + 1, str + i + "+");
		make(i + 1, str + i + "-");
	}

	private static void cal(String str) throws ScriptException {
		int result = (int) engine.eval(str);

		if (result == 0) {
			sb.append(str).append("\n");
		}
	}

}
