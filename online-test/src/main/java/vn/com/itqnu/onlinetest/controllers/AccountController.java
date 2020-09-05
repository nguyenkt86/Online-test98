package vn.com.itqnu.onlinetest.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import vn.com.itqnu.onlinetest.entity.Account;
import vn.com.itqnu.onlinetest.helper.ExcelHelper;
import vn.com.itqnu.onlinetest.model.AccountModel;
import vn.com.itqnu.onlinetest.service.AccountService;
import vn.com.itqnu.onlinetest.utils.ResponseMessage;
import vn.com.itqnu.onlinetest.utils.ResponseUtil;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/accounts")
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, HttpServletRequest request) {
		try {
			Account account = accountService.checkUsernameAndPassword(username, password);
			HttpSession session = request.getSession();
			session.setAttribute("LoginSuccess", account);
			return ResponseUtil.getSuccess(account);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	@PostMapping("/login1")
	public ResponseEntity<?> login1(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password) {
		try {
			return ResponseEntity.ok(accountService.checkUsernameAndPassword(username, password));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logout(HttpStatus status, HttpServletRequest request) {
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("LoginSuccess");
			return ResponseUtil.getNormal(true, status.OK, "Logout", "Logout success!", null);
		} catch (Exception e) {
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountModel accountModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(accountService.createAccount(accountModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Create error", e.getMessage());
		}
	}
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";

	    if (ExcelHelper.hasExcelFormat(file)) {
	      try {
	        accountService.save(file);

	        message = "Uploaded the file successfully: " + file.getOriginalFilename();
	        return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	      } catch (Exception e) {
	        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	      }
	    }

	    message = "Please upload an excel file!";
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	  }

	@GetMapping
	public List<Account> getAllAccount() {
		return accountService.getAllAccount();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable(name = "id") Long idAccount, HttpStatus status) {
		try {

			return ResponseUtil.getSuccess(accountService.getAccountById(idAccount));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Get error", e.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<?> updateAccount(@RequestBody AccountModel accountModel, HttpStatus status) {
		try {
			return ResponseUtil.getSuccess(accountService.updateAccount(accountModel));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Update error", e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccountById(@PathVariable(name = "id") Long idAccount, HttpStatus status) {
		try {
			accountService.deleteAccount(idAccount);
			return ResponseUtil.getNormal(true, status, "Delete", "Delete success!", null);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseUtil.getError(status.BAD_REQUEST, "Delete error", e.getMessage());
		}
	}
}
