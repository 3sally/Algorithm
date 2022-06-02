public class 프로그래머스_카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;

        System.out.println(solution(brown, yellow));
    }

    private static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int h = 0;
        int w = 0;

        int total = brown+yellow;

        for(int i = 1; i<total; i++){
            if(total%i==0){
                h = i;
                w = total/h;
            }

            if((h+w-2)==brown/2){
                if(h>w){
                    answer[0] = h;
                    answer[1] = w;
                }else{
                    answer[0] = w;
                    answer[1] = h;
                }
                break;
            }
        }

        return answer;
    }
}
