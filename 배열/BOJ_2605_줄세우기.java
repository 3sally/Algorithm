import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2605_줄세우기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int STUDENT = Integer.parseInt(br.readLine());

		// int[] student = new int[STUDENT];
		ArrayList<Integer> student = new ArrayList<Integer>();
		// 학생 배열
		for (int i = 1; i <= STUDENT; i++) {
			// student[i - 1] = i;
			student.add(i);
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 학생들이 순서대로 번호 뽑을 때마다
		for (int i = 0; i < STUDENT; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num == 0) // 제자리에 가만히 암것도 안함
				continue;

			int temp = student.remove(i);
			student.add(i - num, temp);
		}

		for (int s : student) {
			System.out.print(s + " ");
		}
	}
}
