import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2108_통계학 {

    static class Number implements Comparable<Number>{
        int num;
        int cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            if(o.cnt==this.cnt){
                return this.num - o.num;
            }
            return o.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[i] = num;
            sum += num;

            if(map.containsKey(num)){
                int cnt = map.get(num);
                map.put(num, cnt+1);
            }else{
                map.put(num,1);
            }
        }

        double average = (double)sum / (double) N;
        sb.append(Math.round(average)).append("\n"); // 산술평균 math.round는 무조건 소수점 첫째 자리에서 반올림 해줌

        Arrays.sort(numbers);
        sb.append(numbers[N/2]).append("\n"); // 중앙값

        List<int[]> list = new LinkedList<>();
        Object[] keys = map.keySet().toArray();
        Object[] values = map.values().toArray();

        for (int i = 0; i < keys.length; i++) {
            list.add(new int[]{(int)keys[i],(int)values[i]});
        }

        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0]; // 숫자 오름차순 정렬
                }
                return o2[1]-o1[1]; // 나타나는 횟수 내림차순 정렬
            }
        });

        if(list.size()>1){
            if(list.get(0)[1]==list.get(1)[1]){
                sb.append(list.get(1)[0]).append("\n");
            }else{
                sb.append(list.get(0)[0]).append("\n");
            }
        }else {
            sb.append(list.get(0)[0]).append("\n");
        }

        sb.append(numbers[N-1] - numbers[0]); // 범위


        System.out.println(sb);
    }
}
