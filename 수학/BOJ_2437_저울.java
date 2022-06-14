import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437_저울 {

    static int N, weights[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weights);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if(sum+1 < weights[i]){
                break;
            }
            sum += weights[i];
        }
        System.out.println(sum+1);
    }


}
