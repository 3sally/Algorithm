import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

    static int N, M;
    static List<List<Integer>> friend;
    static boolean[] visited;
    static boolean connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friend = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            friend.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            friend.get(f1).add(f2);
            friend.get(f2).add(f1);
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            connect = false;
            dfs(i,1);
            if(connect){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);

    }

    private static void dfs(int n, int friends) {
        if(friends==5){
            connect = true;
            return;
        }

        visited[n] = true;

        for (int num : friend.get(n)) {
            if(!visited[num]) {
                visited[num] = true;
                dfs(num, friends + 1);
            }
        }

        visited[n] = false;
    }
}
