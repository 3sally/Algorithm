import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[] length = new int[6];
        int maxR = 0;
        int maxC = 0;
        int idxR = 0;
        int idxC = 0;

        // 1 동 , 2 서 , 3 남 , 4 북
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if(dir == 1 || dir == 2){
                maxC = Math.max(maxC, len);
                if(maxC==len){
                    idxC = i;
                }
            }else{
                maxR = Math.max(maxR, len);
                if(maxR==len){
                    idxR = i;
                }
            }

            length[i] = len;
        }


        // 최대 가로 길이 양 옆 두개
        int nc1 = idxR>0?length[idxR-1]:length[5];
        int nc2 = idxR<5?length[idxR+1]:length[0];
        // 최대 세로 길이 양 옆 두개
        int nr1 = idxC>0?length[idxC-1] : length[5];
        int nr2 = idxC<5?length[idxC+1]: length[0];


        int area = ((maxR-Math.min(nr1, nr2))*Math.min(nc1, nc2))+(maxC*Math.min(nr1, nr2));

        System.out.println(area * K);
    }
}
