import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BOJ_15666_N과M12 {
    static int N, M, num[];
    static LinkedHashSet<String> numList;
    static int[] selected;

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
        numList = new LinkedHashSet<>();

        comb(0,0);
        StringBuilder sb = new StringBuilder();
        for (String list : numList) {
            sb.append(list);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void comb(int cnt, int start) {
        if(cnt==M){
            String str = "";
            for (int i = 0; i < M; i++) {
                str += selected[i] + " ";
            }
            numList.add(str);
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = num[i];
            comb(cnt+1, i);
        }
    }
}
