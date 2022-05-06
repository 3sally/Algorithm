class Solution {
    
    public int[] solution(int n) {
       int[][] map = new int[n][n];

        int num = 1;
        int move = n;
        int x = -1;
        int y = 0;

        while(true){
            // 1. 위에서 아래로
            for(int i = 0; i<move; i++){
                map[++x][y] = num++;
            }

            if(move==1)
                break;

            // 2. 왼쪽에서 오른쪽으로
            move--;
            for(int i = 0; i<move; i++){
                map[x][++y] = num++;
            }

            if(move==1)
                break;

            // 3. 대각선 위로
            move--;
            for(int i = 0; i<move; i++){
                map[--x][--y] = num++;
            }

            if(move==1)
                break;

            move--;
        }
        
        int size = 0;
        for(int i = 1; i<=n; i++){
            size += i;
        }
        
        int[] answer = new int[size];
        int idx = 0;
         for(int i = 0; i<n; i++){
            for(int j = 0;  j<n; j++){
               if(map[i][j]!=0){
                   answer[idx++] = map[i][j];
               }
            }
        }

        return answer;
    }
}