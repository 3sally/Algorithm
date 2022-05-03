import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_10655_마라톤1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Point[] checkPoint = new Point[N];

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            checkPoint[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dist = new int[N-1];
        int totalDist = 0;

        for (int i = 0; i < N-1; i++) {
            dist[i] = Math.abs(checkPoint[i].x - checkPoint[i+1].x) + Math.abs(checkPoint[i].y - checkPoint[i+1].y);
            totalDist += dist[i];
        }

        int maxDiff = 0;

        for (int i = 0; i < N-2; i++) {
            int diff = Math.abs(checkPoint[i].x - checkPoint[i+2].x) + Math.abs(checkPoint[i].y - checkPoint[i+2].y);
            maxDiff = Math.max(maxDiff, dist[i]+dist[i+1]-diff);
        }

        System.out.println(totalDist-maxDiff);
    }
}
