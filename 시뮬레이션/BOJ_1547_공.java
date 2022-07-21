import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1547_공 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M =  Integer.parseInt(br.readLine());
        List<Integer> cups = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            cups.add(i); // 0 1 2 3
        }

        StringTokenizer st = null;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int aIdx = cups.indexOf(a);
            int bIdx = cups.indexOf(b);
            cups.set(aIdx,b);
            cups.set(bIdx,a);
        }

        System.out.println(cups.get(1));
    }
}
