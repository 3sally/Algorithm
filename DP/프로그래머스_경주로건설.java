import java.util.*;
class Solution {
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int N, minCost;
    static int[][][] visited;
    static class Point{
        int x, y, direction, cost;

        public Point(int x, int y, int direction, int cost) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
		minCost = Integer.MAX_VALUE;
        N = board.length;

        visited = new int[N][N][4];

        bfs(board);
		return minCost;
    }
    
   private static void bfs(int[][] board) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0,0,-1,0));

        while (!q.isEmpty()){
            Point cur = q.poll();

            if(cur.x==N-1 && cur.y==N-1){
                minCost = Math.min(minCost, cur.cost);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int cost = cur.cost;

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny]==0){

                    if(cur.direction==-1 || cur.direction==d) { // 처음 또는 같은 방향 이동
                        cost+=100;
                    }else{
                        cost+=600;
                    }

                    if(visited[nx][ny][d]==0){
                        visited[nx][ny][d] = cost;
                        q.offer(new Point(nx,ny,d,cost));
                    }else{
                        if(visited[nx][ny][d]>=cost){
                            visited[nx][ny][d] = cost;
                            q.offer(new Point(nx,ny,d,cost));
                        }
                    }

                }
            }
        }
    }
}