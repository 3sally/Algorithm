class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int network = 0;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                DFS(i,n,computers);
                network++;
            }
        }
        
        return network;
    }
    
    public void DFS(int i,int n, int[][] computers){
        visited[i] = true;
        for(int j = 0; j<n; j++){
            if(computers[i][j]==1 && !visited[j]){
                DFS(j,n,computers);
            }
        }
    }
}