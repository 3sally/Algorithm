import java.io.*;

public class BOJ_2167_2차원배열의합 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long A = Long.parseLong(br.readLine());
		long B = Long.parseLong(br.readLine());
		long C = Long.parseLong(br.readLine());

		long result = A * B * C;
		String resultStr = result + "";
		char[] resultArr = resultStr.toCharArray();
		int[] arr = new int[10];
		for (int i = 0; i < resultArr.length; i++) {
			int idx = resultArr[i] - '0';
			arr[idx]++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(i).append("\n");
		}

		System.out.println(sb);
	}
}
