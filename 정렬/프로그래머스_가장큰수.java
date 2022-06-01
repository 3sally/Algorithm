import java.util.Arrays;
import java.util.Comparator;

public class 프로그래머스_가장큰수 {
    public static void main(String[] args) {
        int[] numbers = {3,30,34,5,9};

        System.out.println(solution(numbers));

    }

    private static String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];
        for (int i = 0; i< numbers.length; i++){
            str[i] = numbers[i]+"";
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        for(String s : str){
            answer+=s;
        }

        if(str[0].equals("0"))
            answer = "0";

        return answer;
    }
}
