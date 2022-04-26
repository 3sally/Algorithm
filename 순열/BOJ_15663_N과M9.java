import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_15663_N과M9 {

    static int N, M, num[];
    static LinkedHashSet<String> numList;
    static int[] selected;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        st= new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        selected = new int[M];
        visited = new boolean[N];
        numList = new LinkedHashSet<>();
        
        perm(0);
        StringBuilder sb = new StringBuilder();
        for (String list : numList) {
            sb.append(list);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void perm(int cnt) {
        if(cnt==M){
            String str = "";
            for (int i = 0; i < M; i++) {
                str += selected[i] + " ";
            }
            numList.add(str);
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
