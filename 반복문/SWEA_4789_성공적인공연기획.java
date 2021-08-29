import java.io.*;

public class SWEA_4789_성공적인공연기획 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			sb.append("#").append(tc).append(" ");
			String str = br.readLine();
			int len = str.length();
			String[] strArr = str.split("");
			int[] clap = new int[len];

			int hireCnt = 0;
			int clapping = 0;

			for (int i = 0; i < len; i++) {
				clap[i] = Integer.parseInt(strArr[i]);
				if (clap[i] == 0)
					continue;
				if (i > clapping) {
					hireCnt += i - clapping;
					clapping = i + clap[i];
				} else {
					clapping += clap[i];
				}
			}

			sb.append(hireCnt).append("\n");
		}
		System.out.println(sb);
	}
}
