/*
//문제
신도시에 빌딩들을 세우려고 한다. 신도시를 세울 부지는 변의 길이가 N인 정사각형의 형태이며 이 부지는 가로, 세로 길이가 1인 구획으로 나누어져 있다. 
구획 당 하나의 빌딩을 세울 수 있고, 빌딩을 세울 수 있는 구획은 B로 표시, 공원 조성단지는 G로 표시되어 있다. 
빌딩을 세울 때 인접한 구획에 공원 조성 단지 G가 있다면 2층 높이로 세울 수 있고, 인접한 구획에 공원 조성 단지 G가 없다면 현 위치의 가로 위치에 있는 빌딩구획 B와 세로 위치의 빌딩 구획 B의 수를 더한 크기만큼 빌딩을 세울 수 있다.
가장 높이 세울 수 있는 빌딩은 몇층인가?
//조건
빌딩의 높이를 결정 짓는 인접 구획은 상하좌우뿐만 아니라 대각선 위치도 포함된다
빌딩의 높이는 인접 구획에 공원조성단지 G가 없을 경우 그 위치의 가로와 세로 위치의 빌딩 B 구획의 수의 합으로 결정한다. 현 위치의 B 구획도 포함한다.
//입력
테스트 케이스
배열 크기
배열의 값들
//예시
3
6
G B G G B B
G B G G B G
B B B B G B
B G B B B B 
G B B B B G
G B B B B G
5
G B G G B
G B G G B
B B B B G
B G B B B
G B B B B
3
G G B
G B B
B B B
//출력
#1 7
#2 7
#3 5
*/


import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		//testCase만큼 배열입력  
		for(int i=0; i<testCase; i++) {
			int arraySize = sc.nextInt(); //배열 사이즈입력 
			String [][] land = new String [arraySize][arraySize]; //입력받은 사이즈 크기만큼의 배열 생
			
			for(int n=0; n<arraySize; n++) { //행  
				for(int m=0; m<arraySize; m++) { //열  
					land[n][m] = sc.next(); //배열에 값 넣
				}
			}
			
			int[][] deltas = { {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}}; //주변 8곳의 좌표를 구하기 위한 배
			
			int maxBuilding = 0;
			
			for(int c=0; c<arraySize; c++) { //행  
				for(int r=0; r<arraySize; r++) { //열  
					boolean isG = false;
					if(land[c][r].equals("B")) {
						int building = 0;
						
						search: for(int d=0; d<deltas.length; d++) {
							int nc = c + deltas[d][0];
							int nr = r + deltas[d][1];
							
							if(nc>=0 && nc<arraySize && nr>=0 && nr<arraySize) {
								if(land[nc][nr].equals("G")) {
									isG = true;
									break search;
								}
							}
						}
				
						if(isG==false) {
							for(int n = 0; n<arraySize; n++) {
								if(land[c][n].equals("B")) building++;
								if(land[n][r].equals("B")) building++;
							}
							building = building - 1; 
							if(maxBuilding<building) maxBuilding = building;
						}else {
							building = 2;
							if(maxBuilding<building) maxBuilding = building;	
						}
					}
				}
			}
			result.add(maxBuilding);
		}
		for(int r = 0; r<result.size(); r++) {
			System.out.println("#"+ (r+1) +"  " + result.get(r));
		}
	}
}
