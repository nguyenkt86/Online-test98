package vn.com.itqnu.onlinetest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.com.itqnu.onlinetest.entity.Result;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {

}
