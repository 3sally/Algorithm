import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<Integer>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String order = st.nextToken();

            if(order.equals("push")){
                int x = Integer.parseInt(st.nextToken());
                s.push(x);
            }else if(order.equals("pop")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.pop()).append("\n");
                }
            }else if(order.equals("size")){
                sb.append(s.size()).append("\n");
            }else if(order.equals("empty")){
                if(s.isEmpty())
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }else if(order.equals("top")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
