import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class BOJ_17140_이차원배열과연산 {

    static int r, c, k, time;
    static int x, y;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken())-1;
        c = Integer.parseInt(st.nextToken())-1;
        k = Integer.parseInt(st.nextToken());

        x = 3;
        y = 3;
        map = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        time = 0;

        while(true){

            if(x>r && y>c && map[r][c]==k){
                break;
            }

            if(time==100){
                time = -1;
                break;
            }

            if(x>=y){
                R();
            }else{
                C();
            }

            time++;
        }

        System.out.println(time);


    }

    static class Num{
        int number, cnt;

        public Num(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }

    private static void R() {
        List<List<Num>> nums = new LinkedList<>();
        int maxLen = 3;

        for (int i = 0; i < x; i++) {
            int[] cnt = new int[101];
            List<Num> num = new LinkedList<>();
            for (int j = 0; j < y; j++) {
                if(map[i][j]==0)
                    continue;
                cnt[map[i][j]]++;
            }

            for (int j = 0; j < 101; j++) {
                if(cnt[j]>0){
                    num.add(new Num(j, cnt[j]));
                }
            }

            Collections.sort(num, new Comparator<Num>() {
                @Override
                public int compare(Num o1, Num o2) {
                    if(o1.cnt==o2.cnt){
                        return o1.number-o2.number;
                    }
                    return o1.cnt-o2.cnt;
                }
            });


            nums.add(num);
            maxLen = Math.max(maxLen, num.size()*2);
        }

        if(maxLen>100){
            maxLen = 100;
        }

        y= maxLen;
        map = new int[x][y];

        for (int i = 0; i < x; i++) {
            int idx = 0;
            for (int j = 0; j < nums.get(i).size(); j++) {
                map[i][idx++] = nums.get(i).get(j).number;
                map[i][idx++] = nums.get(i).get(j).cnt;
            }
        }

    }

    private static void C() {
        List<List<Num>> nums = new LinkedList<>();
        int maxLen = 3;

        for (int i = 0; i < y; i++) {
            int[] cnt = new int[101];
            List<Num> num = new LinkedList<>();
            for (int j = 0; j < x; j++) {
                if(map[j][i]==0)
                    continue;
                cnt[map[j][i]]++;
            }

            for (int j = 0; j < 101; j++) {
                if(cnt[j]>0){
                    num.add(new Num(j, cnt[j]));
                }
            }

            Collections.sort(num, new Comparator<Num>() {
                @Override
                public int compare(Num o1, Num o2) {
                    if(o1.cnt==o2.cnt){
                        return o1.number-o2.number;
                    }
                    return o1.cnt-o2.cnt;
                }
            });


            nums.add(num);
            maxLen = Math.max(maxLen, num.size()*2);
        }

        if(maxLen>100){
            maxLen = 100;
        }

        x = maxLen;
        map = new int[x][y];

        for (int i = 0; i < y; i++) {
            int idx = 0;
            for (int j = 0; j < nums.get(i).size(); j++) {
                map[idx++][i] = nums.get(i).get(j).number;
                map[idx++][i] = nums.get(i).get(j).cnt;
            }
        }


    }
}
