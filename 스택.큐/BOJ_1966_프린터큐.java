import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1966_프린터큐 {

    static class File{
        int num, priority;

        public File(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int count[] = new int[10];

            Queue<File> files = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int pri = Integer.parseInt(st.nextToken());
                files.add(new File(i, pri));
                count[pri]++;
            }

            int order = 1;

            while (true){
                File cur = files.poll();

                boolean canPrint = true;
                for (int i = cur.priority+1; i < 10; i++) {
                    if(count[i]>0) {
                        canPrint = false;
                        break;
                    }
                }

                if(canPrint){
                    if(cur.num==M){
                        sb.append(order).append("\n");
                        break;
                    }
                    order++;
                    count[cur.priority]--;
                }else{
                    files.offer(cur);
                }
            }
        }

        System.out.println(sb);
    }
}
