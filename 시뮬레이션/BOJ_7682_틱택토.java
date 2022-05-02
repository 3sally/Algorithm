import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_7682_틱택토 {

    static char[][] map;
    static int xCnt, oCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String tc = br.readLine();
            if (tc.equals("end")) {
                break;
            }

            boolean flag = false;

            int idx = 0;
            map = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    map[i][j] = tc.toCharArray()[idx++];
                }
            }

            int emptyCnt = 0;
            xCnt = 0;
            oCnt = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = map[i][j];
                    if (c == '.') {
                        emptyCnt++;
                    } else if (c == 'X') {
                        xCnt++;
                    } else if (c == 'O') {
                        oCnt++;
                    }
                }
            }

            if (emptyCnt == 0) {
                if (xCnt == 5 && oCnt == 4) {
                    // o가 이기거나 둘 다 이기면 안됌
                    if(!checkTikTakToe('O') && checkTikTakToe('X')){
                        flag = true;
                    } else if (!checkTikTakToe('O') && !checkTikTakToe('X')) {
                        flag = true;
                    }
                }
            } else {
                if(xCnt==oCnt+1){
                    if(checkTikTakToe('X') && !checkTikTakToe('O')) {
                        flag = true;
                    }
                } else if (xCnt==oCnt) {
                    if(checkTikTakToe('O') && !checkTikTakToe('X')) {
                        flag = true;
                    }
                }
            }
            if(flag)
                sb.append("valid").append("\n");
            else
                sb.append("invalid").append("\n");
        }
            System.out.println(sb);
    }
    private static boolean checkTikTakToe(char c){
        // 가로 확인
        for(int i=0; i<3; i++) {
            if(map[i][0] == c && map[i][1] == c && map[i][2] == c) {
                return true;
            }
        }

        // 세로 확인
        for(int i=0; i<3; i++) {
            if(map[0][i] == c && map[1][i] == c && map[2][i] == c) {
                return true;
            }
        }

        // 대각선 확인
        if(map[0][0] == c && map[1][1] == c && map[2][2] == c) {
            return true;
        }

        if(map[2][0] == c && map[1][1] == c && map[0][2] == c) {
            return true;
        }

        return false;
    }
}
