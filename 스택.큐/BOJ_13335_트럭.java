import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13335_트럭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 트럭 수
        int W = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 다리 최대하중

        Queue<Integer> truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        int weight = 0;
        int time = 0;
        int idx = 0;

        while (!bridge.isEmpty()){
            weight -= bridge.poll();

            if(!truck.isEmpty()){
                if(truck.peek() + weight <= L){
                    weight += truck.peek();
                    bridge.offer(truck.poll());
                }else{
                    bridge.offer(0);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
