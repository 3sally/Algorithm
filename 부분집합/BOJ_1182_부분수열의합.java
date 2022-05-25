import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {

    static  int N;
    static long S;
    static long[] num;
    static long[] selected;
    static long count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Long.parseLong(st.nextToken());
        num = new long[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
        }

        count = 0;
        // 부분수열 만들기
        for (int i = 1; i <= N; i++) {
            selected = new long[i];
            comb(0,0,i);
        }
        System.out.println(count);
    }

    private static void comb(int cnt, int start, int total) {
        if(cnt==total){
            long sum = 0;
            for (long n:selected) {
                sum += n;
            }
            if(sum==S){
                count++;
            }
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = num[i];
            comb(cnt+1, i+1, total);
        }
    }
}
