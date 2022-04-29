import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minH = 0;
        int maxH = 0;

        int[] H = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            H[i] = Integer.parseInt(st.nextToken());
            maxH = Math.max(maxH, H[i]);
        }

        while(minH<maxH){
            int mid = (minH+maxH)/2;
            long cut = 0;

            for (int i = 0; i < N; i++) {
                if(H[i]-mid>0){
                    cut += (H[i]-mid);
                }
            }

            if(cut>=M){
                minH = mid+1;
            }else if(cut<M){
                maxH= mid;
            }
        }

        System.out.println(minH-1);
    }
}
