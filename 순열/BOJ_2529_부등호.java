import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2529_부등호 {

    static int k;
    static char[] sign;
    static boolean[] visited = new boolean[10];
    static List<String> nums = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        sign = new char[k];

        StringTokenizer st=new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken().charAt(0);
        }

        perm("",0);

        Collections.sort(nums);
        System.out.println(nums.get(nums.size()-1));
        System.out.println(nums.get(0));
    }

    private static void perm(String num, int cnt) {
        if(cnt==k+1){
            nums.add(num);
            return;
        }

        for (int i = 0; i <=9 ; i++) {
            if(visited[i])
                continue;
            if(cnt==0 || check(num.charAt(cnt-1)-'0', i, sign[cnt-1])){
                visited[i] = true;
                perm(num+i, cnt+1);
                visited[i] = false;
            }
        }
    }

    private static boolean check(int prev, int next, char sign) {
        if(sign=='<'){
            if (prev>next) return false;
        }else if(sign=='>'){
            if(prev<next) return false;
        }
        return true;
    }
}
