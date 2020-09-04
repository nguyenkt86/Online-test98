package vn.com.itqnu.onlinetest.utils;

import javax.servlet.http.HttpSession;

import vn.com.itqnu.onlinetest.entity.Account;

public class AppUtils {

	public static Account getAccountFromSession(HttpSession session) {
		Account account = (Account) session.getAttribute("LoginSuccess");
		if (account == null) {
			throw new RuntimeException("Please login!");
		}

		return account;
	}
}
