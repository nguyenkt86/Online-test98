package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUsername(String username);
}
