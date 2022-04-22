import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

    static int N, cost[][];
    static int[] order;
    static boolean[] visited;
    static int minCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[N];
        visited = new boolean[N];
        minCost = Integer.MAX_VALUE;
        perm(0);
        System.out.println(minCost);
    }

    private static void perm(int cnt) {
        if(cnt==N){
            int totalCost = 0;
            // 비용 계산
            for (int i = 0; i < N-1; i++) {
                if(canMove(order[i], order[i+1])) {
                    totalCost += cost[order[i]][order[i+1]];
                }else {
                    return;
                }
            }
            if(canMove(order[N-1],order[0]))
                totalCost += cost[order[N-1]][order[0]];
            else
                return;

            minCost = Math.min(minCost, totalCost);

            return;
        }

        for (int i = 0; i < N; i++) {
            if(visited[i])
                continue;
            order[cnt] = i;
            visited[i] = true;
            perm(cnt+1);
            visited[i] = false;
        }
    }

    private static boolean canMove(int i, int j) {
        if(cost[i][j]==0){
            return false;
        }
        return true;
    }
}
