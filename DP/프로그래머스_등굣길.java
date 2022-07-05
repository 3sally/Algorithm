// dfs로 하면 정확성은 통과
// dp로 해야 정확성 + 효율성까지 통과 
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int map[][] = new int[m+1][n+1];

        // 웅덩이 표시 
        for(int i = 0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[x][y] = -1;
        }
        
        map[1][1] = 1; // 집 
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
                // 점화식 [i][j] = [i][j-1] + [i-1][j]
                if(map[i][j]>-1){ // 웅덩이 제외
                    if(map[i][j-1]>0){
                        map[i][j] += map[i][j-1] % 1000000007;
                    }
                    if(map[i-1][j]>0){
                        map[i][j] += map[i-1][j] % 1000000007;
                    }
                }
            }
        }
        return map[m][n] % 1000000007;
    }
    
}