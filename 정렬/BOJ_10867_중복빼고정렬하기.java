import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> hashSet = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
           hashSet.add(Integer.parseInt(st.nextToken()));
        }



        StringBuilder sb = new StringBuilder();
        for (int i: hashSet) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
