import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2174_로봇시뮬레이션 {

    static class Robot{
        int number; // 로봇 번호
        int x, y; // 로봇 위치
        int direction; // 로봇 방향

        public Robot(int number, int x, int y, int direction) {
            this.number = number;
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static int A, B, N, M;
    static int[][] map;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean flag;
    static String answer;
    static List<Robot> robots;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); // 가로
        B = Integer.parseInt(st.nextToken()); // 세로

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); // 로봇 개수
        M = Integer.parseInt(st.nextToken()); // 명령 개수

        map = new int[B][A];

        robots = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int direction = directionToInt(st.nextToken());

            x = B-x;
            y = y-1;

            robots.add(new Robot(i+1, x, y, direction));
            map[x][y] = i+1; //robot 있음
        }

        answer = "OK";
        flag = true;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int robotNumber = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            simulation(robots.get(robotNumber-1), order, count);
            if(!flag){
                break;
            }

        }

        System.out.println(answer);
    }

    private static void simulation(Robot robot, String order, int count) {
        if(order.equals("F")){ // 앞으로 한칸 전진
            int nx = robot.x;
            int ny = robot.y;

           for (int i = 0; i < count; i++) {
                nx += dx[robot.direction];
                ny += dy[robot.direction];

                if(nx<0 || nx>=B || ny<0 || ny>=A){ // 범위 넘으면
                    answer = "Robot " + robot.number + " crashes into the wall";
                    flag = false;
                    return;
                }

                if(map[nx][ny]!=0){ // 다른 로봇이랑 충돌하는 경우
                    answer = "Robot " + robot.number + " crashes into robot " + map[nx][ny];
                    flag = false;
                    return;
                }
            }

            map[robot.x][robot.y] = 0;
            map[nx][ny] = robot.number;
            robots.get(robot.number-1).x = nx;
            robots.get(robot.number-1).y = ny;
        }
        else if(order.equals("L")){
            int nd = robot.direction;
            for (int i = 0; i < count; i++) {
                nd = nd-1<0?3:nd-1;
            }
            robots.get(robot.number-1).direction = nd;
        }
        else if(order.equals("R")){
            int nd = robot.direction;
            for (int i = 0; i < count; i++) {
                nd= nd+1>3?0:nd+1;
            }
            robots.get(robot.number-1).direction = nd;
        }
    }

    private static int directionToInt(String direction) {
        if(direction.equals("N")){
            return 0;
        }else if(direction.equals("E")){
            return 1;
        }else if(direction.equals("S")){
            return 2;
        }else{
            return 3;
        }
    }
}
