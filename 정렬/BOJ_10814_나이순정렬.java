import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10814_나이순정렬 {

    static class Member implements Comparable<Member>{
        int order;
        int age;
        String name;

        public Member(int order, int age, String name) {
            this.age = age;
            this.name = name;
        }


        @Override
        public int compareTo(Member o) {
            if(this.age == o.age){
                return this.order - o.order;
            }
            return this.age - o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 온라인 저지에 회원 수

        Member[] members = new Member[N]; // 멤버 배열

        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members[i] = new Member(i, age, name);
        }

        Arrays.sort(members);

        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.println(sb);
    }
}
