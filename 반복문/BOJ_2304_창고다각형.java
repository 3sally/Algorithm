import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class line implements Comparable<line> {
	int direct;
	int height;

	public line(int direct, int height) {
		super();
		this.direct = direct;
		this.height = height;
	}

	@Override
	public int compareTo(line o) {
		return this.direct - o.direct;
	}

}

public class BOJ_2304_창고다각형 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		line[] lines = new line[N];

		int maxHeight = 0;
		int maxDirect = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int direct = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(maxHeight, height);
			if (height == maxHeight)
				maxDirect = direct;
			lines[i] = new line(direct, height);
		}

		Arrays.sort(lines);
		int area = 0;
		int lastIdx = N - 1;
		for (int i = 0; i < N; i++) {
			if (lines[i].direct < maxDirect) {
				area += (lines[i + 1].direct - lines[i].direct) * lines[i].height;
				if (lines[i].height > lines[i + 1].height)
					lines[i + 1].height = lines[i].height;

			} else if (lines[i].direct == maxDirect) {
				area += lines[i].height;
			} else if (lines[i].direct > maxDirect) {
				int temp = i;
				i = lastIdx--;
				area += (lines[i].direct - lines[i - 1].direct) * lines[i].height;
				if (lines[i].height > lines[i - 1].height)
					lines[i - 1].height = lines[i].height;
				i = temp;
			}
		}
		System.out.println(area);
	}
}
