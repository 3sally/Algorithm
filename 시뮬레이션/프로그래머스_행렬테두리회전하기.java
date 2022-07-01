class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
         // 정답 배열
        int answer[] = new int[queries.length];

        int map[][] = new int[rows+1][columns+1];
        // 지도에 숫자 채우기
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int minNum = Integer.MAX_VALUE; // 최소 숫자

            // 행렬 회전
            // 왼쪽
            int temp = map[x1][y1];
            minNum = Math.min(minNum, temp);
            for (int j = x1; j < x2; j++) {
                map[j][y1] = map[j+1][y1];
                minNum = Math.min(minNum, map[j][y1]);
            }

            // 아래쪽
            for (int j = y1; j < y2; j++) {
                map[x2][j] = map[x2][j+1];
                minNum = Math.min(minNum, map[x2][j]);
            }

            // 오른쪽
            for (int j = x2; j > x1; j--) {
                map[j][y2] = map[j-1][y2];
                minNum = Math.min(minNum, map[j][y2]);
            }

            // 위쪽
            for (int j = y2; j > y1+1; j--) {
                map[x1][j] = map[x1][j-1];
                minNum = Math.min(minNum, map[x1][j]);
            }
            map[x1][y1+1] = temp;

            answer[i] = minNum;
        }
        
        return answer;
    }
}