package vn.com.itqnu.onlinetest.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.model.AccountModel;

public interface AccountService {

	Account checkUsernameAndPassword(String username, String password);
	
	Account createAccount(AccountModel accountModel);

	List<Account> getAllAccount();

	Account getAccountById(Long idAccount);

	Account updateAccount(AccountModel accountModel);

	void deleteAccount(Long idAccount);
	void save(MultipartFile file) ;
}
