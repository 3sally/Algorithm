import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int s = board.length;
        int cnt = 0;
        
        Stack<Integer> basket = new Stack<>();
        for(int move : moves){
            for(int i = 0; i<s; i++){
                if(board[i][move-1]!=0){
                    // basket에 집어넣기 
                    if(!basket.isEmpty()){
                        if(basket.peek()==board[i][move-1]){
                            basket.pop();
                            cnt += 2;
                        }else{
                            basket.push(board[i][move-1]);
                        }
                    }else{
                        basket.push(board[i][move-1]);
                    }
                    
                    board[i][move-1]=0;
                    break;
                }
            }
        }
        
        
        return cnt;
    }
}