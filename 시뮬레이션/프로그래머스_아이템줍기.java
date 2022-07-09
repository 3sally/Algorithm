import java.util.LinkedList;
import java.util.Queue;

public class 프로그래머스_아이템줍기 {
    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;

        solution(rectangle, characterX, characterY, itemX, itemY);
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int mapSize = 102;
    static int[][] map;

    static class Point{
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    private static void solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {

        map = new int[mapSize][mapSize];
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = rectangle[i][0]*2; j <=rectangle[i][2]*2 ; j++) {
                for (int k = rectangle[i][1]*2; k <=rectangle[i][3]*2 ; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // 둘레 빼고 나머지 다 0으로 바꾸기
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = rectangle[i][0]*2+1; j <rectangle[i][2]*2 ; j++) {
                for (int k = rectangle[i][1]*2+1; k <rectangle[i][3]*2 ; k++) {
                    map[j][k] = 0;
                }
            }
        }

        int answer = move(characterX*2, characterY*2, itemX*2, itemY*2);

        System.out.println(answer/2);
    }

    private static int move(int characterX, int characterY, int itemX, int itemY) {
        boolean[][] visited = new boolean[mapSize][mapSize];
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(characterX, characterY, 0));
        visited[characterX][characterY] = true;

        while(!q.isEmpty()){
            Point cur = q.poll();
            if(cur.x==itemX && cur.y==itemY){
                return cur.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(map[nx][ny]==1 && !visited[nx][ny]){
                    q.offer(new Point(nx, ny, cur.cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }
        return 0;
    }
}
