import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1472_소트인사이드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(char c : arr){
           sb.append(c);
        }

        System.out.println(sb.reverse());
    }
}
