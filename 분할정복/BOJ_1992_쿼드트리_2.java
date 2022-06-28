import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1992_쿼드트리_2 {
    static char[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        sb = new StringBuilder();
        divide(0,0, N);
        System.out.println(sb);
    }

    private static void divide(int x, int y, int size) {

        boolean isSame = true;
        char ch = map[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if(map[i][j]!=ch){
                    sb.append("(");
                    isSame = false;
                    break;
                }
            }
            if(!isSame)
                break;
        }


        if(isSame){
            sb.append(ch);
        }else{
            size /= 2;
            divide(x,y,size);
            divide(x, y+size, size);
            divide(x+size, y, size);
            divide(x+size, y+size, size);

            sb.append(")");
        }
    }
}
