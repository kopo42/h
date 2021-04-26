package sw03;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class KP42_printCal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calt = Calendar.getInstance();
		
		SimpleDateFormat sdt = new SimpleDateFormat ("YYYY/MM/dd HH:mm:ss");
		System.out.printf("최종 실행 시간: %s\n", sdt.format(calt.getTime()));
	}
	
}
