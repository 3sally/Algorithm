import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16931_겉넓이구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int size = (N*M)*2; // 위 아래 겉넓이

        int[][] square = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 네 면 검사
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(j==0){
                    size+=square[j][i];
                }else{
                    if((square[j][i]>square[j-1][i])){
                        size+=square[j][i]-square[j-1][i];
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = N-1; j >=0 ; j--) {
                if(j==N-1){
                    size+=square[j][i];
                }else{
                    if((square[j][i]>square[j+1][i])){
                        size+=square[j][i]-square[j+1][i];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(j==0){
                    size+=square[i][j];
                }else{
                    if((square[i][j]>square[i][j-1])){
                        size+=square[i][j]-square[i][j-1];
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = M-1; j >=0 ; j--) {
                if(j==M-1){
                    size+=square[i][j];
                }else{
                    if((square[i][j]>square[i][j+1])){
                        size+=square[i][j]-square[i][j+1];
                    }
                }
            }
        }

        System.out.println(size);

    }
}
