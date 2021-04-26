package sw07;

import java.io.UnsupportedEncodingException;

public class Hanblank {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("ÇÑ±Ûabcd", 15));
		System.out.printf("HanBlankForward  [%s]\n", printBlankForward("ÇÑ±ÛÇÑ±Ûaa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("ÇÑ±Ûaa", 15));
		System.out.printf("HanBlankBackward [%s]\n", printBlankBackward("ÇÑ±ÛÇÑ±Ûaa", 15));
		System.out.printf("ÇÑ±Û: %d°³\n", HanCount("ÇÑ±ÛÇÑ±Ûaa"));

	}
	public static String printBlankForward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//¹®ÀÚ Å¸ÀÔ¿¡ µû¸¥ °ø¹é ¼ö¸¦ ÀúÀåÇÏ±â À§ÇÑ ÇÔ¼ö
		//k42_str = ¹ŞÀº ¹®ÀÚ¿­, k42_i = °ø¹éÀ» Æ÷ÇÔÇÏ¿© Ãâ·ÂÇÒ ¹®ÀÚ¼ö
		int k42_strBytes = k42_str.getBytes("MS949").length; //¹ŞÀº ¹®ÀÚ¿­ÀÇ byte¼ö¸¦ ÀúÀåÇÒ º¯¼ö
		//MS949 ÀÎÄÚµù ½Ã ÇÑ±Û ÇÑ ¹®ÀÚ ´ç 2Byte
		int k42_blank = 0; //°ø¹é ¼ö ÃßÈÄ ÁöÁ¤
			k42_blank = k42_strBytes; //¹ŞÀº int i ¿¡¼­ blankÀÇ °ªÀ» »« ¸¸Å­ °ø¹é Ãâ·Â
		
		String k42_result = "";
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //¹®ÀÚ¿­ ¾Õ¿¡ °ø¹é ÀúÀå
		}
		k42_result += k42_str; //returnµÉ °ª result¿¡ ¹ŞÀº ¹®ÀÚ¿­ ÀúÀå
		return k42_result; //Ã³¸® ÈÄ »ç¿ëµÉ ¹®ÀÚ¿­
	}
	public static String printBlankBackward(String k42_str, int k42_i) throws UnsupportedEncodingException {
		//¹®ÀÚ Å¸ÀÔ¿¡ µû¸¥ °ø¹é ¼ö¸¦ ÀúÀåÇÏ±â À§ÇÑ ÇÔ¼ö
		//k42_str = ¹ŞÀº ¹®ÀÚ¿­, k42_i = °ø¹éÀ» Æ÷ÇÔÇÏ¿© Ãâ·ÂÇÒ ¹®ÀÚ¼ö
		int k42_strBytes = k42_str.getBytes("MS949").length; //¹ŞÀº ¹®ÀÚ¿­ÀÇ byte¼ö¸¦ ÀúÀåÇÒ º¯¼ö
		//MS949 ÀÎÄÚµù ½Ã ÇÑ±Û ÇÑ ¹®ÀÚ ´ç 2Byte
		int k42_blank = 0; //°ø¹é ¼ö ÃßÈÄ ÁöÁ¤
			k42_blank = k42_strBytes; //¹ŞÀº int i ¿¡¼­ blankÀÇ °ªÀ» »« ¸¸Å­ °ø¹é Ãâ·Â
		
		String k42_result = "";
		k42_result = k42_str; //returnµÉ °ª result¿¡ ¹ŞÀº ¹®ÀÚ¿­ ¸ÕÀú ÀúÀå
		
		for(int k42_j = 0; k42_j < k42_i - k42_blank; k42_j++) {
			k42_result += " "; //¹®ÀÚ¿­ µÚ¿¡ °ø¹é ÀúÀå
		}
		return k42_result; //Ã³¸® ÈÄ »ç¿ëµÉ ¹®ÀÚ¿­
	}
	public static int HanCount(String k42_str) {
		int k42_cnt = 0; //ÇÑ±ÛÀÇ °³¼ö¸¦ ÀúÀåÇÒ º¯¼ö
		for(int k42_i = 0; k42_i < k42_str.length(); k42_i ++) //¹ŞÀº ¹®ÀÚ¿­ÀÇ ±æÀÌ ¾È¿¡¼­
			if(String.valueOf(k42_str.charAt(k42_i)).matches((".*[¤¡-¤¾¤¿-¤Ó°¡-ÆR]+.*"))) {
				k42_cnt++; //¹®ÀÚ ÇÏ³ª¾¿ °Ë»çÇÏ¿© ÇÑ±Û Á¤±Ô½Ä°ú ÀÏÄ¡ÇÒ °æ¿ì Ä«¿îÆ®ÇÑ´Ù
			}
		return k42_cnt; //ÃÑ °³¼ö ¹İÈ¯
	}
}
