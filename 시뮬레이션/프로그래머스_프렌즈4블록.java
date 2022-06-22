class Solution {
    
    static int dx[] = {0,1,0,1};
    static int dy[] = {0,0,1,1};
    static char[][] map, copyMap;
    
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        map = new char[m][n];
        for(int i = 0; i<m; i++){
            map[i] = board[i].toCharArray();
        }
            
        while(true){
            // 맵 복사
            copyMap = new char[m][n];
            for(int i = 0; i<m; i++){
                for(int j = 0; j<n; j++){
                    copyMap[i][j] = map[i][j];
                }
            }
            
            boolean getScore = false;
            // 2x2인 부분 찾기
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n-1; j++){
                    if(copyMap[i][j]!='.' && checkBlock(i,j)){ // 지울 수 있는 블럭이면
                        getScore = true;
                        
                        for(int d = 0; d < 4; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if(map[nx][ny]!='.'){
                                map[nx][ny] = '.';
                                answer ++;
                            }
                        }
                    }
                }
            }
           
            //블록 내리기
            for(int i = 0; i<m-1; i++){
                for(int j = 0; j<n; j++){
                    if(map[i+1][j]=='.'){
                        for(int k = i; k>=0; k--){
                            map[k+1][j] = map[k][j];
                        }
                        map[0][j] = '.';
                    }
                }
            }
            
            if(!getScore){ // 더 이상 점수 낼거 없으면 끝
                break;
            }
        }
        
        
        return answer;
    }
    
    private boolean checkBlock(int i, int j){
        char block = copyMap[i][j];
        for(int d = 0; d < 4; d++){
            int nx = i + dx[d];
            int ny = j + dy[d];
            if(copyMap[nx][ny]!=block){
                return false;
            }
        }
        return true;
    }
}