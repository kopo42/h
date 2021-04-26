package sw03;

public class Taxcalc {
	
	public static int k42_taxcal (int k42_val, int k42_rate) { //int값을 반환하는 함수
		int k42_ret;
		
		if(((double)k42_val * (double)k42_rate / 100.0) == k42_val * k42_rate / 100) { //double형이 int형과 같다면
			k42_ret = k42_val * k42_rate / 100; //올림을 수행하지 않고
		} else {
			k42_ret = k42_val * k42_rate / 100 + 1; //같지 않다면 올림 수행한다
		}
		return k42_ret; //결과값을 반환
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k42_val = 271; //세전
		int k42_rate = 3; //세율 세율 세율
		
		//국내 소비자가 = 세금 포함
		int k42_tax = k42_taxcal(k42_val, k42_rate);
		
		System.out.println("***************************************************");
		System.out.println("*                 단순 세금 계산                    *");
		System.out.printf("실제 세금 계산: %f\n", k42_val * k42_rate / 100.0);
		//실제 세금 = 세전가에 세율(3%)을 곱한 결과를 100.0으로 나눈 결과
		System.out.printf("세전 가격: %d, 세금: %d, 세포함가격: %d\n", 
				k42_val, k42_tax, k42_val + k42_tax); //순서대로 대입
		
		System.out.println("***************************************************");
	}
}