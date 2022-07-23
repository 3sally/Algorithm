import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079_입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());

        int[] time = new int[N];
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(time); // 시간 오름차순

        long left = 0;
        long right = time[N-1] * M;
        long answer = 0;

        while (left<=right){
            long mid = (left + right)/2;
            long cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += mid/time[i];
            }

            if(cnt<M){
                left = mid+1;
            }else{
                right = mid-1;
                answer = mid;
            }
        }

        System.out.println(answer);
    }
}
