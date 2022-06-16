import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int n = 1; // 최대공약수
        int m = 1; // 최소공배수

        for(int i = 2; i <= Math.min(x,y); i++){
            if(x%i == 0 && y%i==0){
                x /= i;
                y /= i;

                n *= i;
                i = 1;
            }
        }

        m = n * x * y;

        System.out.println(n);
        System.out.println(m);
    }
}
