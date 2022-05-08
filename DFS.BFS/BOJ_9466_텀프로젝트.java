import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466_텀프로젝트 {

    static int[] select;
    static boolean[] visited;
    static boolean[] finished;
    static boolean canTeam;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            select = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <=N ; j++) {
                select[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <=N ; j++) {
                dfs(j);
            }
            sb.append(N-result).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int num) {
         visited[num] = true;
        int next = select[num];

        if(!visited[next])
            dfs(next);
        else{
            if(!finished[next]) {
                result++;
                while (next != num) {
                    result++;
                    next = select[next];
                }
            }
        }
        finished[num] = true;
    }
}
