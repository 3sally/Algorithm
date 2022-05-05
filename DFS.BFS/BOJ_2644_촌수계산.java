import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {

    static List<List<Integer>> relation;
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        relation = new LinkedList<>();
        for (int i = 0; i <= N; i++) {
            relation.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            relation.get(parent).add(child);
            relation.get(child).add(parent);
        }

        answer = -1;
        visited = new boolean[N+1];


        dfs(start, end, 0);
        System.out.println(answer);

    }

    private static void dfs(int start, int end, int cnt) {
        if(start==end){
            answer = cnt;
            return;
        }

        visited[start] = true;
        for (int r : relation.get(start)){
            if(!visited[r]){
                dfs(r, end, cnt+1);
            }
        }
    }
}
