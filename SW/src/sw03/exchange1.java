package sw03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class exchange1 {
	static int kp42_won = 1000000; //환전할 금액
	static double kp42_ex = 1238.21; //환율
	static double kp42_commision = 0.003; //수수료 0.3%
	static int kp42_usd = (int)(kp42_won / kp42_ex); //won to usd 미화
	static int kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex); //잔돈
	static double kp42_ComPerOne = kp42_ex * kp42_commision; //건당 수수료 구하기 
	static double kp42_totalcom = kp42_usd * kp42_ComPerOne; //총 수수료 구하기
	//comperone 1달러당 수수료 = 환율 * 수수료
	//totalcom 총 수수료 = 총 달러 값 * 1달러당 수수료
	//한번에 계산하는 경우와의 차이

	public static void main(String[] args) { //다른 함수를 실행할 main 함수
		// TODO Auto-generated method stub
		//kp42_justEX();
		//kp42_EX1();
		//kp42_EX2();
		//kp42_EX3();
		kp42_DF1();
	}
	public static void kp42_justEX() { //단순 환전
		//전역변수를 이용하여 결과를 출력하는 함수
		System.out.println("***************************************************");
		System.out.println("*                 수수료 없이 계산                    *");
		//단순 세금 계산으로 환전할 원화, 환전된 미화, 원화 잔돈을 출력한다
		System.out.printf("총 한화 환전 금액: %d원 ==> 미화: %d달러, 잔돈 ==> %d원\n", 
				kp42_won, kp42_usd, kp42_remain); //출력: 원, 미화, 잔돈 순
		//remain = 처음 원화에서 환전된 미화 * 환율( = 원화 형태)을 제한 값
		System.out.println("***************************************************");
	}
	public static void kp42_EX1 () { //수수료 계산하기
		System.out.println("***************************************************");
		System.out.println("*                   수수료 계산                     *");
		System.out.printf("총 수수료: %f원 ==> 미화: %d달러, 달러당 수수료 ==> %f원\n", 
				kp42_totalcom, kp42_usd, kp42_ComPerOne); //출력: 수수료, 미화, 달러당 수수료 순
		System.out.println("***************************************************");
	}
	public static void kp42_EX2() { //수수료 적용 환전
		int kp42_totalcomInt; //총 수수료의 정수형
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //소수점이 존재할 경우
			kp42_totalcomInt = (int)kp42_totalcom + 1; //올림 수행한다
		} else {
			kp42_totalcomInt = (int)kp42_totalcom; //없을 경우 수행하지 않음
		}
		System.out.println("***************************************************");
		System.out.println("*                 수수료 적용 환전                  *");
		System.out.printf("총 수수료: %d원 ==> 미화: %d달러, 달러당 수수료 ==> %f원\n", 
				kp42_totalcomInt, kp42_usd, kp42_ComPerOne); //출력: 수수료, 미화, 달러당 수수료 순
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //잔돈 다시 정의
		
		System.out.printf("총 한화 환전 금액: %d원 ==> 미화: %d달러, 수수료 징구: %d원, 잔돈 ==> %d원\n", 
				kp42_won, kp42_usd, kp42_totalcomInt, kp42_remain); //출력: 원, 미화, 잔돈 순
		
		System.out.println("***************************************************");
	}
	public static void kp42_EX3() { //정확한 수수료 적용 환전
		kp42_usd = (int)(kp42_won / (kp42_ex + kp42_ComPerOne)); //달러를 정수형으로 표현
		kp42_totalcom = kp42_usd * kp42_ComPerOne; //총 수수료 = 달러 정수 부분 * 달러당 수수료
		int kp42_totalcomInt; //올림 수행할 변수
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //소수점이 존재한다면
			kp42_totalcomInt = (int)kp42_totalcom + 1; //올림처리
		} else {
			kp42_totalcomInt = (int)kp42_totalcom; //아닐 경우 수행하지 않음
		}
		System.out.println("***************************************************");
		System.out.println("*            (정확한) 수수료 적용 환전               *");
		System.out.printf("총 수수료: %d원 ==> 미화: %d달러, 달러당 수수료 ==> %f원\n", 
				kp42_totalcomInt, kp42_usd, kp42_ComPerOne); //출력: 수수료, 미화, 달러당 수수료 순
		
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //잔돈 다시 정의
		
		System.out.printf("총 한화 환전 금액: %d원 ==> 미화: %d달러, 수수료 징구: %d원, 잔돈 ==> %d원\n", 
				kp42_won, kp42_usd, kp42_totalcomInt, kp42_remain); //출력: 원, 미화, 잔돈 순
		
		System.out.println("***************************************************");
	}
	public static void kp42_DF1() { //Decimal Format, Calendar 활용하여 처리 시간을 출력하는 함수
		DecimalFormat df = new DecimalFormat( "###,###,###,###,###"); //1000단위 콤마 형식
		kp42_usd = (int)(kp42_won / (kp42_ex + kp42_ComPerOne)); //달러를 정수형으로 표현
		//달러 = 원화를 (환율 + 달러당 수수료)로 나누어 구한다
		kp42_totalcom = kp42_usd * kp42_ComPerOne; //총 수수료 = 달러 정수 부분 * 달러당 수수료
		int kp42_totalcomInt; //올림 수행할 변수
		
		if (kp42_totalcom != (double)((int)kp42_totalcom)) { //소수점이 존재한다면
			kp42_totalcomInt = (int)kp42_totalcom + 1; //올림처리
		} else {
			kp42_totalcomInt = (int)kp42_totalcom;//아닐 경우 수행하지 않음
		}
		
		System.out.printf("************************************************\n");
		System.out.printf("*              콤마 찍기, 날짜 적용              *\n");
		
		System.out.printf("총 수수료: %s원 ==> 미화: %s달러, 달러당 수수료 ==> %f원\n",
				df.format(kp42_totalcomInt), df.format(kp42_usd), kp42_ComPerOne); //df.format으로 형식 적용하여 출력
		
		kp42_remain = (int)(kp42_won - kp42_usd * kp42_ex - kp42_totalcomInt); //잔돈 다시 정의
		
		System.out.printf("총 한화 환전 금액: %s원 ==> 미화: %s달러, 수수료 징구: %s원, 잔돈 ==> %s원\n", 
				df.format(kp42_won), df.format(kp42_usd), df.format(kp42_totalcomInt), //df.format으로 형식 적용하여 출력
				df.format(kp42_remain)); //출력: 원, 미화, 잔돈 순
		Calendar calt = Calendar.getInstance(); //calendar class 사용하기
		
		SimpleDateFormat sdt = new SimpleDateFormat ("YYYY/MM/dd HH:mm:ss"); //형식 불러오기
		System.out.printf("최종 실행 시간: %s\n", sdt.format(calt.getTime())); //현재시간 출력하기
		
		System.out.println("***************************************************");
	}
}















