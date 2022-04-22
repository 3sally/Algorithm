import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

    static int N, num[], maxSum;
    static int[] selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N];
        visited = new boolean[N];
        maxSum = Integer.MIN_VALUE;

        perm(0);
        System.out.println(maxSum);
    }

    private static void perm(int cnt) {
        if(cnt==N){
            //식 계산
            int sum = 0;
            for (int i = 0; i < N-1; i++) {
                sum += Math.abs(selected[i]-selected[i+1]);
            }

            maxSum = Math.max(maxSum, sum);
            return;
        }
        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            selected[cnt] = num[i];
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
