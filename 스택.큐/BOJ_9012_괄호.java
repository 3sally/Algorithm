import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            boolean isVPS = true;
            char[] gwalho = br.readLine().toCharArray();

            Stack<Character> s = new Stack<>();
            for (int j = 0; j < gwalho.length; j++) {
                if (gwalho[j] == '(') {
                    s.push(gwalho[j]);
                } else {
                    if (s.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        if (s.peek() == '(') {
                            s.pop();
                        } else {
                            isVPS = false;
                            break;
                        }
                    }
                }
            }

            if(!s.isEmpty())
                isVPS = false;

            if (isVPS)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}
