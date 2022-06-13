import java.util.*;

class Solution {
    
    static class Point{
        int x, y, move; 
        
        public Point(int x, int y, int move){
            this.x = x; 
            this.y = y; 
            this.move = move;
        }
    }
    
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int distL, distR;
    static boolean[][] visited;
    
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
        String answer = "";
    
        char curL = '*';
        char curR = '#';
        for(int i = 0;i<numbers.length; i++){
            int number = numbers[i];
           
            if(number=='1'-'0' || number=='4'-'0' || number=='7'-'0'){
                answer += "L";
                curL = (char)(number + 48);
            }else if(number=='3'-'0' || number=='6'-'0' || number=='9'-'0'){
                answer += "R";
                curR = (char)(number + 48);
            }else{
                distL = 0;
                distR = 0;
                
                Point L = null; 
                Point R = null;
                
                for(int k = 0; k<4; k++){
                    for(int j = 0; j<3; j++){
                        if(keypad[k][j]==curL){
                            L = new Point(k, j, 0);
                        }else if(keypad[k][j]==curR){
                            R = new Point(k,j,0);
                        }
                    }
                }
                
                visited = new boolean[4][3];
                bfs('L', L, (char)(number + 48), keypad);
                visited = new boolean[4][3];
                bfs('R', R, (char)(number + 48), keypad);
                
                if(distL==distR){
                    if(hand.equals("right")){
                        answer += "R";
                        curR = (char)(number+48);
                    }else {
                        answer += "L";
                        curL = (char)(number+48);
                    }
                }else if(distL < distR){
                    answer += "L";
                    curL = (char)(number+48);
                }else if(distR < distL){
                    answer += "R";
                    curR = (char)(number+48);
                }
            }
        }
        
        return answer;
    }
    
    private void bfs(char thumb, Point p, char c, int[][] keypad){
        Queue<Point> q = new LinkedList<>();
        q.offer(p);
        visited[p.x][p.y] = true;
        
        while(!q.isEmpty()){
            Point cur = q.poll();
            
            if(keypad[cur.x][cur.y]==c){
                if(thumb=='L'){
                    distL = cur.move;
                }else{
                    distR = cur.move;
                }
                
                return;
            }
            
            for(int d = 0; d<4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if(nx>=0 && nx<4 && ny>=0 && ny<3 && !visited[nx][ny]){
                    q.offer(new Point(nx, ny, cur.move+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}