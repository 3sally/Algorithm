import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2661_좋은수열 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        makeNum("");
    }

    private static void makeNum(String str) {
        if(str.length()==N){
            System.out.println(str);
            System.exit(0);
        }

        for (int i = 1; i <= 3; i++) {
            if(isGood(str+i))
                makeNum(str + i);
        }
    }

    private static boolean isGood(String str) {
        int len = str.length()/2;

        //뒤에서부터 N/2개까지 비교
        for (int i = 1; i <= len; i++) {
            if(str.substring(str.length()-i).equals(str.substring(str.length()-2*i, str.length()-i))){
                return false;
            }
        }
        return true;
    }
}
