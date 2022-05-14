import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11729_하노이탑이동순서 {

    static int cnt;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cnt = 0;
        sb = new StringBuilder();
        hanoi(N,1,2,3);
        System.out.println(cnt);
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if(n==1){
            cnt++;
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        // start -> end

        // 1. n-1 개를 1->2로 이동
        hanoi(n-1, start,end, mid);

        // 2. 마지막 한개를 3으로 이동
        cnt++;
        sb.append(start).append(" ").append(end).append("\n");

        // 3. n-1 개를 2->3로 이동
        hanoi(n-1, mid, start, end);
    }
}
