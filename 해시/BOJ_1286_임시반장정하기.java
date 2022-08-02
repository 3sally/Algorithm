import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1286_임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 학생 수

        int[][] arr = new int[N][5];
        int banjang = 0;
        int maxFriends = 0;

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 한 학년씩 확인
        for (int i = 0; i < N; i++) {
            Set<Integer> same = new HashSet<>();

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < N; k++) {
                    if(arr[i][j]==arr[k][j] && k!=i){
                        same.add(k);
                    }
                }
            }

            if(maxFriends < same.size()){
                banjang = i;
                maxFriends = same.size();
            }
        }

        System.out.print(banjang+1);
    }
}
