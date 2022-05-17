import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1339_단어수학 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int[] alpha = new int[26];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            int ten = (int)Math.pow(10, words[i].length()-1);
            for (int j = 0; j < words[i].length(); j++) {
                alpha[words[i].charAt(j)-65] += ten;
                ten /= 10;
            }
        }

        Arrays.sort(alpha);
        int idx = 9;
        int sum = 0;
        for (int i = alpha.length-1; i >=0; i--) {
            if(alpha[i]==0){
                continue;
            }
            sum+= alpha[i]*idx;
            idx--;
        }

        System.out.println(sum);
    }
}

