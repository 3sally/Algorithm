import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1546_평균 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[] score = new double[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			score[i] = Double.parseDouble(st.nextToken());
		}
		Arrays.sort(score);
		double maxScore = score[N - 1];
		double total = 0;
		for (int i = 0; i < N; i++) {
			double newScore = score[i] / maxScore * 100;
			score[i] = newScore;
			total += score[i];
		}

		double avg = total / N;
		System.out.println(avg);

	}
}
