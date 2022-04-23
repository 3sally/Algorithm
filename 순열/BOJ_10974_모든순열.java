import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class BOJ_10974_모든순열 {

    static int N, selected[];
    static boolean[] visited;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        selected = new int[N];
        visited =new boolean[N+1];

        perm(0);
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(cnt==N){
            for (int num:
                 selected) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i])
                continue;
            selected[cnt] = i;
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;
        }
    }
}
