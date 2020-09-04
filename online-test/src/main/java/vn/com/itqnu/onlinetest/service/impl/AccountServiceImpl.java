package vn.com.itqnu.onlinetest.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.model.AccountModel;
import vn.com.itqnu.onlinetest.repository.AccountRepository;
import vn.com.itqnu.onlinetest.service.AccountService;
import vn.com.itqnu.onlinetest.utils.StringUtils;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;

	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public Account checkUsernameAndPassword(String username, String password) {
		Account account = accountRepository.findByUsername(username);

		if (username == null || username.trim().length() == 0) {
			throw new RuntimeException("Username is required!");
		}

		if (password == null || password.trim().length() == 0) {
			throw new RuntimeException("Password is required!");
		}

		if (account == null) {
			throw new RuntimeException("Username or password invalid!");
		}

		if (!account.getPassword().equals(password)) {
			throw new RuntimeException("Username or password invalid!");
		}

		return account;
	}

	@Override
	public Account createAccount(AccountModel accountModel) {
		if (accountModel.getFullName() == null || accountModel.getFullName().trim().length() == 0) {
			throw new RuntimeException("Full name is required!");
		}

		String username = StringUtils.generateUsernameFromFullName(accountModel.getFullName());

		// Check exist username, increment username vd: nguyentt -> nguyentt1ok
//		Account user = accountRepository.findByUsername(username);
//		String usernamet = user.getUsername();
//		if(usernamet.equals(username)) {
//			username = username + 1;	
//		}
//		username = username + 1;	
		Account account = new Account();
		account.setUsername(username);
		// Default password
		account.setPassword("123456");
		account.setFullName(accountModel.getFullName());
		account.setBirthday(accountModel.getBirthday());
		account.setGender(accountModel.isGender());
		account.setEmail(accountModel.getEmail());
		account.setPhone(accountModel.getPhone());
		account.setAddress(accountModel.getAddress());
		// Default role (tempt)
		account.setRoleId(1);

		// Tempt
		account.setCreatedBy("ADMIN");
		account.setCreatedDate(new Date());
		account.setModifiedBy("ADMIN");
		account.setModifiedDate(new Date());

		accountRepository.save(account);

		return account;
	}

	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}

	@Override
	public Account getAccountById(Long idAccount) {
		Optional<Account> optional = accountRepository.findById(idAccount);
		if (optional != null && optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	@Override
	public Account updateAccount(AccountModel accountModel) {
		Account account = getAccountById(accountModel.getId());
		if (account == null) {
			throw new RuntimeException("Account not exist!");
		}

		account.setBirthday(accountModel.getBirthday());
		account.setGender(accountModel.isGender());
		account.setEmail(accountModel.getEmail());
		account.setPhone(accountModel.getPhone());
		account.setAddress(accountModel.getAddress());
		// Default role (tempt)
		account.setRoleId(1);

		// Tempt
		account.setModifiedBy("ADMIN");
		account.setModifiedDate(new Date());

		accountRepository.save(account);

		return account;
	}

	@Override
	public void deleteAccount(Long idAccount) {
		Account account = getAccountById(idAccount);

		if (account == null) {
			throw new RuntimeException("Account not exist!");
		}

		accountRepository.delete(account);
	}

}
