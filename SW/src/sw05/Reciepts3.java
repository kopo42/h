package sw05;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

//console font = consolas normal 11

public class Reciepts3 {
	public static void main(String[] args) throws ParseException {
		printer1();
	}
	public static void printer1() throws ParseException {
		//Á¦Ç°¸í, °¡°İ Á¤º¸°¡ 30°³ °¢°¢ ÀÌ»óÀÌ¹Ç·Î ÀÌ¸¶Æ® »óÇ° ÆäÀÌÁö¿¡¼­ °¡Á®¿È
		String[] ITEM = {"»Ç·Î·Î ºí·çº£¸® ¸À 235ml", "[ÆÈµµ] »Ç·Î·Î º¸¸®Â÷ 220ml", 
				"ÇÇÄÚÅ© Äİ·Òºñ¾Æ ¾ÈÆ¼¿ÀÅ°¾Æ ¼öÇÁ¸®¸ğ 1kg (È¦ºó)", "ÇÁ·¹½ºÄÚ¹ßµğ Ä«½ºÆ¿¸®¿À´Ï ³¢¾ÈÆ¼", 
				"ÇÇÁÔ ÁÖ¹æ¼¼Á¦ Ç»¾î 750ml ¾ÖÇÃ¹ã", "ÇÇÁÔ ÁÖ¹æ¼¼Á¦ Ç»¾î 750ml ¹öÁø¸ğÈ÷Åä", 
				"°ÇÁ¶±â¿ë ÇÇÁÔ ¶óÇÇ¿¡½ºÅ¸ 40¸Å", "°ÇÁ¶±â¿ë ÇÇÁÔ ¹Ì½ºÆ½·¹ÀÎ 40¸Å", "¾×Ã÷ ÆÛÆåÆ® º£ÀÌÅ·¼Ò´Ù 3L+200ml", 
				"¾×Ã÷ ÆÛÆåÆ® µöÅ¬¸° 3L+200ml", "[Á¾°¡Áı] ¹¬ÀºÁö±èÄ¡1.6kg", "ÇÁ·¹½ºÄÚ¹ßµğ Ä«½ºÆ¿¸®¿À´Ï Åä½ºÄ«³ª", 
				"ÇÇÄÚÅ© Æ®·ç¿öÅÍ 330ml", "¸¼Àº´©¸®¼û È²»ç¹æ¿ª ¸¶½ºÅ© KF94 (´ëÇü) 1¸Å FDAµî·Ï (ÇÑ±¹»ı»ê/ÇÑ±¹ºÎÀÚÀç»ç¿ë/°³º°Æ÷Àå)", 
				"¿À¸®¿Â ÅõÀ¯ ¿ìÀ¯ÃÊÄİ¸´ 60g", "¶óÀÌÇÁ¸® ¾È½É¸ÅÆ® 10p", "[·Ôµ¥] Çã½¬[HERSHEY`S] ¹Ì´Ï¾îÃ³ 155g", 
				"(G)ÇÇÄÚÅ© À¯±â³ó ¹ã±×´ë·Î 100g*2ÀÔ", "[ÇÇÄÚÅ©] Æ®·ç ½ºÆÄÅ¬¸µ ·¹¸ó(500ml¡¿6ÀÔ)", 
				"[ÇÇÄÚÅ©] Æ®·ç½ºÆÄÅ¬¸µ ÀÚ¸ù(500ml¡¿6ÀÔ)", "ÇÇÄÚÅ© ÇÖ¹Ùº£Å¥Ä¡Å²300g", 
				"[20³â»ê] ÇØ³²½ÒÀÌ¾ß±â10kg(»óµî±Ş)", "[ÇÇÄÚÅ©] ¸¶¸ô·Î ³ìÂ÷Æ®·¯ÇÃ 200g", 
				"[ÇÇÄÚÅ©] °úÀÏ ±×·¡³î¶ó 380g", "[ÇÇÄÚÅ©] ¹öÅÍÇÃ¶óÀÌ »õ¿ìÆ¢±è 400g", 
				"[ÇÇÄÚÅ©] ÀÎÀı¹Ì ±×·¡³î¶ó 380g", "ÇÇÄÚÅ© Ä«¶ó¸áÃÊÄÚº¼ 260g", "ÇÇÄÚÅ© ¸®¾óÈ­ÀÌÆ® µş±âÃÊÄÚº¼ 170g", 
				"[ÇÇÄÚÅ©] ÇÖ¾Ø½ºÆÄÀÌ½Ã »õ¿ìÆ¢±è 400g", "[¸®½ºÅ×¸°] ±¸°­Ã»°áÁ¦ ÈÄ·¹½¬¹ö½ºÆ® 750ml [ÀÇ¾à¿ÜÇ°]"};
		
		int[] PRICE = {1200, 1200, 14980, 22000, 6500, 6500, 6500, 6500, 9900, 9900, 
				12900, 37000, 1680, 3500, 8260, 2415, 3080, 3486, 3570, 3570, 
				3836, 29800, 4186, 4186, 4186, 4186, 4886, 1000, 5586, 5880};
		
		//¼ö·® num[]¿¡ 1ºÎÅÍ 3±îÁöÀÇ Á¤¼ö ³­¼ö¸¦ ÁöÁ¤ÇÑ´Ù
		int[] num = new int[ITEM.length];
		for(int i = 0; i < ITEM.length; i++) {
			int rand = (int) (Math.random() * 3 + 1);
			num[i] = rand;
		}
		//¸é¼¼Ç°¸ñ ÁöÁ¤À» À§ÇÑ Âü, °ÅÁş ¹è¿­
		boolean[] TAXFREE = {true, true, true, true, true, true, 
				true, true, true, true, true, true, 
				true, true, true, true, true, false, 
				true, true, true, false, true, true, 
				true, true, true, true, true, true};
		
		Calendar k42_cal = Calendar.getInstance(); //³¯Â¥ Ãâ·ÂÀ» À§ÇÑ calendar °´Ã¼
		SimpleDateFormat k42_sdf = new SimpleDateFormat("yyyy-MM-d HH:mm:ss"); //date format »ı¼º
		String k42_TIME = k42_sdf.format(k42_cal.getTime()); //½Ã°£ Á¤º¸ È¹µæ
		
		String HEADER = "emart";
		System.out.printf("  %s", HEADER);
		System.out.printf("%25s\n", "ÀÌ¸¶Æ® Á×ÀüÁ¡ (031)888-1234"); //¿À¸¥ÂÊÀ¸·Î Á¤·ÄÇÏ¿© Ãâ·ÂÇÑ´Ù (printf)
		System.out.printf("%35s\n", "206-85-50913 °­Èñ¼®");//¿À¸¥ÂÊÀ¸·Î Á¤·ÄÇÏ¿© Ãâ·ÂÇÑ´Ù (printf)
		System.out.printf("%29s\n", "¿ëÀÎ ¼öÁö±¸ Æ÷Àº´ë·Î 552");//¿À¸¥ÂÊÀ¸·Î Á¤·ÄÇÏ¿© Ãâ·ÂÇÑ´Ù (printf)
		
		System.out.println("¿µ¼öÁõ ¹ÌÁöÂü½Ã ±³È¯/È¯ºÒ ºÒ°¡"
				+ "\nÁ¤»ó»óÇ°¿¡ ÇÑÇÔ, 30ÀÏ ÀÌ³»(½Å¼± 7ÀÏ)"
				+ "\n¡ØÀÏºÎ ºê·£µå¸ÅÀå Á¦¿Ü(¸ÅÀå °íÁö¹° ÂüÁ¶)"
				+ "\n±³È¯/È¯ºÒ ±¸¸ÅÁ¡¿¡¼­ °¡´É(°áÁ¦Ä«µå ÁöÂü)\n");
		
		System.out.printf("[±¸ ¸Å]%s%14s\n", k42_TIME, "POS:0011-9861"); //Ã³¸® ½Ã°£À» stringÀ¸·Î ÀúÀåÇÏ¿© Ãâ·ÂÇÑ´Ù
		System.out.println("------------------------------------------"); //±¸ºĞ¼±
		System.out.printf("%12s %12s %5s %5s\n", "»óÇ°¸í", "´Ü °¡", "¼ö·®", "±İ ¾×");
		System.out.println("------------------------------------------"); //±¸ºĞ¼±
		
		int[] sum = new int[ITEM.length]; //ÇÕ°è ÀúÀåÀ» À§ÇÑ Á¤¼ö ¹è¿­
		int totalamount = 0; //ÃÑ ±¸¸Å¼ö·®
		int totalTaxFree = 0; //ÃÑ ¸é¼¼ Ç°¸ñ
		int totalTaxincluded = 0; //ÃÑ °ú¼¼ Ç°¸ñ
		
		for(int i = 0; i < ITEM.length; i++) { //¿µ¼öÁõ Ãâ·ÂÀ» À§ÇÑ ¹İº¹¹®
			sum[i] = PRICE[i] * num[i];
			if(TAXFREE[i] == false) { //Áï ¸é¼¼Ç°¸ñÀÌ¶ó¸é
				System.out.printf(" * %-10.6s %10s\t%4d%10s\n", //¸¶Âù°¡Áö·Î printf·Î Á¤·ÄÇÑ´Ù
						strCut(ITEM[i], null, 11, 0, true, true), NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxFree += PRICE[i]*num[i]; //¸é¼¼Ç°¸ñ ÇÕ°è = °¡°İ ¹è¿­*¼ö·® ¹è¿­
			} else {
				System.out.printf("   %-10.6s %10s\t%4d%10s\n", //¸¶Âù°¡Áö·Î printf·Î Á¤·ÄÇÑ´Ù
						strCut(ITEM[i], null, 11, 0, true, true), NumberFormat.getInstance().format(PRICE[i]),
						num[i], NumberFormat.getInstance().format(sum[i]));
				totalTaxincluded += PRICE[i]*num[i]; //°ú¼¼Ç°¸ñ ÇÕ°è
			}
			if((i+1) % 5 == 0) {
				System.out.println("------------------------------------------");
				//5°³¸¶´Ù ±¸ºĞ¼± Ãâ·Â
			}
			totalamount ++;
			//ÃÑ ¼ö·® ÀúÀå
		}

		
		double k42_TAX = 0.1; //¼¼À² 10%
		int netprice = (int) (totalTaxincluded / (1 + k42_TAX)); //¿ø°¡
		int totalTAX = totalTaxincluded - netprice; //ºÎ°¡¼¼ = °ú¼¼ °¡°İ - ¿ø°¡
		int totalPRICE = totalTaxFree + totalTaxincluded + totalTAX; //ÃÑ ±¸¸Å±İ¾× = ¸é¼¼Ç°¸ñ + °ú¼¼Ç°¸ñ + ºÎ°¡¼¼
		
		System.out.println(); //ÇÑÁÙ ¶ç¿ò
		System.out.printf("%12s%4s%4s%17d\n", "ÃÑ", "Ç°¸ñ", "¼ö·®", totalamount);
		System.out.printf("%13s%4s%4s%17s\n", "(*)","¸é¼¼","¹°Ç°", 
				NumberFormat.getInstance().format(totalTaxFree)); //Ãµ´ÜÀ§ ½°Ç¥ Çü½Ä
		System.out.printf("%17s%4s%17s\n", "°ú¼¼", "¹°Ç°", //°°Àº °£°İÀ¸·Î printf ÁöÁ¤ÇÔ
				NumberFormat.getInstance().format(totalTaxincluded));
		System.out.printf("%16s%3s%3s%17s\n", "ºÎ", "°¡", "¼¼", 
				NumberFormat.getInstance().format(totalTAX));
		System.out.printf("%16s%7s%17s\n", "ÇÕ", "°è", 
				NumberFormat.getInstance().format(totalPRICE));
		System.out.printf("%-15s%21s\n", " °á Á¦ ´ë »ó ±İ ¾×", //-15 = ¿ŞÂÊ Á¤·Ä
				NumberFormat.getInstance().format(totalPRICE)); //°áÁ¦ ´ë»ó ±İ¾× = ÇÕ°è ±İ¾×
		System.out.println("------------------------------------------");
		System.out.printf("%-15s%29s\n", "0012 KEB ÇÏ³ª", "541707**0484/35860658");//ÀÓÀÇ·Î ÁöÁ¤ÇÑ Ä«µå¹øÈ£
		System.out.printf("Ä«µå°áÁ¦(IC)%22s  %s\n", "ÀÏ½ÃºÒ /", NumberFormat.getInstance().format(totalPRICE)); //°áÁ¦ ±İ¾× Ãâ·Â
		System.out.println("------------------------------------------");
		System.out.printf("%30s\n","[½Å¼¼°è Æ÷ÀÎÆ® Àû¸³]");
		System.out.println("***°í°´´ÔÀÇ Æ÷ÀÎÆ® ÇöÈ²ÀÔ´Ï´Ù.");
		int point = 164; //±İÈ¸ ¹ß»ı Æ÷ÀÎÆ®
		int pointTOTAL = 5637; //´©°è Æ÷ÀÎÆ®
		int pointA = pointTOTAL - point; //°¡¿ë Æ÷ÀÎÆ® = ´©°è - ±İÈ¸ ¹ß»ı
		
		System.out.printf("%-10.10s %19s  %7d\n", 
				"±İÈ¸¹ß»ıÆ÷ÀÎÆ®", "9350**9995", point);
		System.out.printf("%-10.10s %15s(   %8s)\n", 
				"´©°è(°¡¿ë)Æ÷ÀÎÆ®", NumberFormat.getInstance().format(pointTOTAL),  //Ãµ´ÜÀ§ ½°Ç¥ Çü½Ä
				NumberFormat.getInstance().format(pointA));
		System.out.println("*½Å¼¼°èÆ÷ÀÎÆ® À¯È¿±â°£Àº 2³âÀÔ´Ï´Ù.");
		System.out.println("------------------------------------------");
		System.out.printf("%24s\n", "±¸¸Å±İ¾×±âÁØ ¹«·áÁÖÂ÷½Ã°£ ÀÚµ¿ºÎ¿©");
		System.out.printf("%-10s %30s\n", "Â÷·®¹øÈ£ :", "38º¸****"); //ÀÓÀÇ ÁöÁ¤ Â÷·®¹øÈ£
		System.out.printf("%s %34s\n", "ÀÔÂ÷½Ã°£ : ", k42_TIME); //ÀÔÂ÷½Ã°£ = Ã³¸®½Ã°£ or ÀÓÀÇ ÁöÁ¤
		System.out.println("------------------------------------------");
		System.out.printf("%s %29s", "Ä³¼Å:084599 ¾ç00", "1150");

		
	}/*
	"°¡³ª´Ù¶ó" ¿¡¼­ 2¹ÙÀÌÆ®±îÁö ÀÚ¸£°í ½ÍÀ»°æ¿ì strCut("°¡³ª´Ù¶ó", 2, 0, true); Ã³·³ ÇÏ½Ã¸é µË´Ï´Ù.
 => °á°ú : "°¡"                            (String szText, int nLength, int nPrev, boolean isAdddot)

"°¡³ª´Ù¶ó" ¿¡¼­ "´Ù"¶ó´Â Å°¿öµå ±âÁØ¿¡¼­ 2¹ÙÀÌÆ®±îÁö ÀÚ¸£°í½ÍÀ»°æ¿ì strCut("°¡³ª´Ù¶ó", "´Ù", 2, 0, true, true); Ã³·³ ÇÏ½Ã¸é µË´Ï´Ù.

ÃâÃ³: https://cublip.tistory.com/102 [HeBhy, since 1983.]
*/
	
	
	public static String strCut(String szText, String szKey, int nLength, int nPrev, boolean isNotag, boolean isAdddot){
		// ¹®ÀÚ¿­ ÀÚ¸£±â         
		String r_val = szText;     
		int oF = 0, oL = 0, rF = 0, rL = 0;     
		int nLengthPrev = 0;     
		//Pattern p = Pattern.compile("<(/?)([^<>]*)?>", Pattern.CASE_INSENSITIVE); 
		// ÅÂ±×Á¦°Å ÆĞÅÏ         
		//if(isNotag) {r_val = p.matcher(r_val).replaceAll("");}  // ÅÂ±× Á¦°Å     
		//r_val = r_val.replaceAll("&amp;", "&");     
		//r_val = r_val.replaceAll("(!/|\r|\n|&nbsp;)", "");  // °ø¹éÁ¦°Å       
		try {       byte[] bytes = r_val.getBytes("UTF-8");     // ¹ÙÀÌÆ®·Î º¸°ü       
		if(szKey != null && !szKey.equals("")) {
			nLengthPrev = (r_val.indexOf(szKey) == -1)? 0: r_val.indexOf(szKey);  // ÀÏ´Ü À§Ä¡Ã£°í         
			nLengthPrev = r_val.substring(0, nLengthPrev).getBytes("MS949").length;  // À§Ä¡±îÁö±æÀÌ¸¦ byte·Î ´Ù½Ã ±¸ÇÑ´Ù
			nLengthPrev = (nLengthPrev-nPrev >= 0)? nLengthPrev-nPrev:0;    // Á» ¾ÕºÎºĞºÎÅÍ °¡Á®¿Àµµ·ÏÇÑ´Ù.       
			}           // xºÎÅÍ y±æÀÌ¸¸Å­ Àß¶ó³½´Ù. ÇÑ±Û¾È±úÁö°Ô.       
		int j = 0;       
		if(nLengthPrev > 0) while(j < bytes.length) {
			if((bytes[j] & 0x80) != 0) {
				oF+=2; rF+=3; 
				if(oF+2 > nLengthPrev) {break;} 
				j+=3;         
				} else {if(oF+1 > nLengthPrev) {break;} ++oF; ++rF; ++j;}       
			}             
		j = rF;
		while(j < bytes.length) {
			if((bytes[j] & 0x80) != 0) {
				if(oL+2 > nLength) {break;} oL+=2; rL+=3; j+=3;
				} else {if(oL+1 > nLength) {break;} ++oL; ++rL; ++j;}       
			}       r_val = new String(bytes, rF, rL, "UTF-8");  // charset ¿É¼Ç    
			List<String> list = new ArrayList<String>();
			List<String> space = new ArrayList<String>();
			String kor = "^[¤¡-¤¾¤¿-¤Ó°¡-ÆR]*$"; //ÇÑ±Û¸¸ ÀÎ½Ä
			//[ÇÇÄÚÅ©] ÀÎÀı
			int Ecnt = 0;
			for(int k = 0; k < szText.length(); k++) { //10±ÛÀÚ ³»¿¡¼­
				boolean korONLY = String.valueOf(szText.charAt(k)).matches(kor);
				if (korONLY = false) { //Æ¯¼ö¹®ÀÚ³ª °ø¹éÀÌ¶ó¸é
					r_val += "/";
					//Ecnt++; //substring ³» Æ¯¼ö¹®ÀÚÀÇ °³¼ö (int)
				}
			}
		} catch(UnsupportedEncodingException e){ e.printStackTrace(); } 
		return r_val;   
		}
}
