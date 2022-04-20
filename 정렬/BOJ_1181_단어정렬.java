import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BOJ_1181_단어정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> words = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(!words.contains(word))
                words.add(word);
        }

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length()-o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word:words) {
            sb.append(word).append("\n");
        }
        System.out.println(sb);
    }
}
