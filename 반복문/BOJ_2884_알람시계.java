import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2884_알람시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //분이 45보다 크거나 같으면 그냥 빼고 끝
        if(M>=45){
            M -= 45;
        }
        //분이 45보다 작을 경우
        else{
            //분
            M = 60-(45-M);

            //시
            H -= 1;
            if(H==-1)
                H = 23;

        }

        System.out.println(H + " " + M);
    }
}
