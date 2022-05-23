import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c:
             str.toCharArray()) {
            left.push(c);
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("L")){
                if(!left.isEmpty()){
                    right.push(left.pop());
                }
            }else if(command.equals("D")){
                if(!right.isEmpty()){
                    left.push(right.pop());
                }
            }else if(command.equals("B")){
                if(!left.isEmpty()){
                    left.pop();
                }
            }else if(command.equals("P")){
                String plus = st.nextToken();
                left.push(plus.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!left.isEmpty()){
            right.push(left.pop());
        }
        while (!right.isEmpty()){
            sb.append(right.pop());
        }

        System.out.println(sb);

    }
}
