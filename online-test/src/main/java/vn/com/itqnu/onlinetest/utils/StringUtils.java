package vn.com.itqnu.onlinetest.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {

	public static String generateUsernameFromFullName(String fullName) {
		String username = "";
		
		String temp = Normalizer.normalize(fullName, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		fullName = pattern.matcher(temp).replaceAll("").replaceAll("Đ", "D").replace("đ", "");
		
		String tempp[] = fullName.split(" ");
		
		username = tempp[tempp.length-1];
		
		for (int i = 0; i < tempp.length - 1; i++) {
			username += tempp[i].charAt(0);
		}
		
		return username.toLowerCase();
	}
}
