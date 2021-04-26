package sw03;

public class main2B {
	public static int k42_netprice(int k42_price, double k42_rate) { //소비자가 계산하기
		return (int)(k42_price / (1 + k42_rate)); // x(y + 1) = xy + x
	} //세금 계산 함수
	
	public static void main(String[] args) { //메인 함수
		int k42price =1234; //정수형 변수 지정
		double k42tax_rate = 0.1; //실수형 변수 지정
		
		int k42netprice = k42_netprice(k42price, k42tax_rate); //미리 지정한 함수 사용
		int k42tax = k42price - k42netprice; //함수 계산
		
		System.out.printf("***************************************************\n");//헤더
		System.out.printf("*            소비자가, 세전가격, 세금 계산            *\n");//헤더2
		System.out.printf("       소비자가: %d, 세전가격: %d, 세금 계산: %d       \n",
				k42price, k42netprice, k42tax); //형식 지정 출력
		System.out.printf("***************************************************\n");
	}
}