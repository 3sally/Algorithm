import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_11650_좌표정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] p = new Point[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            p[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(p, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.x==o2.x){
                    return o1.y-o2.y;
                }
                return o1.x-o2.x;
            }
        });

       StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(p[i].x).append(" ").append(p[i].y).append("\n");
        }

        System.out.println(sb);
    }
}
