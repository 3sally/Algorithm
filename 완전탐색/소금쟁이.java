import java.util.Scanner;
/*
//문제
N*N의 정사각형 연못이 있다고 가정할 때, 소금쟁이가 연못의 물위를 뛰어 다닌다. 
소금쟁이가 처음에 뛸때는 3칸, 두번째 뚤때는 2칸, 세번째 뛸때는 1칸 뛰게 된다. 
여러 마리의 소금쟁이가 시작위치와 방향을 달리하여 뛰었으 ㄹ때 연못의 박으로 나가거나, 앞에서 뛰었던 소금쟁이가 세번째 뛰고 머무른 위치와 충돌하면 죽는다. 
연못 내에 살아있는 소금쟁이 수를 출력하세요.
//조건
소금쟁이의 처음 위치와 방향이 주어짐
소금쟁이가 순서대로 3번씩 뛴다. 3번 뛴 소금쟁이는 그 자리에 머문다.
뛰는 도중 연못 밖으로 나가거나 다른 소금쟁이가 머물러 있던 곳으로 뛰면 죽는다.
시작위치에 이미 다른 소금쟁이가 있다면 죽는다.
//입력
첫줄에는 테스트 케이스 T
두번째 줄에는 배열의 크기와 소금쟁이 수
그 다음줄부턴 시작위치(행 열), 방향(1.상/2.하/3.좌/4.우)이 소금쟁이 수만큼 주어짐
//testCase
3
9 5
6 2 4
1 5 2
0 0 4
6 6 1
2 4 3
11 6
0 0 4
6 0 1
2 4 3
4 2 4
1 5 2
10 8 1
7 5
5 2 1
1 6 2
0 6 3
1 0 2
2 4 4
//출력
#1 3
#2 4
#3 1
*/
public class 소금쟁이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		int jump[] = {3,2,1};
		int result[] = new int[testCase];
		
		for(int t = 0; t<testCase; t++) {
			int arrSize = sc.nextInt(); //배열의 크기 
			int bugCnt = sc.nextInt(); //소금쟁이 수 
			int bugLive = bugCnt;
			
			int [][]bugLoc = new int [arrSize][arrSize];
			
			for(int c = 0; c<arrSize; c++) {
				for(int r = 0; r<arrSize; r++) {
					bugLoc[c][r] = 0;
				}
			}
			
		 for(int bug = 0; bug<bugCnt; bug ++) {
				int bugCol = sc.nextInt(); //행 
				int bugRow = sc.nextInt(); //열 
				int moveTo = sc.nextInt(); //방향 
				
				
				if(bugLoc[bugCol][bugRow]==1) {
					bugLive--;
					break;
				}
				
				move : switch(moveTo) {
				case 1: //상 
					for(int j=0; j<jump.length; j++) {
						bugCol -= jump[j];
						if(bugCol<0 || bugLoc[bugCol][bugRow]==1) {
							bugLive--;
							break move;
						}
					}
					bugLoc[bugCol][bugRow] = 1;
					break;
				case 2: //하 
					for(int j=0; j<jump.length; j++) {
						bugCol += jump[j];
						if(bugCol>=arrSize || bugLoc[bugCol][bugRow]==1) {
							bugLive--;
							break move;
						}
					}
					bugLoc[bugCol][bugRow] = 1;
					break;
				case 3: //좌  
					for(int j=0; j<jump.length; j++) {
						bugRow -= jump[j];
						if(bugRow<0 || bugLoc[bugCol][bugRow]==1) {
							bugLive--;
							break move;
						}
					}
					bugLoc[bugCol][bugRow] = 1;
					break;
				case 4: //우  
					for(int j=0; j<jump.length; j++) {
						bugRow += jump[j];
						if(bugRow>=arrSize || bugLoc[bugCol][bugRow]==1) {
							bugLive--;
							break move;
						}
					}
					bugLoc[bugCol][bugRow] = 1;
					break;
				}
			}
			result[t] = bugLive;
		}
		for(int index=0; index<result.length; index++) {
			System.out.println("#"+(index+1)+" "+result[index]);
		}
	}
}
