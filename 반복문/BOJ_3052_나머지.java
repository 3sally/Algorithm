import java.io.*;
import java.util.ArrayList;

public class BOJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> remArr = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			int rem = Integer.parseInt(br.readLine()) % 42;
			if (!remArr.contains(rem)) {
				remArr.add(rem);
			}
		}

		System.out.println(remArr.size());
	}
}
