import java.util.Scanner;

public class BOJ_1267_핸드폰요금 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int callCnt = scanner.nextInt(); // 통화의 개수
		int callTime;
		int YMoney = 0; // 영식 요금제
		int MMoney = 0; // 민식 요금제

		for (int i = 0; i < callCnt; i++) {
			callTime = scanner.nextInt();

			YMoney += ((callTime / 30) + 1) * 10;
            MMoney += ((callTime / 60) + 1) * 15;

		}

		if(YMoney>MMoney) {
			System.out.println("M "+MMoney);
		}else if(MMoney>YMoney) {
			System.out.println("Y "+YMoney);
		}else {
			System.out.println("Y M "+YMoney);
		}
	}
}
